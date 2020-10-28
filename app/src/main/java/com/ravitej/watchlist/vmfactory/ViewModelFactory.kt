package com.ravitej.watchlist.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravitej.watchlist.viewmodel.UserViewModel

class ViewModelFactory private constructor() : ViewModelProvider.Factory {

    private object INSTANCE {
        val instance = ViewModelFactory()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel() as T
    }

    companion object {
        val instance: ViewModelFactory by lazy {
            INSTANCE.instance
        }
    }
}