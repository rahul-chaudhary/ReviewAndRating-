package com.example.reviewsandratings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reviewsandratings.adapters.RatingCircularPBarAdapter
import com.example.reviewsandratings.adapters.ReviewCardAdapter
import com.example.reviewsandratings.databinding.ActivityMainBinding
import com.example.reviewsandratings.dummyData.ratingMap
import com.example.reviewsandratings.dummyData.reviewCardList
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

        //chips
        mbinding.chip1.setOnClickListener {

        }
    }

    private fun fetchRatingValueData(): ArrayList<Double> {
        return ArrayList(ratingMap.values)
    }

    private fun fetchRatingValueTitleData(): ArrayList<String> {
        return ArrayList(ratingMap.keys)
    }

    private fun fetchNameValueData(): ArrayList<ReviewCardModel> {
        return reviewCardList
//        val list = ArrayList<String>()
//        for (i in 'a' until 'k') {
//            list.add("Mr. AB$i Bhattacharya")
//        }
//        return list
    }
}