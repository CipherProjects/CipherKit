package com.cipherprojects.core.domain.auth

import android.util.Log
import com.cipherprojects.core.domain.models.User

class LoginUserUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): User? {
        return try {
            val result = repository.loginUser(
                username = username,
                password = password
            )
            if (result != null) {
                Log.d("Auth", "Login successful.")
            } else {
                Log.e("Auth", "Login failed. No such user.")
            }

            result
        } catch (e: Exception) {
            Log.e("Auth", "Login error: ${e.message}")
            null
        }
    }
}