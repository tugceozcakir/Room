package com.anilcaliskan.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    var userId: Int = 0,

    @ColumnInfo(name = "userName")
    var userName: String,

    @ColumnInfo(name = "userSurname")
    var userSurname: String
)