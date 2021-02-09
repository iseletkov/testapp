package com.example.application.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application.R
import com.example.application.model.CComment
import com.example.application.view.adapters.CRVAdapterComments
import kotlinx.android.synthetic.main.activity_list.*
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class CActivityList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val comments                        = ArrayList<CComment>()
        comments.add(CComment("Пушкин А.С.", "Я не плохой поэт", LocalDateTime.parse("1738-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
        comments.add(CComment("123", "456", LocalDateTime.parse("2021-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
        comments.add(CComment("Вася Пупкин", "Мне нравится Пушкин", LocalDateTime.parse("2020-12-03T11:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME)))

        recyclerView_comments.layoutManager = LinearLayoutManager(this)

        recyclerView_comments.adapter = CRVAdapterComments(comments) { comment -> onCommentClick(comment) }

    }

    private fun onCommentClick(comment: CComment) {
        val x = 1
        /*val intent = Intent(this, CActivityDetails::class.java).apply {
            putExtra("Параметр", text.toString())
        }
        startForResult.launch(intent)*/
    }


    /*val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            //  you will get result here in result.data
            val outputId = findViewById<TextView>(R.id.textViewOutput)
        val message = result.data?.getStringExtra("Параметр2")?:"Нет результата"
        outputId.text = message
        }

    }*/

    /*fun onButtonInputPress(view: View)
    {
        val inputId = findViewById<EditText>(R.id.editTextInput)
        val text = inputId.text

        val intent = Intent(this, Activity2::class.java).apply {
           putExtra("Параметр", text.toString())
        }
        startForResult.launch(intent)
        //startActivityForResult()
    }*/

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