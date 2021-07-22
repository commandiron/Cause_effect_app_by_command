package com.demirli.a5causeeffectexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class People(

    @PrimaryKey(autoGenerate = true)
    var pid: Int = 0,
    var name: String,
    var surname: String,
    var street: String,
    var city: String,
    var state: String,
    var country: String,
    var telephone: String,
    var birthday: String) {
}