package com.cipherprojects.core.presentation.auth.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cipherprojects.core.domain.auth.RegisterUserUseCase
import com.cipherprojects.core.domain.models.Result
import com.cipherprojects.core.domain.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> get() = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> get() = _confirmPassword

    private val _response = MutableStateFlow<Result?>(null)
    val response: StateFlow<Result?> get() = _response


    fun onUsernameChange(value: String) {
        _username.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun onConfirmPasswordChange(value: String) {
        _confirmPassword.value = value
    }

    fun register() {
        Log.d(
            "Auth",
            "Username: `${_username.value}`, Password: `${_password.value}`, Confirm Password: `${_confirmPassword.value}`"
        )

        val username = _username.value.trim()
        val password = _password.value.trim()
        val confirmPassword = _confirmPassword.value.trim()

        if (username.isBlank()) {
            _response.value = Result(
                success = false,
                message = "Username cannot be empty!"
            )
            return
        }

        if (password.isBlank()) {
            _response.value = Result(
                success = false,
                message = "Password cannot be empty!"
            )
            return
        }

        if (confirmPassword != password) {
            _response.value = Result(
                success = false,
                message = "Password did not matched!"
            )
            return
        }

        viewModelScope.launch {
            val result = registerUserUseCase(
                user = User(
                    id = 0,
                    username = username,
                    password = password
                )
            )

            if (result != null) {
                _response.value = Result(
                    success = true,
                    message = "Registration successful!"
                )
            } else {
                _response.value = Result(
                    success = false,
                    message = "Registration failed."
                )
            }
        }
    }
}