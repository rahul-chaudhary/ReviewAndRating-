package com.example.reviewsandratings.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R

class ReviewCardAdapter(private val items: ArrayList<String>) : RecyclerView.Adapter<ReviewCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_card_item, parent, false)
        return ReviewCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ReviewCardViewHolder, position: Int) {
        val currentItem = items[position]
        holder.reviewerNameView.text = currentItem
    }
}

class ReviewCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val reviewerNameView: TextView = itemView.findViewById<TextView>(R.id.reviewerName)

}