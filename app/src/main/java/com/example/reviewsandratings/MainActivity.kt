package com.example.reviewsandratings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reviewsandratings.adapters.RatingCircularPBarAdapter
import com.example.reviewsandratings.adapters.ReviewCardAdapter
import com.example.reviewsandratings.databinding.ActivityMainBinding

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
        val items = fetchRatingValueData()
        val itemsTitle = fetchRatingValueTitleData()
        val adapter: RatingCircularPBarAdapter = RatingCircularPBarAdapter(items, itemsTitle)
        progressRecyclerView.adapter = adapter

        //Card Data
        val reviewCardRecyclerView = mbinding.reviewsCardsRecyclerView
        reviewCardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val nameItem = fetchNameValueData()
        val reviewCardAdapter = ReviewCardAdapter(nameItem)
        reviewCardRecyclerView.adapter = reviewCardAdapter
    }

    private fun fetchRatingValueData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 10) {
            list.add("$i.1")
        }
        return list
    }

    private fun fetchRatingValueTitleData(): ArrayList<String> {
        val originalList = listOf(
            "Ambience",
            "Food",
            "Hygiene",
            "Music",
            "Pricing",
            "Service",
            "Staff",
            "Taste",
            "Value",
            "Variety"
        )
        return ArrayList(originalList)
    }

    private fun fetchNameValueData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 'a' until 'k') {
            list.add("Mr. AB$i Bhattacharya")
        }
        return list
    }
}