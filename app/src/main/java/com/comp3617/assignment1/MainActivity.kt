package com.comp3617.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.comp3617.assignment1.QuestionListActivity
import com.comp3617.assignment1.QuizContent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Pick a question"


        if(QUIZ_CONTENT.size == 0){
            QUIZ_CONTENT.add(QuizContent.Builder().setQuestion(getString(R.string.question_1)).setAnswer1(getString(R.string.question_1_answer_1)).setAnswer2(getString(R.string.question_1_answer_2)).setAnswer3(getString(R.string.question_1_answer_3)).setAnswer4(getString(R.string.question_1_answer_4)).setCorrectAnswer(3).build())
            QUIZ_CONTENT.add(QuizContent.Builder().setQuestion(getString(R.string.question_2)).setAnswer1(getString(R.string.question_2_answer_1)).setAnswer2(getString(R.string.question_2_answer_2)).setAnswer3(getString(R.string.question_2_answer_3)).setAnswer4(getString(R.string.question_2_answer_4)).setCorrectAnswer(4).build())
            QUIZ_CONTENT.add(QuizContent.Builder().setQuestion(getString(R.string.question_3)).setAnswer1(getString(R.string.question_3_answer_1)).setAnswer2(getString(R.string.question_3_answer_2)).setAnswer3(getString(R.string.question_3_answer_3)).setAnswer4(getString(R.string.question_3_answer_4)).setCorrectAnswer(1).build())
            QUIZ_CONTENT.add(QuizContent.Builder().setQuestion(getString(R.string.question_4)).setAnswer1(getString(R.string.question_4_answer_1)).setAnswer2(getString(R.string.question_4_answer_2)).setAnswer3(getString(R.string.question_4_answer_3)).setAnswer4(getString(R.string.question_4_answer_4)).setCorrectAnswer(4).build())
            QUIZ_CONTENT.add(QuizContent.Builder().setQuestion(getString(R.string.question_5)).setAnswer1(getString(R.string.question_5_answer_1)).setAnswer2(getString(R.string.question_5_answer_2)).setAnswer3(getString(R.string.question_5_answer_3)).setAnswer4(getString(R.string.question_5_answer_4)).setCorrectAnswer(4).build())
            QUIZ_CONTENT.add(QuizContent.Builder().setQuestion(getString(R.string.question_6)).setAnswer1(getString(R.string.question_6_answer_1)).setAnswer2(getString(R.string.question_6_answer_2)).setAnswer3(getString(R.string.question_6_answer_3)).setAnswer4(getString(R.string.question_6_answer_4)).setCorrectAnswer(4).build())
            QUIZ_CONTENT.add(QuizContent.Builder().setQuestion(getString(R.string.question_7)).setAnswer1(getString(R.string.question_7_answer_1)).setAnswer2(getString(R.string.question_7_answer_2)).setAnswer3(getString(R.string.question_7_answer_3)).setAnswer4(getString(R.string.question_7_answer_4)).setCorrectAnswer(1).build())
        }
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Are you trying to cheat by pressing the back button?", Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_question_list -> {
                Intent(this, QuestionListActivity::class.java).apply {
                    startActivity(this)
                }
                true
            }
            R.id.action_settings -> {
                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                    CURRENT_SCORE = 0
                    finish()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object{
        var CURRENT_SCORE = 0
        var QUIZ_CONTENT = ArrayList<QuizContent>()
    }
}