package com.demirli.a5causeeffectexample.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.demirli.a5causeeffectexample.model.People

@Dao
interface PeopleDao {


    @Query("SELECT * FROM people")
    fun getAllPeople(): LiveData<List<People>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPeople(people: People)

    @Query("SELECT * FROM people WHERE pid= :pid")
    fun getPeople(pid: Int?): LiveData<People>

    @Query("DELETE FROM people WHERE pid= :pid")
    fun deletePeople(pid: Int?)


}