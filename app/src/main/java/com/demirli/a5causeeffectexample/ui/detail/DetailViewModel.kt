package com.demirli.a5causeeffectexample.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.demirli.a5causeeffectexample.model.People

class DetailViewModel(application: Application): AndroidViewModel(application) {
    private val repository: DetailRepository by lazy { DetailRepository(application) }

    fun getPeople(pid: Int?): LiveData<People> = repository.getPeople(pid)

    fun deletePeople(pid: Int?) = repository.deletePeople(pid)
}