package com.cipherprojects.core.presentation.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cipherprojects.core.domain.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> get() = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    private val _rememberMe = MutableStateFlow(true)
    val rememberMe: StateFlow<Boolean> get() = _rememberMe

    private val _showForgotPasswordDialog = MutableStateFlow(false)
    val showForgotPasswordDialog: StateFlow<Boolean> get() = _showForgotPasswordDialog

    private val _response = MutableStateFlow<Result?>(null)
    val response: StateFlow<Result?> get() = _response

    fun onUsernameChange(value: String) {
        _username.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun toggleRememberMe() {
        _rememberMe.value = !_rememberMe.value
    }

    fun toggleForgotPasswordDialog() {
        _showForgotPasswordDialog.value = !_showForgotPasswordDialog.value
    }

    fun login() {
        Log.d("Auth", "Username: `${_username.value}`, Password: `${_password.value}`")

        val username = _username.value.trim()
        val password = _password.value.trim()

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

        _response.value = Result(
            success = true,
            message = "Login successful!"
        )
    }
}