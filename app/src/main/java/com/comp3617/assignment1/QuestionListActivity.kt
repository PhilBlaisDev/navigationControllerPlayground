package com.comp3617.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.comp3617.assignment1.MainActivity.Companion.QUIZ_CONTENT

class QuestionListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
        val listView = findViewById<ListView>(R.id.list_view)
        val itemList = ArrayList<String>()

        QUIZ_CONTENT.forEach {
            itemList.add(it.question)
            println("itemList it.question =${it.question}")
        }


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "You have chosen : ${itemList[position]}", Toast.LENGTH_LONG).show()
        }
    }
}