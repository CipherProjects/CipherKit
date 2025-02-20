package com.cipherprojects.core.data.auth

import com.cipherprojects.core.data.database.dao.UserDao
import com.cipherprojects.core.domain.auth.AuthRepository
import com.cipherprojects.core.domain.models.User

class AuthRepositoryImpl(
    private val userDao: UserDao
) : AuthRepository {
    override suspend fun loginUser(username: String, password: String): User? {
        return userDao.loginUser(username = username, password = password)
    }

    override suspend fun registerUser(user: User): User? {
        return userDao.registerUser(user)
    }

    override suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }
}