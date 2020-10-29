package com.ravitej.watchlist.repository

import com.ravitej.watchlist.model.QuizQuestion
import io.reactivex.rxjava3.core.Observable

interface QuizRepository {
    fun getQuizQuestions(): Observable<List<QuizQuestion>>
}