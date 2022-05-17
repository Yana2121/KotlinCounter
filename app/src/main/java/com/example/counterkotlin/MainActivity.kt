package com.example.counterkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var counterText: TextView
    private lateinit var counterButton: Button

    var timesClicked = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.counterText);
        counterButton = findViewById(R.id.counterButton);


        counterButton.setOnClickListener {
            timesClicked += 1
            counterText.text = timesClicked.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val userName = timesClicked
        outState.putInt("saveCounter", timesClicked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val counter = savedInstanceState.getInt("saveCounter", 0)
        timesClicked = counter;
        counterText.text = timesClicked.toString();
    }
}