package com.example.reviewsandratings.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R

class RatingCircularPBarAdapter(val items: ArrayList<Double>, val itemsTitle: ArrayList<String>): RecyclerView.Adapter<RatingCircularPBarViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RatingCircularPBarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rating_circular_progress_bar_item, parent, false)
        return RatingCircularPBarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RatingCircularPBarViewHolder, position: Int) {
        val currentItem = items[position]
        val currentItem2 = itemsTitle[position]
        holder.ratingValueView.text = currentItem.toString()
        holder.ratingTitleView.text = currentItem2
    }
}


class RatingCircularPBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ratingValueView : TextView = itemView.findViewById(R.id.ratingValue)
    val ratingTitleView : TextView = itemView.findViewById(R.id.ratingTitle)
}