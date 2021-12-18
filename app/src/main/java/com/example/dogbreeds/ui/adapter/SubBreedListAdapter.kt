package com.example.dogbreeds.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreeds.R
import com.example.dogbreeds.ui.view.activity.MainActivity

class SubBreedListAdapter(private val context: Context,
                          private val mainBreedName: String,
                          private val subBreedList: List<String>):
    RecyclerView.Adapter<SubBreedListAdapter.SubBreedListViewHolder>()  {

    class SubBreedListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subBreedName: TextView = itemView.findViewById(R.id.sub_breed_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SubBreedListViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.subbreed_item, parent, false))

    override fun onBindViewHolder(holder: SubBreedListViewHolder, position: Int) {
        holder.subBreedName.text = subBreedList[position]

        holder.subBreedName.setOnClickListener {
            (context as MainActivity).loadFragment(mainBreedName, subBreedList[position])
        }
    }

    override fun getItemCount() = subBreedList.size
}