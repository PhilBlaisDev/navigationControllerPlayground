package com.comp3617.assignment1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.comp3617.assignment1.R
import com.comp3617.assignment1.activities.MainActivity.Companion.QUIZ_CONTENT

/**
 *  Activity with a Listview, which is the list of quiz questions
 */
class QuestionListActivity : AppCompatActivity() {

    /**
     * Sets Actionbar's title
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
        supportActionBar?.title = getString(R.string.cheat_sheet_title)

        setQuestionList()
    }

    /**
     * Populates the Listview with content taken from the QUIZ_CONTENT variable
     */
    private fun setQuestionList() {
        val listView = findViewById<ListView>(R.id.list_view)
        val itemList = ArrayList<String>()
        val answersList = ArrayList<String>()

        QUIZ_CONTENT.forEach {
            itemList.add(it.question)

            when (it.correctAnswer) {
                1 -> {
                    answersList.add(it.answer1)
                }
                2 -> {
                    answersList.add(it.answer2)
                }
                3 -> {
                    answersList.add(it.answer3)
                }
                4 -> {
                    answersList.add(it.answer4)
                }
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "The answer is: ${answersList[position]}", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Generates the Menu
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.cheat_sheet_menu, menu)
        return true
    }

    /**
     * Triggered when an MenuItem from the Menu is selected
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.quit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}