package com.ravitej.watchlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private var tapCount = 0
    private val toastLiveData: MutableLiveData<String> by lazy {
        MutableLiveData("")
    }

    fun toastLiveData(): LiveData<String> {
        return toastLiveData
    }

    fun tapHandle() {
        viewModelScope.launch {
            tapCount++
            delay(100)
            toastLiveData.value = ("$tapCount taps")
        }
    }
}