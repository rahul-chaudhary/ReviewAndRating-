package com.example.reviewsandratings.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.DetailImagesActivity
import com.example.reviewsandratings.R

class ImagesRVAdapter(private val items: ArrayList<Int>) : RecyclerView.Adapter<ImagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val view = View.inflate(parent.context, R.layout.images_rv_item, null)
        return ImagesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val currentItem = items[position]
        holder.imgView.setImageResource(currentItem)
        holder.imgView.setOnClickListener {
            val cntxt = it.context
            Toast.makeText(cntxt, "Image $position clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(cntxt, DetailImagesActivity::class.java)
            startActivity(cntxt , intent, null)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ImagesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
    val imgView: ImageView = itemView.findViewById(R.id.imgView)
}
