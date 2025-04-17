package com.m01n008.securenotes.presentation.notes

import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun NotesScreen(navHost: NavHostController, viewModel: NotesViewModel, modifier: Modifier){
    val state by viewModel.state.collectAsState()
    var heading by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize()
        ) {
      //  Row(modifier = Modifier.fillMaxWidth().height(20.dp)){
            IconButton(onClick = {
                viewModel.dispatch(NotesIntent.AddNote(heading, body))
            }, modifier = Modifier.align(Alignment.End)) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                    contentDescription = "close button",
                    tint = Color.Red
                )
            }
        //}
        TextField(value = heading,
            onValueChange = {  heading = it},
            modifier = Modifier.fillMaxWidth().height(60.dp),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            label = { Text("Heading") }

        )
        DottedLine(Modifier.fillMaxWidth())

        TextField(value = body,
            onValueChange = {body = it},
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top = 61.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            label = { Text("Body") }

        )

        state.error?.let {
            Toast.makeText(LocalContext.current,it, Toast.LENGTH_SHORT).show()
        }
    }

}


@Composable
fun DottedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    dashLength: Float = 10f,  // Length of each dash
    spaceLength: Float = 10f   // Space between dashes
) {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, spaceLength), 0f)
    Canvas(
        modifier = modifier
            .height(1.dp)
    ) {
        drawLine(
            color = color,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            pathEffect = pathEffect
        )
    }
}


@Composable
fun PreviewDottedLine() {
    DottedLine(modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewNoteScreen(){
    NotesScreen(navHost = rememberNavController(), viewModel = NotesViewModel(), modifier = Modifier.padding(0.dp))
}
