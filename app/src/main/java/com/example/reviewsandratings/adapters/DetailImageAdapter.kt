package com.example.reviewsandratings.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R

class DetailImageAdapter(private val items: ArrayList<Int>) :
    RecyclerView.Adapter<DetailImageAdapter.DetailImageViewHolder>() {

    inner class DetailImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detailImageView: ImageView = itemView.findViewById(R.id.detailIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailImageViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_image_item, parent, false)
        return DetailImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DetailImageViewHolder, position: Int) {
        val currentItem = items[position]
        holder.detailImageView.setImageResource(currentItem)

    }
}