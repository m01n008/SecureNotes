package com.m01n008.securenotes.presentation.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel: ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState : StateFlow<LoginState> = _loginState

    fun dispatch(loginIntent: LoginIntent){
        val newState = loginReducer(loginIntent, _loginState.value)
        _loginState.value = newState
    }
}