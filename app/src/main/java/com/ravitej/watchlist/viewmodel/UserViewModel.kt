package com.ravitej.watchlist.viewmodel

import androidx.lifecycle.LiveData
import com.ravitej.watchlist.model.QuizQuestion

interface UserViewModel {

    fun currentQuestion(): LiveData<QuizQuestion>

    fun buttonText(): LiveData<String>

    fun onNext()
}