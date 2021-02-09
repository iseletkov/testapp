package com.example.application.view.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.application.R

class CActivityDetails : AppCompatActivity() {
    private lateinit var et1     : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        et1        = findViewById(R.id.et1)

        val message = intent.getStringExtra("Параметр")
        et1.setText(message)
    }
    fun onButtonInputPress(view: View)
    {
        val text = et1.text

        val intent = Intent("123").apply {
            putExtra("Параметр2", text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}