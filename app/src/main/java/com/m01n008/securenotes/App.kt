package com.m01n008.securenotes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.m01n008.securenotes.presentation.login.LoginScreen
import com.m01n008.securenotes.presentation.login.LoginViewModel
import com.m01n008.securenotes.presentation.notes.NotesListScreen
import com.m01n008.securenotes.presentation.notes.NotesScreen
import com.m01n008.securenotes.presentation.notes.NotesViewModel


@Composable
fun App(modifier: Modifier){

    val navHost = rememberNavController()
    NavHost(navController = navHost, startDestination = "notelist") {

        composable("login"){
            LoginScreen(navHost, LoginViewModel(), modifier = modifier)
        }
        composable("addnote"){
            NotesScreen(navHost, NotesViewModel(),modifier = modifier)
        }
        composable("notelist"){
            NotesListScreen(navHost, NotesViewModel(), modifier = modifier)
        }
    }

}