package com.example.myapplication4

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserViewModel(application: Application) : ViewModel() {

    val userList: LiveData<List<UserEntity>>
    private val repository: UserRepository
    var userLogin by mutableStateOf("")
    var userPassword by mutableStateOf("")

    init {
        val userDb = AppDataBase.getInstance(application)
        val userDao = userDb.userDao()
        repository = UserRepository(userDao)
        userList = repository.userList
    }

    fun changeLogin(value: String){
        userLogin = value
    }

    fun changePassword(value: String){
        userPassword = value
    }

    fun addUser() {
        repository.insertNewUserEntity(UserEntity(userLogin, userPassword))
    }

}