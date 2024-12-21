package com.example.myapplication4

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserEntity{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id") var id: Long = 0
    @ColumnInfo(name = "login") var login: String = ""
    @ColumnInfo(name = "password") var password: String = ""

    constructor() {}

    constructor(login: String, password: String) {
        this.login = login
        this.password = password
    }
}