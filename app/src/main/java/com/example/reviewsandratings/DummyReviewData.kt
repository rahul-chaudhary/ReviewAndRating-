package com.example.reviewsandratings

import com.example.reviewsandratings.adapters.ReviewCardAdapter
import com.example.reviewsandratings.adapters.getFilteredTags
import com.example.reviewsandratings.models.ReviewCardModel

object DummyReviewData {
    val ratingMap: HashMap<String, Double> = hashMapOf(
        "Ambience" to 4.5,
        "Service" to 3.5,
        "Food" to 5.0,
        "Price" to 4.0,
        "Cleanliness" to 3.0,
        "Taste" to 4.5,
        "Variety" to 3.5,
    )

    val reviewCardList: ArrayList<ReviewCardModel> = arrayListOf(
        ReviewCardModel(
            "Mr. Marty Robbins",
            "https://www.google.com",
            "12th June 2021",
            "Great Food",
            "Delicious dishes with excellent flavors. Must try!",
            "4.7",
            arrayListOf("Ambience", "Price")
        ),
        ReviewCardModel(
            "Mr. Bill Withers",
            "https://www.google.com",
            "12th June 2021",
            "Cozy Ambience",
            "Warm atmosphere, perfect for a relaxing meal with friends.",
            "4.3",
            arrayListOf("Service", "Cleanliness")
        ),
        ReviewCardModel(
            "Mr. Johnny Cash",
            "https://www.google.com",
            "12th June 2021",
            "Friendly Staff",
            "Attentive service and helpful staff made the dining experience enjoyable.",
            "4.5",
            arrayListOf("Food", "Variety")
        ),
        ReviewCardModel(
            "Mr. John Denver",
            "https://www.google.com",
            "12th June 2021",
            "Lovely Setting",
            "Charming decor and beautiful surroundings created a delightful dining ambiance.",
            "4.5",
            arrayListOf("Ambience", "Taste", "Service")
        ),
        ReviewCardModel(
            "Mr. Paul Anka",
            "https://www.google.com",
            "12th June 2021",
            "Tasty Treats",
            "Mouthwatering menu items that satisfied every craving.",
            "3.9",
            arrayListOf("Price", "Cleanliness")
        )
    )

    val tags: ArrayList<String> = arrayListOf(
        "Ambience",
        "Service",
        "Food",
        "Price",
        "Cleanliness",
        "Taste",
        "Variety"
    )
    val filteredTags = getFilteredTags() // Get the filtered tags

    // Filter the reviewCardList based on filteredTags
    val filteredReviewCardList = reviewCardList.filter { reviewCard ->
        reviewCard.reviewFilterTags.any { tag ->
            filteredTags.contains(tag)
        }
    }
}