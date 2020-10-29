package com.ravitej.watchlist.viewmodel.impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ravitej.watchlist.model.QuizQuestion
import com.ravitej.watchlist.repository.QuizRepository
import com.ravitej.watchlist.viewmodel.UserViewModel

class UserViewModelImpl(
    private val repository: QuizRepository
) : ViewModel(), UserViewModel {

    private var _quizQuestions: MutableList<QuizQuestion> = mutableListOf()
    private var _currentQuestion: MutableLiveData<QuizQuestion> = MutableLiveData()
    private var _buttonText: MutableLiveData<String> = MutableLiveData()

    private var currentQuestionIndex: MutableLiveData<Int> = MutableLiveData();
    private var correctAnswers = 0

    private val currentQuestion = Transformations.switchMap(currentQuestionIndex) {
        _currentQuestion.value = _quizQuestions[it]
        _currentQuestion
    }

    private var buttonText = Transformations.switchMap(currentQuestionIndex) {
        if (it == _quizQuestions.size - 1) {
            _buttonText.value = "DONE"
        } else {
            _buttonText.value = "NEXT"
        }
        _buttonText
    }

    init {
        getQuizData();
    }

    private fun getQuizData() {
        repository.getQuizQuestions()
            .subscribe {
                Log.e("Check", "${it.size} values")
                _quizQuestions.addAll(it)
                currentQuestionIndex.value = 0
            }
    }

    override fun currentQuestion(): LiveData<QuizQuestion> {
        return currentQuestion
    }

    override fun buttonText(): LiveData<String> {
        return buttonText
    }

    override fun onNext() {
        currentQuestionIndex.value = currentQuestionIndex.value!! + 1
    }
}