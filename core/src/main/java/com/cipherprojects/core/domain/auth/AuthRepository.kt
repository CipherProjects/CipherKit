package com.cipherprojects.core.domain.auth

import com.cipherprojects.core.domain.models.User

interface AuthRepository {

    suspend fun loginUser(username: String, password: String): User?

    suspend fun registerUser(user: User): User?

    suspend fun getUserByUsername(username: String): User?
}