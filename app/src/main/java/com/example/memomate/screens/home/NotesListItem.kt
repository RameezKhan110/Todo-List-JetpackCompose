package com.example.memomate.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memomate.model.NotesModel
import kotlin.random.Random

@Composable
fun NotesListItem(title: String, desc: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = getRandomColor()
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 35.dp, vertical = 27.dp)
                .fillMaxSize(),
            color = Color.White,
            fontFamily = FontFamily.SansSerif
        )
    }

}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(), content = {
                items(getDummyData()) { note ->
                    NotesListItem(title = note.title, desc = note.desc)
                }
            })

        FloatingActionButton(
            shape = CircleShape,
            onClick = {
                // Handle the FAB click (e.g., navigate to compose screen)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(56.dp)
                .background(Color.Black)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.Blue)
        }
    }
}

private fun getDummyData(): ArrayList<NotesModel> {

    val list = arrayListOf<NotesModel>()

    list.add(
        NotesModel(
            "Im learning compose and this app will going to be made in compose",
            "I have to learn compose"
        )
    )
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))
    list.add(NotesModel("Work", "I have to learn compose"))

    return list
}

fun getRandomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNotesItem() {
//    NotesListItem("gsgsdgsd", "aasdsaasdasd")
    HomeScreen()
}