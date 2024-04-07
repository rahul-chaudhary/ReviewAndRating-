package com.example.reviewsandratings.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R
import com.google.android.material.chip.Chip

class FilterChipsAdapter(private val tags: ArrayList<String>): RecyclerView.Adapter<FilterChipsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterChipsViewHolder {
        val view = View.inflate(parent.context, R.layout.filter_chips_item, null)
        return FilterChipsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onBindViewHolder(holder: FilterChipsViewHolder, position: Int) {
        holder.filterChipView.text = tags[position]
    }
}

class FilterChipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val filterChipView: Chip = itemView.findViewById<Chip>(R.id.filterChip)
}