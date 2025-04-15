package com.m01n008.securenotes.presentation.login

sealed class LoginIntent {
    object AttemptBiometricLogin: LoginIntent()
    data class AttemptPinLogin(val pin: String): LoginIntent()
    object AttemptFaceLogin: LoginIntent()
    object Logout: LoginIntent()
}