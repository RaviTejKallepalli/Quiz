package com.ravitej.watchlist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ravitej.watchlist.databinding.ActivityMainBinding
import com.ravitej.watchlist.viewmodel.UserViewModel
import com.ravitej.watchlist.vmfactory.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, ViewModelFactory.instance)
            .get(UserViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.toastLiveData()
            .observe(this, Observer<String> { t ->
                    Toast.makeText(this@MainActivity, t, Toast.LENGTH_SHORT).show()
                })
    }
}