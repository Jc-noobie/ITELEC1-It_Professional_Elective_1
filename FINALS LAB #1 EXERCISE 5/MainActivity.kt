package com.example.usingimagecontrols

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import android.view.View

class MainActivity : AppCompatActivity() {

    private var currentIndex = 0
    private val images = intArrayOf(
        R.drawable.cat,
        R.drawable.cat2,
    )

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageSwitcher: ImageSwitcher = findViewById(R.id.imageSwitcher)
        val btnNext: Button = findViewById(R.id.btnNext)
        val btnPrevious: Button = findViewById(R.id.btnPrevious)

        imageSwitcher.setFactory {
            val imageView = ImageView(applicationContext)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            imageView
        }

        imageSwitcher.setImageResource(images[currentIndex])

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            imageSwitcher.setImageResource(images[currentIndex])
            Toast.makeText(this, "Showing image ${currentIndex + 1}", Toast.LENGTH_SHORT).show()
        }

        btnPrevious.setOnClickListener {
            currentIndex = if (currentIndex - 1 < 0) images.size - 1 else currentIndex - 1
            imageSwitcher.setImageResource(images[currentIndex])
            Toast.makeText(this, "Showing image ${currentIndex + 1}", Toast.LENGTH_SHORT).show()
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}