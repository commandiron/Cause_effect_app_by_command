package com.demirli.a5causeeffectexample.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.demirli.a5causeeffectexample.model.People

@Database(entities = arrayOf(People::class), version = 1)
abstract class PeopleDb: RoomDatabase() {
    abstract fun peopleDao(): PeopleDao

    companion object {

        @Volatile
        var INSTANCE: PeopleDb? = null

        @Synchronized
        fun getInstance(context: Context): PeopleDb {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PeopleDb::class.java, "people_db")
                    .addCallback(roomDbCallback)
                    .build()
            }

            return INSTANCE as PeopleDb
        }

        private val roomDbCallback = object: RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(INSTANCE).execute()
            }
        }

        class PopulateAsyncTask(private val db: PeopleDb?): AsyncTask<Void, Void, Void>() {
            private val dao: PeopleDao? by lazy { db?.peopleDao() }
            override fun doInBackground(vararg params: Void?): Void? {
                var people = People(
                    name = "Command",
                    surname = "Iron",
                    street = "Erenkoy",
                    city = "İstanbul",
                    state = "Kadıköy",
                    country = "Türkiye",
                    telephone = "+905555555555",
                    birthday = "30.10.1989"
                )
                dao?.addPeople(people)

                var people2 = People(
                    name = "Solid",
                    surname = "Snake",
                    street = "Kızıltoprak",
                    city = "İstanbul",
                    state = "Kadıköy",
                    country = "Türkiye",
                    telephone = "unknown",
                    birthday = "11.12.1972"
                )
                dao?.addPeople(people2)

                var people3 = People(
                    name = "Sam",
                    surname = "Porter Bridges",
                    street = "Erenköy",
                    city = "İstanbul",
                    state = "Kadıköy",
                    country = "Türkiye",
                    telephone = "unknown",
                    birthday = "09.11.1970"
                )
                dao?.addPeople(people3)

                var people4 = People(
                    name = "Leonardo",
                    surname = "DiCaprio",
                    street = "unknown",
                    city = "Los Angeles",
                    state = "California",
                    country = "United States",
                    telephone = "unknown",
                    birthday = "11.11.1974"
                )
                dao?.addPeople(people4)

                var people5 = People(
                    name = "Celal",
                    surname = "Şengör",
                    street = "unknown",
                    city = "İstanbul",
                    state = "unknown",
                    country = "Türkiye",
                    telephone = "unknown",
                    birthday = "24.03.1955"
                )
                dao?.addPeople(people5)

                return null
            }
        }
    }
}