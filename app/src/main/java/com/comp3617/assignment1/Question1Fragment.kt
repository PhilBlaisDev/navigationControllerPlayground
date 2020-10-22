package com.comp3617.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.comp3617.assignment1.MainActivity.Companion.CURRENT_SCORE
import com.comp3617.assignment1.MainActivity.Companion.QUIZ_CONTENT
import com.comp3617.assignment1.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Question1Fragment : Fragment() {
    private val contentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.question)?.let {
            it.text = QUIZ_CONTENT[contentIndex].question
        }

        view.findViewById<RadioButton>(R.id.radioButton1)?.let {
           it.text = QUIZ_CONTENT[contentIndex].answer1
        }

        view.findViewById<RadioButton>(R.id.radioButton2)?.let {
            it.text = QUIZ_CONTENT[contentIndex].answer2
        }

        view.findViewById<RadioButton>(R.id.radioButton3)?.let {
            it.text = QUIZ_CONTENT[contentIndex].answer3
        }

        view.findViewById<RadioButton>(R.id.radioButton4)?.let {
            it.text = QUIZ_CONTENT[contentIndex].answer4
        }


        view.findViewById<Button>(R.id.action_button).setOnClickListener {
            view.findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId.let { checkId ->
               if(checkId == -1){
                  Toast.makeText(context, "Please select an answer", Toast.LENGTH_LONG).show()
               } else {
                   if(checkId == QUIZ_CONTENT[contentIndex].correctAnswer){
                       CURRENT_SCORE += 1
                   }
                   findNavController().navigate(R.id.action_Question1Fragment_to_Question2Fragment)
               }
            }
        }
    }
}