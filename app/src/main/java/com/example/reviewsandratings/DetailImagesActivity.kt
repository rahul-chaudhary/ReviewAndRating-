package com.example.reviewsandratings


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.reviewsandratings.adapters.DetailImageAdapter
import com.example.reviewsandratings.databinding.ActivityDetailImagesBinding

class DetailImagesActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityDetailImagesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityDetailImagesBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        //setting the viewPager2
        mbinding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mbinding.viewPager2.adapter = DetailImageAdapter(DummyReviewData.foodImagesList)
    }
}
