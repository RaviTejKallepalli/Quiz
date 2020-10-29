package com.ravitej.watchlist.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravitej.watchlist.repository.impl.QuizRepositoryImpl
import com.ravitej.watchlist.viewmodel.impl.UserViewModelImpl

class ViewModelFactory private constructor() : ViewModelProvider.Factory {

    private object INSTANCE {
        val instance = ViewModelFactory()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModelImpl(QuizRepositoryImpl()) as T
    }

    companion object {
        val instance: ViewModelFactory by lazy {
            INSTANCE.instance
        }
    }
}