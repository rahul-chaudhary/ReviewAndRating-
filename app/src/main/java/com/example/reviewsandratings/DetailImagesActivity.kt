package com.example.reviewsandratings

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reviewsandratings.databinding.ActivityDetailImagesBinding

class DetailImagesActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityDetailImagesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityDetailImagesBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        val imageId = intent.getIntExtra("Image_id", 0)

        // Set the image to the ImageView
        mbinding.detailIV.setImageResource(imageId)

    }
}