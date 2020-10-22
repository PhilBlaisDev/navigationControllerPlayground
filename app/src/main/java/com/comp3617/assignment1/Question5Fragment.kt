package com.comp3617.assignment1

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.comp3617.assignment1.MainActivity.Companion.CURRENT_SCORE

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Question5Fragment : Fragment() {
    private var contentIndex = 4
    private lateinit var portraitImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        portraitImage = view.findViewById(R.id.portrait_image)
        portraitImage.setImageResource(R.drawable.q1_image)

        view.findViewById<TextView>(R.id.score)?.let {
            val text =  "Your score is $CURRENT_SCORE"
            it.text = text
        }

        view.findViewById<TextView>(R.id.question)?.let {
            it.text = MainActivity.QUIZ_CONTENT[contentIndex].question
        }

        view.findViewById<RadioButton>(R.id.radioButton1)?.let {
            it.text = MainActivity.QUIZ_CONTENT[contentIndex].answer1
        }

        view.findViewById<RadioButton>(R.id.radioButton2)?.let {
            it.text = MainActivity.QUIZ_CONTENT[contentIndex].answer2
        }

        view.findViewById<RadioButton>(R.id.radioButton3)?.let {
            it.text = MainActivity.QUIZ_CONTENT[contentIndex].answer3
        }

        view.findViewById<RadioButton>(R.id.radioButton4)?.let {
            it.text = MainActivity.QUIZ_CONTENT[contentIndex].answer4
        }
        view.findViewById<Button>(R.id.action_button).setOnClickListener {
            view.findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId.let { checkId ->
                when (checkId) {
                    -1 -> {
                        Toast.makeText(context, "Please select an answer", Toast.LENGTH_LONG).show()
                    }
                    R.id.radioButton1 -> {
                        if (MainActivity.QUIZ_CONTENT[contentIndex].correctAnswer == 1) {
                            CURRENT_SCORE += 1
                        }
                        findNavController().navigate(R.id.action_Question5Fragment_to_Question6Fragment)
                    }
                    R.id.radioButton2 -> {
                        if (MainActivity.QUIZ_CONTENT[contentIndex].correctAnswer == 2) {
                            CURRENT_SCORE += 1
                        }
                        findNavController().navigate(R.id.action_Question5Fragment_to_Question6Fragment)
                    }
                    R.id.radioButton3 -> {
                        if (MainActivity.QUIZ_CONTENT[contentIndex].correctAnswer == 3) {
                            CURRENT_SCORE += 1
                        }
                        findNavController().navigate(R.id.action_Question5Fragment_to_Question6Fragment)
                    }
                    R.id.radioButton4 -> {
                        if (MainActivity.QUIZ_CONTENT[contentIndex].correctAnswer == 4) {
                            CURRENT_SCORE += 1
                        }
                        findNavController().navigate(R.id.action_Question5Fragment_to_Question6Fragment)
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("contentIndex", contentIndex)

        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        savedInstanceState?.getInt("contentIndex")?.let {
            contentIndex = it
        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            portraitImage.visibility = View.GONE
        } else{
            portraitImage.visibility = View.VISIBLE
        }

        super.onViewStateRestored(savedInstanceState)
    }
}