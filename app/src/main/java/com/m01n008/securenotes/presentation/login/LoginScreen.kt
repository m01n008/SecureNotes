package com.m01n008.securenotes.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: LoginViewModel, modifier: Modifier) {
    val state by viewModel.loginState.collectAsState()
    var pin by remember{ mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

       Spacer(modifier = Modifier.padding(16.dp))
       if(state.isAuthenticated){
           Text("SecureNotesListScreen here")
           Button(onClick = {viewModel.dispatch(LoginIntent.Logout)}){
               Text("Logout")
           }
       }
       else{
           Spacer(modifier = Modifier.padding(16.dp))
           if (state.isBiometricAvailable){

           Text("Please scan your finger for authentication")
           Button(onClick = {viewModel.dispatch(LoginIntent.AttemptBiometricLogin)}) {
               Text("Login with fingerprint")
           }
          }
           else{
               Spacer(modifier = Modifier.padding(16.dp))
               PinEntryField(pin = pin) { pin  = it }
               Button(onClick = {viewModel.dispatch(LoginIntent.AttemptPinLogin(pin))}){
                   Text("Login with MPIN")
               }
           }


           state.error?.let { it ->
               Text("Error: $it", color = Color.Red )
           }
       }


    }
}

@Composable
fun PinEntryField(pin: String, onPinChange: (String) -> Unit){
    TextField(value = pin, onValueChange = { newValue ->
        run {
            val filtered = newValue.filter { it.isDigit() }.take(4)
            onPinChange(filtered)
        }
    },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        label = { Text("Enter PIN") },
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()

    )
}