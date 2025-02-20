package com.cipherprojects.core.domain.auth

import android.util.Log
import com.cipherprojects.core.domain.models.User

class RegisterUserUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(user: User): User? {
        return try {
            val existingUser = repository.getUserByUsername(user.username)
            if (existingUser != null) {
                Log.e("Auth", "Registration failed. User already exists.")
                return null
            }

            val newUserId = repository.registerUser(user)

            if (newUserId > 0) {
                Log.d("Auth", "Registration successful.")

                val newUser = user.copy(id = newUserId.toInt())
                newUser
            } else {
                Log.e("Auth", "Registration failed. Unable to create user.")
                null
            }
        } catch (e: Exception) {
            Log.e("Auth", "Registration error: ${e.message}")
            null
        }
    }
}