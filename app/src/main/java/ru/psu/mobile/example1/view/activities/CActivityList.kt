package ru.psu.mobile.example1.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ru.psu.mobile.example1.model.CComment
import ru.psu.mobile.example1.view.adapters.CRVAdapterComments
import ru.psu.mobile.example1.viewmodel.CViewModelActivityList
import kotlinx.android.synthetic.main.activity_list.*
import ru.psu.mobile.example1.R


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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_list, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, CActivityMap::class.java)
        startActivity(intent)
        return true
    }



}