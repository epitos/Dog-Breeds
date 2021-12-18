package com.example.dogbreeds.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogbreeds.R

class BreedDetailsAdapter(private val context: Context):
    RecyclerView.Adapter<BreedDetailsAdapter.BreedDetailsViewHolder>() {

    private val breedImageList = arrayListOf<String>()

    class BreedDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedImg: ImageView = itemView.findViewById(R.id.breed_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BreedDetailsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.breed_image_item, parent, false))

    override fun onBindViewHolder(holder: BreedDetailsViewHolder, position: Int) {
        Glide.with(context)
            .load(breedImageList[position])
            .into(holder.breedImg)
    }

    override fun getItemCount() = breedImageList.size

    fun addBreedImages(breedImages: List<String>) {
        breedImageList.addAll(breedImages)
    }
}