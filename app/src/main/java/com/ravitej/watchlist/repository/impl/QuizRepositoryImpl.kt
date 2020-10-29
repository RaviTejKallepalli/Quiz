package com.ravitej.watchlist.repository.impl

import com.ravitej.watchlist.model.QuizQuestion
import com.ravitej.watchlist.repository.QuizRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class QuizRepositoryImpl : QuizRepository {

    private val questions: MutableList<QuizQuestion> = mutableListOf()

    override fun getQuizQuestions(): Observable<List<QuizQuestion>> {
        return Observable.fromCallable { prepareQuestionForQuiz() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    private fun prepareQuestionForQuiz(): List<QuizQuestion> {
        questions.add(
            QuizQuestion(
                "What is my first name?",
                listOf("Ravi tej", "Tej", "Kallepalli", "Ravi Tej Kallepalli"),
                0
            )
        )
        questions.add(
            QuizQuestion(
                "What is my Last name?",
                listOf("Ravi tej", "Tej", "Kallepalli", "No idea"),
                2
            )
        )
        questions.add(
            QuizQuestion(
                "What is my highest degree?",
                listOf("Masters", "CS", "Masters in CS", "Bachelors"),
                2
            )
        )
        return questions
    }
}