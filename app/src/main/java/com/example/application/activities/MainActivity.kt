package com.example.application.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.application.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            //  you will get result here in result.data
            val outputId = findViewById<TextView>(R.id.textViewOutput)
        val message = result.data?.getStringExtra("Параметр2")?:"Нет результата"
        outputId.text = message
        }

    }

    fun onButtonInputPress(view: View)
    {
        val inputId = findViewById<EditText>(R.id.editTextInput)
        val text = inputId.text

        val intent = Intent(this, Activity2::class.java).apply {
           putExtra("Параметр", text.toString())
        }
        startForResult.launch(intent)
        //startActivityForResult()
    }

//    fun onActivityResult(
//        requestCode : Int,
//        resultCode : Int,
//        data : Intent
//    ) {
//        super.onActivityResult(requestCode, resultCode, data)
//        val outputId = findViewById<TextView>(R.id.textViewOutput)
//        val message = data.getStringExtra("Параметр2")
//        outputId.text = message
//    }




}