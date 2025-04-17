package com.m01n008.securenotes.presentation.notes

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.m01n008.securenotes.R

@Composable
fun NotesListScreen(navHost: NavHostController, viewModel: NotesViewModel, modifier: Modifier){
    val state by viewModel.state.collectAsState()
    var showDimLayer by remember { mutableStateOf(true) }

    Column(modifier = modifier.fillMaxSize()) {

        if (state.notesList.isEmpty()){
          Box(modifier = modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.3f))){
              IconButton(onClick = {
                    showDimLayer = false
                    navHost.navigate("addnote")

              }, modifier = Modifier.align(Alignment.Center)) {
                  Icon(imageVector = Icons.Default.Add,
                      contentDescription = "Add Note",
                      tint = Color.White)
              }

              androidx.compose.animation.AnimatedVisibility(
                  visible = showDimLayer,
                  enter = scaleIn() +  fadeIn(),
                  exit = scaleOut() + fadeOut(),
               ) {
                  Box(modifier = modifier.fillMaxSize())
              }
          }
        }
        else if(state.isLoading){
            LinearProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Green
            )
        }
        else if(state.isLocked){
            Toast.makeText(LocalContext.current,"Please unlock the app to use",Toast.LENGTH_SHORT).show()
        }
        else {
            LazyColumn  {
               items(state.notesList){
                   Text("Note: $it.heading")
               }
            }
        }
        state.error?.let {
            Text("Error: $it")
        }


       }
}

