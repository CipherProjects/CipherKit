package com.cipherprojects.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cipherprojects.core.data.database.dao.UserDao
import com.cipherprojects.core.domain.models.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}