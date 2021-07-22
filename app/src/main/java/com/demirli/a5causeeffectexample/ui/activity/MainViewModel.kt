package com.demirli.a5causeeffectexample.ui.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.demirli.a5causeeffectexample.model.People

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MainRepository by lazy { MainRepository(application) }

    val getAllPeople: LiveData<List<People>> by lazy { repository.getAllPeople() }
}