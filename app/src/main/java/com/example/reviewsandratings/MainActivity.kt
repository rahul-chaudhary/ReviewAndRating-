package com.example.reviewsandratings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reviewsandratings.adapters.RatingCircularPBarAdapter
import com.example.reviewsandratings.adapters.ReviewCardAdapter
import com.example.reviewsandratings.databinding.ActivityMainBinding
import com.example.reviewsandratings.DummyReviewData.ratingProgressBarData
import com.example.reviewsandratings.DummyReviewData.tags
import com.example.reviewsandratings.adapters.FilterChipsAdapter
import com.example.reviewsandratings.models.RatingCPBarModel
import com.example.reviewsandratings.models.ReviewCardModel

class MainActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        //Rating Progress Bar Data
        val progressRecyclerView = mbinding.ratingCircularProgressRecyclerView
        progressRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val items = fetchRatingData()
        val adapter: RatingCircularPBarAdapter = RatingCircularPBarAdapter(items)
        progressRecyclerView.adapter = adapter

        //Card Data
        val reviewCardRecyclerView = mbinding.reviewsCardsRecyclerView
        reviewCardRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        val reviewCardList = fetchCardData()
        val reviewCardAdapter = ReviewCardAdapter(fetchCardData())
        reviewCardRecyclerView.adapter = reviewCardAdapter



        //Filter Chips Recyclerview
        val filterChipsRecyclerview = mbinding.filterChipsRecyclerView
        filterChipsRecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val tagsItem = fetchTags()
        val filterChipsAdapter = FilterChipsAdapter(tagsItem, reviewCardAdapter, reviewCardRecyclerView)
        filterChipsRecyclerview.adapter = filterChipsAdapter


    }

//fetches rating data for rating progress bar recyclerview/adapter
    private fun fetchRatingData(): ArrayList<RatingCPBarModel> {
        return ratingProgressBarData
    }

    //fetch card data from DummyReviewData for review cards recyclerview/adapter
    private fun fetchCardData(): ArrayList<ReviewCardModel> {
        return DummyReviewData.getFilteredReviewCardList()
    }

    //fetch tags from DummyReviewData for filter chips recyclerview/adapter
    private fun fetchTags(): ArrayList<String> {
        return tags
    }
}