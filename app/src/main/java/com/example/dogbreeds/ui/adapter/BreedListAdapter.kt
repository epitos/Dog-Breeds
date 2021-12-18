package com.example.dogbreeds.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreeds.R
import com.example.dogbreeds.data.model.Message
import com.example.dogbreeds.ui.view.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_breed_list.*

class BreedListAdapter(private val context: Context):
    RecyclerView.Adapter<BreedListAdapter.BreedListViewHolder>()  {

    private val breedList = arrayListOf<String>()
    private lateinit var message: Message
    private lateinit var adapter: SubBreedListAdapter

    class BreedListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedName: TextView = itemView.findViewById(R.id.breed_name)
        val subBreedList: RecyclerView = itemView.findViewById(R.id.sub_breed_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BreedListViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.breed_item, parent, false))

    override fun onBindViewHolder(holder: BreedListViewHolder, position: Int) {
        holder.breedName.text = breedList[position]
        setSubBreedList(position, holder.breedName.text.toString(), holder.subBreedList)

        holder.breedName.setOnClickListener {
            (context as MainActivity).loadFragment(breedList[position])
        }
    }

    override fun getItemCount() = breedList.size

    private fun setSubBreedList(position: Int, mainBreedName: String, subBreedList: RecyclerView) {
        when(position) {
            5 -> {
                subBreedList.visibility = View.VISIBLE
                adapter = SubBreedListAdapter(context, mainBreedName, message.australian)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            14 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.buhund)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            15 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.bulldog)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            16 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.bullterrier)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            17 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.cattledog)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            22 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.corgi)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            26 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.deerhound)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            30 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.elkhound)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            33 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.finnish)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            34 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.frise)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            36 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.greyhound)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            39 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.hound)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            52 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.mastiff)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            55 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.mountain)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            58 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.ovcharka)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            62 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.pinscher)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            64 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.pointer)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            66 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.poodle)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            71 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.retriever)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            72 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.ridgeback)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            77 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.schnauzer)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            78 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.setter)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            79 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.sheepdog)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            82 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.spaniel)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            83 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.springer)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            85 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.terrier)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            88 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.waterdog)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
            91 -> {
                subBreedList.visibility = View.VISIBLE
                val adapter = SubBreedListAdapter(context, mainBreedName, message.wolfhound)
                subBreedList.layoutManager = LinearLayoutManager(context)
                subBreedList.adapter = adapter
            }
        }
    }

    fun addBreeds(breeds: List<String>, message: Message) {
        breedList.addAll(breeds)
        this.message = message
    }
}