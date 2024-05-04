package com.example.reviewsandratings.models

data class ReviewCardModel(
    val reviewerName : String,
    val reviewerProfileImageURL: String,
    val reviewDate: String,
    val reviewTitle: String,
    val reviewDescription: String,
    val reviewRating: String,
    val reviewFilterTags: ArrayList<String>,
    val reviewImages: ArrayList<Int>
)
