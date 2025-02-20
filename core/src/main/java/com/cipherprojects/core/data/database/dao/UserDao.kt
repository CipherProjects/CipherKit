package com.cipherprojects.core.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cipherprojects.core.domain.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE username = :username AND password = :password")
    suspend fun loginUser(username: String, password: String): User?

    @Upsert
    suspend fun registerUser(user: User): User?

    @Query("SELECT * FROM User WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?
}