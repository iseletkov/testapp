package com.example.application.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application.R
import com.example.application.model.CComment
import com.example.application.view.adapters.CRVAdapterComments
import com.example.application.viewmodel.CViewModelActivityList
import kotlinx.android.synthetic.main.activity_list.*
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter


class CActivityList : AppCompatActivity() {
    private lateinit var mViewModel: CViewModelActivityList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        mViewModel = ViewModelProviders.of(this).get(CViewModelActivityList::class.java)



        recyclerView_comments.layoutManager = LinearLayoutManager(this)
        val adapter = CRVAdapterComments() { comment -> onCommentClick(
            comment
        ) }
        recyclerView_comments.adapter = adapter

        mViewModel.comments.observe(this,
            { item -> // Update the cached copy of the words in the adapter.
                adapter.setWords(item)
            })
    }
    fun onFabPlusClick(view: View) {
        mViewModel.insert( CComment(
            null,
            "123113123", "adadadawdawdawd", "Это дата"
        ))
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