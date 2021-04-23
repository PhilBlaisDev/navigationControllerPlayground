package com.comp3617.assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.comp3617.assignment1.R
import com.comp3617.assignment1.activities.MainActivity
import com.comp3617.assignment1.activities.MainActivity.Companion.CURRENT_SCORE

/**
 * Question 3 fragment [Fragment] subclass as the fourth destination in the navigation.
 * contentIndex field Int used to fetch data from QUIZ_CONTENT
 */
class Question3Fragment : Fragment() {
    private var contentIndex = 2
    private lateinit var questionImage: ImageView

    /**
     * Creates view and populates toolbar's title
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = getString(
            R.string.question_3_title
        )
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    /**
     * Populates question image, question TextView and radio buttons text
     * question image is different if CURRENT_SCORE is higher than 1
     *
     * Action button validates if a radio has been selected and increments and
     * goes to following question fragment
     *
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionImage = view.findViewById(R.id.question_image)

        if(CURRENT_SCORE > 1){
            questionImage.setImageResource(R.drawable.no_jedi)
        } else{
            questionImage.setImageResource(R.drawable.q3_image)
        }

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
                            CURRENT_SCORE++
                        }
                        findNavController().navigate(R.id.action_Question3Fragment_to_Question4Fragment)
                    }
                    R.id.radioButton2 -> {
                        if (MainActivity.QUIZ_CONTENT[contentIndex].correctAnswer == 2) {
                            CURRENT_SCORE++
                        }
                        findNavController().navigate(R.id.action_Question3Fragment_to_Question4Fragment)
                    }
                    R.id.radioButton3 -> {
                        if (MainActivity.QUIZ_CONTENT[contentIndex].correctAnswer == 3) {
                            CURRENT_SCORE++
                        }
                        findNavController().navigate(R.id.action_Question3Fragment_to_Question4Fragment)
                    }
                    R.id.radioButton4 -> {
                        if (MainActivity.QUIZ_CONTENT[contentIndex].correctAnswer == 4) {
                            CURRENT_SCORE++
                        }
                        findNavController().navigate(R.id.action_Question3Fragment_to_Question4Fragment)
                    }
                }
            }
        }
    }

    /**
     * Saves state of contentIndex
     */
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("contentIndex", contentIndex)
        super.onSaveInstanceState(outState)
    }

    /**
     * Restores state of contentIndex
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        savedInstanceState?.getInt("contentIndex")?.let {
            contentIndex = it
        }
        super.onViewStateRestored(savedInstanceState)
    }
}