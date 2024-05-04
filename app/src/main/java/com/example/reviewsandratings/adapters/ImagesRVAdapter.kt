package com.example.reviewsandratings.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R

class ImagesRVAdapter(private val items: ArrayList<Int>) : RecyclerView.Adapter<ImagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val view = View.inflate(parent.context, R.layout.images_rv_item, null)
        return ImagesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.imgView.setImageResource(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ImagesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
    val imgView: ImageView = itemView.findViewById(R.id.imgView)
}
