package com.comp3617.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.comp3617.assignment1.MainActivity.Companion.CURRENT_SCORE
import com.comp3617.assignment1.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class QuizEndFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.content)?.let {
            it.text = "Your final score is $CURRENT_SCORE"
        }

        view.findViewById<Button>(R.id.start_button).setOnClickListener {
            CURRENT_SCORE = 0
            findNavController().navigate(R.id.action_QuizEndFragment_to_QuizStartFragment)
        }
    }
}