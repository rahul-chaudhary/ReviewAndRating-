package com.example.reviewsandratings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reviewsandratings.DummyReviewData.filteredReviewCardList
import com.example.reviewsandratings.adapters.RatingCircularPBarAdapter
import com.example.reviewsandratings.adapters.ReviewCardAdapter
import com.example.reviewsandratings.databinding.ActivityMainBinding
import com.example.reviewsandratings.DummyReviewData.ratingMap
import com.example.reviewsandratings.DummyReviewData.reviewCardList
import com.example.reviewsandratings.DummyReviewData.tags
import com.example.reviewsandratings.adapters.FilterChipsAdapter
import com.example.reviewsandratings.models.ReviewCardModel

class MainActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityMainBinding
//    private lateinit var Tagbinding: =
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        //Rating Progress Bar Data
        val progressRecyclerView = mbinding.ratingCircularProgressRecyclerView
        progressRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val items = fetchRatingValueData()
        val itemsTitle = fetchRatingValueTitleData()
        val adapter: RatingCircularPBarAdapter = RatingCircularPBarAdapter(items, itemsTitle)
        progressRecyclerView.adapter = adapter

        //Card Data
        val reviewCardRecyclerView = mbinding.reviewsCardsRecyclerView
        reviewCardRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val reviewCardList = fetchCardData()
        val reviewCardAdapter = ReviewCardAdapter(reviewCardList)
        reviewCardRecyclerView.adapter = reviewCardAdapter



        //Filter Chips Recyclerview
        val filterChipsRecyclerview = mbinding.filterChipsRecyclerView
        filterChipsRecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val tagsItem = fetchTags()
        val filterChipsAdapter = FilterChipsAdapter(tagsItem, reviewCardAdapter)
        filterChipsRecyclerview.adapter = filterChipsAdapter




    }




    private fun fetchRatingValueData(): ArrayList<Double> {
        return ArrayList(ratingMap.values)
    }

    private fun fetchRatingValueTitleData(): ArrayList<String> {
        return ArrayList(ratingMap.keys)
    }

    //fetch card data from DummyReviewData for review cards recyclerview/adapter
    private fun fetchCardData(): ArrayList<ReviewCardModel> {
        return if(filteredReviewCardList.isEmpty()){
            reviewCardList
        } else {
            ArrayList(filteredReviewCardList)
        }

    }
    //fetch tags from DummyReviewData for filter chips recyclerview/adapter
    private fun fetchTags(): ArrayList<String> {
        return tags
    }
    //fetches the tags list for ReviewCards
    private fun fetchFilteredTags(): ArrayList<ReviewCardModel> {
        return reviewCardList
    }
}