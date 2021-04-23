package com.comp3617.week6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.content, DynamicFragment.newInstance("Hello, this is content that was passed to my Fragment from the Activity", ""))
                .commit()
        }
    }
}