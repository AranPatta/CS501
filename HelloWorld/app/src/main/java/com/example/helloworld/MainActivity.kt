package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button and text view by their IDs
        val button: Button = findViewById(R.id.button2)
        val textView: TextView = findViewById(R.id.textView)

        // Set an OnClickListener on the button
        button.setOnClickListener {
            // Make the TextView visible
            textView.visibility = View.VISIBLE
            // You can also change the text if needed
            // textView.text = "New Text Here"
        }
    }


}