package com.example.myapplication4

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IUserDao {

    @Query("SELECT * FROM users")
    fun getAllUser(): LiveData<List<UserEntity>>

    @Insert
    fun insert(userEntity: UserEntity)

}
