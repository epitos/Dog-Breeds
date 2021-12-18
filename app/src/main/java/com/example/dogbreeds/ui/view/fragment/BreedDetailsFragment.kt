package com.example.dogbreeds.ui.view.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreeds.R
import com.example.dogbreeds.ui.adapter.BreedDetailsAdapter
import com.example.dogbreeds.ui.view.activity.MainActivity
import com.example.dogbreeds.ui.viewmodel.BreedDetailsViewModel
import com.example.dogbreeds.utils.Status
import kotlinx.android.synthetic.main.fragment_breed_details.*
import kotlinx.android.synthetic.main.fragment_breed_list.progress_bar
import org.koin.android.viewmodel.ext.android.viewModel

private const val ARG_SUB_BREED = "sub_breed"
private const val ARG_MAIN_BREED = "main_breed"
private const val ARG_IS_MAIN_BREED = "is_main_breed"

class BreedDetailsFragment: Fragment() {
    private var subBreedName: String? = null
    private var mainBreedName: String? = null
    private var isMainBreed: Boolean = false
    private val viewModel: BreedDetailsViewModel by viewModel()
    private lateinit var adapter: BreedDetailsAdapter
    private lateinit var activity: Activity

    companion object {
        @JvmStatic
        fun newInstance(mainBreed: String, isMainBreed: Boolean) =
            BreedDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MAIN_BREED, mainBreed)
                    putBoolean(ARG_IS_MAIN_BREED, isMainBreed)
                }
            }

        fun newInstance(mainBreed: String, subBreed: String, isMainBreed: Boolean) =
            BreedDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MAIN_BREED, mainBreed)
                    putString(ARG_SUB_BREED, subBreed)
                    putBoolean(ARG_IS_MAIN_BREED, isMainBreed)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            subBreedName = it.getString(ARG_SUB_BREED)
            mainBreedName = it.getString(ARG_MAIN_BREED)
            isMainBreed = it.getBoolean(ARG_IS_MAIN_BREED)
        }
        activity = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_breed_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isMainBreed) {
            toolbar.title = mainBreedName!!
        } else {
            toolbar.title = subBreedName!!
        }

        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(requireContext(),
            R.drawable.ic_action_name)
        toolbar.setNavigationOnClickListener {
            (context as MainActivity).loadFragment()
        }

        setupUI()
        setObserver()

        if (isMainBreed) {
            viewModel.getMainBreedImages(mainBreedName!!)
        } else {
            viewModel.getSubBreedImages(mainBreedName!!, subBreedName!!)
        }
    }

    private fun setupUI() {
        breed_img_list.layoutManager = LinearLayoutManager(activity)
        adapter = BreedDetailsAdapter(activity)
        breed_img_list.adapter = adapter
    }

    private fun setObserver() {
        viewModel.breedImages.observe(requireActivity(), {
            when (it.status) {
                Status.SUCCESS -> {
                    progress_bar.visibility = View.GONE
                    it.data?.let { breedImgList ->
                        renderList(breedImgList)
                    }
                }
                Status.LOADING -> {
                    progress_bar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    progress_bar.visibility = View.GONE
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(breedImgList: List<String>) {
        adapter.addBreedImages(breedImgList)
        adapter.notifyDataSetChanged()
    }
}