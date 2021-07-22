package com.demirli.a5causeeffectexample.ui.detail

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.demirli.a5causeeffectexample.data.PeopleDao
import com.demirli.a5causeeffectexample.data.PeopleDb
import com.demirli.a5causeeffectexample.model.People

class DetailRepository(context: Context) {
    private val db by lazy { PeopleDb.getInstance(context) }
    private val dao by lazy { db.peopleDao() }

    fun getPeople(pid: Int?): LiveData<People> = dao.getPeople(pid)

    fun deletePeople(pid: Int?) = DeleteAsyncTask(dao).execute(pid)


    private class DeleteAsyncTask(val dao:PeopleDao): AsyncTask<Int, Void, Void>() {
        override fun doInBackground(vararg params: Int?): Void? {
            dao.deletePeople(params[0])
            return null
        }
    }
}