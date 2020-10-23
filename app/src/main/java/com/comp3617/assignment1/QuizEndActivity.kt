package com.comp3617.assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.comp3617.assignment1.MainActivity.Companion.CURRENT_SCORE

class QuizEndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_end)

        supportActionBar?.title = getString(R.string.congratulations)

        if(CURRENT_SCORE < 3){
            findViewById<ImageView>(R.id.end_image).setImageResource(R.drawable.end_failed_image)
        } else{
            findViewById<ImageView>(R.id.end_image).setImageResource(R.drawable.end_image)
        }


        findViewById<TextView>(R.id.content)?.let {
            it.text = getString(R.string.final_score)
        }

        findViewById<TextView>(R.id.score)?.let {
            it.text = CURRENT_SCORE.toString()
        }

        findViewById<Button>(R.id.end_button).setOnClickListener {
            CURRENT_SCORE = 0
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        findViewById<Button>(R.id.share_button).setOnClickListener {
            startShareIntent()
        }
    }

    private fun startShareIntent() {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Your final score is $CURRENT_SCORE")
        sendIntent.type = "text/plain"
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }
    }
}