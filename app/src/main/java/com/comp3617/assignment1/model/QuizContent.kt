package com.comp3617.assignment1.model

/**
 * QuizContent object used to provide data used in the question fragments
 *
 */
class QuizContent(var question : String, var answer1 : String, var answer2 : String, var answer3 : String, var answer4 : String, var correctAnswer : Int){
    private constructor(builder: Builder): this(builder.question, builder.answer1, builder.answer2, builder.answer3, builder.answer4, builder.correctAnswer)

    class Builder {
        var question: String = ""
            private set
        var answer1: String = ""
            private set
        var answer2: String = ""
            private set
        var answer3: String = ""
            private set
        var answer4: String = ""
            private set
        var correctAnswer: Int = 0
            private set

        fun build(): QuizContent {
            return QuizContent(this)
        }

        fun setQuestion(question: String): Builder {
            this.question = question
            return this
        }

        fun setAnswer1(answer: String): Builder {
            this.answer1 = answer
            return this
        }

        fun setAnswer2(answer: String): Builder {
            this.answer2 = answer
            return this
        }

        fun setAnswer3(answer: String): Builder {
            this.answer3 = answer
            return this
        }

        fun setAnswer4(answer: String): Builder {
            this.answer4 = answer
            return this
        }

        fun setCorrectAnswer(correctAnswer: Int): Builder {
            this.correctAnswer = correctAnswer
            return this
        }
    }
}