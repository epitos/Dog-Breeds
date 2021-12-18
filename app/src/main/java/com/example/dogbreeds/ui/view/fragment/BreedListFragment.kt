package com.example.dogbreeds.ui.view.fragment

import android.app.Activity
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreeds.R
import com.example.dogbreeds.ui.adapter.BreedListAdapter
import com.example.dogbreeds.ui.viewmodel.BreedListViewModel
import com.example.dogbreeds.utils.Status
import kotlinx.android.synthetic.main.fragment_breed_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class BreedListFragment: Fragment() {

    private val viewModel: BreedListViewModel by viewModel()
    private lateinit var adapter: BreedListAdapter
    private lateinit var activity: Activity
    private var breedList = arrayListOf<String>()
    private lateinit var message: com.example.dogbreeds.data.model.Message

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_breed_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity = requireActivity()
        toolbar.title = getString(R.string.app_name)
        setupUI()
        setObserver()
    }

    private fun setupUI() {
        breed_list.layoutManager = LinearLayoutManager(activity)
        adapter = BreedListAdapter(activity)
        breed_list.addItemDecoration(
            DividerItemDecoration(
                breed_list.context,
                (breed_list.layoutManager as LinearLayoutManager).orientation))
        breed_list.adapter = adapter
    }

    private fun setObserver() {
        viewModel.mainBreeds.observe(requireActivity(), {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { breedList ->
                        this.breedList = breedList
                        renderList(breedList, message)
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

        viewModel.subBreeds.observe(requireActivity(), {
            when (it.status) {
                Status.SUCCESS -> {
                    progress_bar.visibility = View.GONE
                    it.data?.let { message ->
                        this.message = message
                    }
                }

                Status.ERROR -> {
                    progress_bar.visibility = View.GONE
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

   private fun renderList(breedList: List<String>, message: com.example.dogbreeds.data.model.Message) {
        adapter.addBreeds(breedList, message)
        adapter.notifyDataSetChanged()
   }
}