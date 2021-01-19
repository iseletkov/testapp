package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonInputPress(view: View)
    {
        val inputId = findViewById<EditText>(R.id.editTextInput)
        val outputId = findViewById<TextView>(R.id.textViewOutput)

        val text = inputId.text
        outputId.text = text
    }
}