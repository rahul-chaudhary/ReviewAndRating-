package com.example.reviewsandratings.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewsandratings.DummyReviewData
import com.example.reviewsandratings.DummyReviewData.selectedTags
import com.example.reviewsandratings.R
import com.google.android.material.chip.Chip
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FilterChipsAdapter(
    private val tags: ArrayList<String>,
    private var reviewCardAdapter: ReviewCardAdapter,
    private val reviewCardRecyclerView: RecyclerView
) :
    RecyclerView.Adapter<FilterChipsViewHolder>() {
    private val selectedChips = arrayListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterChipsViewHolder {
        return FilterChipsViewHolder(View.inflate(parent.context, R.layout.filter_chips_item, null))
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onBindViewHolder(holder: FilterChipsViewHolder, position: Int) {
        val tag = tags[position]
        holder.filterChipView.text = tag

        var isSelected = false
        // Set click listener for chip selection/deselection
        holder.filterChipView.setOnClickListener { chip ->
            if(isSelected) {
                holder.filterChipView.setChipBackgroundColorResource(R.color.white)
                isSelected = false
            }
            else {
                holder.filterChipView.setChipBackgroundColorResource(R.color.orange)
                isSelected = true
            }


            val chipText = holder.filterChipView.text.toString()
            if (selectedChips.contains(chipText)) {
                selectedChips.remove(chipText)
                selectedTags = selectedChips

                Log.d("FilterChipsAdapter", "Removed '$chipText' filter. New ArrayList: $selectedChips")
                Toast.makeText(chip.context, "Removed '$chipText' filter", Toast.LENGTH_SHORT).show()
                updateReviewCardAdapter()
            } else {
                selectedChips.add(chipText)
                selectedTags = selectedChips
                Log.d("FilterChipsAdapter", "Added '$chipText' filter. New ArrayList: $selectedChips")
                Toast.makeText(chip.context, "Added '$chipText' filter", Toast.LENGTH_SHORT).show()
                updateReviewCardAdapter()
            }

        }
    }
    private fun updateReviewCardAdapter() {
        CoroutineScope(Dispatchers.Main).launch {
            reviewCardRecyclerView.adapter = ReviewCardAdapter(DummyReviewData.getFilteredReviewCardList())
        }
    }
}

class FilterChipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val filterChipView: Chip = itemView.findViewById<Chip>(R.id.filterChip)
}

