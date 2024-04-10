package com.example.reviewsandratings.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R
import com.example.reviewsandratings.models.RatingCPBarModel

class RatingCircularPBarAdapter(val items: ArrayList<RatingCPBarModel>) :
    RecyclerView.Adapter<RatingCircularPBarViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RatingCircularPBarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rating_circular_progress_bar_item, parent, false)
        return RatingCircularPBarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: RatingCircularPBarViewHolder, position: Int) {
        val ratingValue = items[position].rating
        val ratingTitle = items[position].title
        val ratingProgressBar = ratingValue / 5 * 100
        holder.ratingValueView.text = ratingValue.toString()
        holder.ratingTitleView.text = ratingTitle

        //Call requires API level 24 (current min is 21): android.widget.ProgressBar#setProgress
        holder.ratingProgressBarView.setProgress(ratingProgressBar.toInt(), false)

    }
}


class RatingCircularPBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ratingValueView: TextView = itemView.findViewById(R.id.ratingValue)
    val ratingTitleView: TextView = itemView.findViewById(R.id.ratingTitle)
    val ratingProgressBarView: ProgressBar =
        itemView.findViewById(R.id.circularProgressBar)
}