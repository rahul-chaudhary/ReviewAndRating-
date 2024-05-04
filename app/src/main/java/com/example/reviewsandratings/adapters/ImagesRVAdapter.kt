package com.example.reviewsandratings.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R

class ImagesRVAdapter(private val items: ArrayList<Int>) : RecyclerView.Adapter<ImagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val view = View.inflate(parent.context, R.layout.images_rv_item, null)
        return ImagesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val currentPos = items[position]
        holder.imgView.setImageResource(currentPos)
        holder.imgView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Image $position clicked", Toast.LENGTH_SHORT).show()
            
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ImagesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
    val imgView: ImageView = itemView.findViewById(R.id.imgView)
}
