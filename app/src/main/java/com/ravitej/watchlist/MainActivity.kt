package com.ravitej.watchlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ravitej.watchlist.databinding.ActivityMainBinding
import com.ravitej.watchlist.viewmodel.UserViewModel
import com.ravitej.watchlist.viewmodel.impl.UserViewModelImpl
import com.ravitej.watchlist.vmfactory.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, ViewModelFactory.instance)
            .get(UserViewModelImpl::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}