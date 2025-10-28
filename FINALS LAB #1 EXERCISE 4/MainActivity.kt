package com.example.workingwithbuttoncontrols

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnStandard: Button = findViewById(R.id.btnStandard)
        val btnImage: ImageButton = findViewById(R.id.btnImage)
        val btnToggle: ToggleButton = findViewById(R.id.btnToggle)

        btnStandard.setOnClickListener {
            Toast.makeText(this, "Button was clicked", Toast.LENGTH_SHORT).show()
        }

        btnImage.setOnClickListener {
            Toast.makeText(this, "Image button was clicked", Toast.LENGTH_SHORT).show()
        }

        btnToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}