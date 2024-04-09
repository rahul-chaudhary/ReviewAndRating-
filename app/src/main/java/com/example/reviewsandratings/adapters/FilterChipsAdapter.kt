package com.example.reviewsandratings.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.R
import com.google.android.material.chip.Chip

private val filteredTags = arrayListOf<String>()
class FilterChipsAdapter(private val tags: ArrayList<String>, private val reviewCardAdapter: ReviewCardAdapter) :
    RecyclerView.Adapter<FilterChipsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterChipsViewHolder {
        val view = View.inflate(parent.context, R.layout.filter_chips_item, null)
        return FilterChipsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onBindViewHolder(holder: FilterChipsViewHolder, position: Int) {
        val tag = tags[position]
        holder.filterChipView.text = tag

        holder.filterChipView.setOnClickListener {
            it.isActivated = !it.isActivated
            if (it.isActivated) {
                filteredTags.add(tag)
            } else {
                filteredTags.remove(tag)
            }
            Log.d("Filtered Tags", filteredTags.toString())
            Toast.makeText(it.context, "Filtered Tags: $filteredTags", Toast.LENGTH_SHORT).show()
            reviewCardAdapter.notifyDataSetChanged()
        }
    }
}

class FilterChipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val filterChipView: Chip = itemView.findViewById<Chip>(R.id.filterChip)
}

fun getFilteredTags(): ArrayList<String> {
    return filteredTags
}