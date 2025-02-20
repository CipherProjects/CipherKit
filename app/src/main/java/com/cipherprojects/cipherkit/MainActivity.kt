package com.cipherprojects.cipherkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.cipherprojects.cipherkit.ui.theme.CipherKitTheme
import com.cipherprojects.core.presentation.auth.login.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkTheme by remember { mutableStateOf(false) }

            CipherKitTheme(
                darkTheme = darkTheme
            ) {
                LoginScreen(
                    darkTheme = darkTheme,
                    toggleDarkTheme = {
                        darkTheme = !darkTheme
                    },
                    onLoginSuccessful = {}
                )
            }
        }
    }
}