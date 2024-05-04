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
        val imageList = arrayListOf(
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3
        )
        val viewPager2 = mbinding.viewPager2
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val viewPager2Adapter = DetailImageAdapter(imageList)
        viewPager2.adapter = viewPager2Adapter


    }
}

/*
         Set the image to the ImageView
        mbinding.detailIV.setImageResource(imageId)
        val imageId = intent.getIntExtra("Image_id", 0)

 */