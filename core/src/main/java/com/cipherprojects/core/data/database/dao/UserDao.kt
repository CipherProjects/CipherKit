package com.cipherprojects.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cipherprojects.core.domain.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE username = :username AND password = :password")
    suspend fun loginUser(username: String, password: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerUser(user: User): Long

    @Query("SELECT * FROM User WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?
}