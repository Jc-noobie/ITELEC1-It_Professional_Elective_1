package com.example.activitylifecycle

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("onCreate()")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }

    override fun onStart() {
        super.onStart()
        println("onStart()")
    }
    override fun onResume() {
        super.onResume()
        println("onResume()")
    }
    override fun onPause() {
        super.onPause()
        println("onPause()")
    }
    override fun onRestart() {
        super.onRestart()
        println("onRestart()")
    }
    override fun onStop() {
        super.onStop()
        println("onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy()")
    }



}