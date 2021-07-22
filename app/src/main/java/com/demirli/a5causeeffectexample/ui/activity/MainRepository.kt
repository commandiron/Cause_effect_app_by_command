package com.demirli.a5causeeffectexample.ui.activity

import android.content.Context
import androidx.lifecycle.LiveData
import com.demirli.a5causeeffectexample.data.PeopleDb
import com.demirli.a5causeeffectexample.model.People

class MainRepository(context: Context) {
        private val db by lazy { PeopleDb.getInstance(context) }
        private val dao by lazy { db.peopleDao() }

    fun getAllPeople(): LiveData<List<People>> = dao.getAllPeople()
}