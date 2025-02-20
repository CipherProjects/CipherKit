package com.cipherprojects.core.data.preferences

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(
    private val context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PREFERENCES_NAME, Context.MODE_PRIVATE
    )

    companion object {
        private const val PREFERENCES_NAME = "app_preferences"
        private const val FIRST_LAUNCH = "first_launch"
        private const val DARK_THEME = "dark_theme"

        private const val REMEMBER_ME = "remember_me"
        private const val USERNAME = "username"
        private const val PASSWORD = "password"
    }

    fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean(FIRST_LAUNCH, true)
    }

    fun setFirstLaunchAsDone() {
        sharedPreferences.edit().putBoolean(FIRST_LAUNCH, false).apply()
    }

    fun isDarkTheme(): Boolean {
        return sharedPreferences.getBoolean(DARK_THEME, false)
    }

    fun toggleDarkTheme() {
        sharedPreferences.edit().putBoolean(DARK_THEME, !isDarkTheme()).apply()
    }

    fun isRememberMeEnabled(): Boolean {
        return sharedPreferences.getBoolean(REMEMBER_ME, true)
    }

    fun toggleRememberMe() {
        sharedPreferences.edit().putBoolean(REMEMBER_ME, !isRememberMeEnabled()).apply()
    }

    fun getRememberedUsername(): String {
        return sharedPreferences.getString(USERNAME, "") ?: ""
    }

    fun setUsernameToRemember(value: String) {
        sharedPreferences.edit().putString(USERNAME, value).apply()
    }

    fun getRememberedPassword(): String {
        return sharedPreferences.getString(PASSWORD, "") ?: ""
    }

    fun setPasswordToRemember(value: String) {
        sharedPreferences.edit().putString(PASSWORD, value).apply()
    }
}