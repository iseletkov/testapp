package com.example.application.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application.R
import com.example.application.model.CItem
import com.example.application.view.adapters.CRVAdapterItems
import kotlinx.android.synthetic.main.activity_list.*

class CActivityList : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    private val items                       = ArrayList<CItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        linearLayoutManager                 = LinearLayoutManager(this)
        rvItemList.layoutManager            = linearLayoutManager

        items.add(CItem("name1", "description1", 15))
        items.add(CItem("name2", "description2", 25))
        items.add(CItem("name3", "description3", 100))

        val adapter                         = CRVAdapterItems(items)
        rvItemList.adapter                  = adapter
    }

    /*val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
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
    }*/


}