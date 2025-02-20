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

            val newUser = repository.registerUser(user)

            if (newUser != null) {
                Log.d("Auth", "Registration successful.")
            } else {
                Log.e("Auth", "Registration failed. Unable to create user.")
            }

            newUser
        } catch (e: Exception) {
            Log.e("Auth", "Registration error: ${e.message}")
            null
        }
    }
}