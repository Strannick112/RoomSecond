package com.example.myapplication4

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UserRepository(private val userDao: IUserDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertNewUserEntity(userEntity: UserEntity){
        coroutineScope.launch(Dispatchers.IO) {
            userDao.insert(userEntity)
        }
    }

    val userList: LiveData<List<UserEntity>> = userDao.getAllUser()

//    suspend fun getAllUsersEntity(userId: Long): LiveData<List<UserEntity>> {
//        return withContext(Dispatchers.IO){
//            return@withContext userDao.getAllUser()
//        }
//    }

}