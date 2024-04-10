package com.example.reviewsandratings.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val currentItem = items[position].reviewerName
        holder.reviewerNameView.text = currentItem
        holder.timeAgoView.text = items[position].reviewDate
        holder.reviewTitleView.text = items[position].reviewTitle
        holder.reviewBodyView.text = items[position].reviewDescription
        holder.reviewRatingView.text = items[position].reviewRating
        holder.tagChipRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        val tagAdapter = TagChipsAdapter(items[position].reviewFilterTags)
        holder.tagChipRecyclerView.adapter = tagAdapter

    }
}

class ReviewCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val reviewerNameView: TextView = itemView.findViewById<TextView>(R.id.reviewerName)
    val timeAgoView: TextView = itemView.findViewById<TextView>(R.id.timeAgo)
    val reviewTitleView: TextView = itemView.findViewById<TextView>(R.id.reviewTitle)
    val reviewBodyView: TextView = itemView.findViewById<TextView>(R.id.reviewBody)
    val reviewRatingView: TextView = itemView.findViewById<TextView>(R.id.reviewerRating)

    //Tag chip
    val tagChipRecyclerView: RecyclerView = itemView.findViewById<RecyclerView>(R.id.tagChipRecyclerView)



}