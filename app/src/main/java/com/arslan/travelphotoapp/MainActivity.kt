package com.arslan.travelphotoapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImg = 0
    lateinit var image: ImageView
    var places = arrayOf("Minare Pakistan", "Badshahi Masjid", "Lahore Fort", "Andron Lahore")

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tvName)

        next.setOnClickListener {
            val idCurrentImgString = "pic$currentImg"
            val idCurrentImgInteger = this.resources.getIdentifier(idCurrentImgString, "id", packageName)
            image = findViewById(idCurrentImgInteger)
            image.alpha = 0f

            currentImg = (4 + currentImg + 1)%4
            val idImageToShowString = "pic$currentImg"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImg]

        }

        prev.setOnClickListener {

            val idCurrentImgString = "pic$currentImg"
            val idCurrentImgInt = this.resources.getIdentifier(idCurrentImgString, "id", packageName)
            image = findViewById(idCurrentImgInt)
            image.alpha = 0f

            currentImg = (4 + currentImg - 1)%4
            val idImageToShowString = "pic$currentImg"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImg]
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}