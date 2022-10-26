package com.anilcaliskan.room.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.anilcaliskan.room.model.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>
}