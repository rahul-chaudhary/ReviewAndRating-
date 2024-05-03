package com.example.reviewsandratings.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R
import com.google.android.material.chip.Chip

class TagChipsAdapter(private val items: ArrayList<String>): RecyclerView.Adapter<TagChipsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagChipsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tag_chip_item, parent, false)
        return TagChipsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TagChipsViewHolder, position: Int) {
    val currentItem = items[position]
        holder.tagChipView.text = currentItem
    }
}

class TagChipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tagChipView: Chip = itemView.findViewById<Chip>(R.id.tagChip)
}