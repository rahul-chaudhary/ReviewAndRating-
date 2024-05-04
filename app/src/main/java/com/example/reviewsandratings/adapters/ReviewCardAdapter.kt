package com.example.reviewsandratings.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.DetailImagesActivity
import com.example.reviewsandratings.R
import com.example.reviewsandratings.models.ReviewCardModel

class ReviewCardAdapter(private val items: ArrayList<ReviewCardModel>) : RecyclerView.Adapter<ReviewCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_card_item, parent, false)
        return ReviewCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ReviewCardViewHolder, position: Int) {
        val currentItem = items[position]
        holder.reviewerNameView.text = currentItem.reviewerName
        holder.timeAgoView.text = currentItem.reviewDate
        holder.reviewTitleView.text = currentItem.reviewTitle
        holder.reviewBodyView.text = currentItem.reviewDescription
        holder.reviewRatingView.text = currentItem.reviewRating
        //tag chip RV
        holder.tagChipRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        val tagAdapter = TagChipsAdapter(currentItem.reviewFilterTags)
        holder.tagChipRecyclerView.adapter = tagAdapter

        //Images RV
        holder.imagesRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        val imagesAdapter = ImagesRVAdapter(currentItem.reviewImages)
        holder.imagesRecyclerView.adapter = imagesAdapter
        imagesAdapter.onItemClick = {
            val intent = Intent(holder.itemView.context, DetailImagesActivity::class.java)
            intent.putExtra("Image_id", it)
            //            val intent = Intent(holder.itemView.context, DetailImagesActivity::class.java)
            startActivity(holder.itemView.context,intent, null)
        }
    }
}

class ReviewCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val reviewerNameView: TextView = itemView.findViewById(R.id.reviewerName)
    val timeAgoView: TextView = itemView.findViewById(R.id.timeAgo)
    val reviewTitleView: TextView = itemView.findViewById(R.id.reviewTitle)
    val reviewBodyView: TextView = itemView.findViewById(R.id.reviewBody)
    val reviewRatingView: TextView = itemView.findViewById(R.id.reviewerRating)

    //Tag chip
    val tagChipRecyclerView: RecyclerView = itemView.findViewById(R.id.tagChipRecyclerView)
    //Images RecyclerView
    val imagesRecyclerView: RecyclerView = itemView.findViewById(R.id.imagesRV)




}