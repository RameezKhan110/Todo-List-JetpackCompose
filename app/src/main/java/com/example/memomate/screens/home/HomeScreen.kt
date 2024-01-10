package com.example.memomate.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.memomate.R
import com.example.memomate.screens.add_note.CreateNoteScreen
import com.example.memomate.screens.detail_note.NoteDetailScreen
import com.example.memomate.viewmodel.NotesViewModel


@Composable
fun HomeScreen(notesViewModel: NotesViewModel, navController: NavController) {

//    val notesList by remember {
//        notesViewModel.getNotes
//    }.collectAsState()
    notesViewModel.getAllNotes()
    val notesList = notesViewModel.getNotes.collectAsState()



    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Notes",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .background(Color.DarkGray, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .background(Color.DarkGray, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = "info",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(), content = {
                    items(notesList.value) { note ->
                        note?.let {
                            NotesListItem(
                                title = it.title,
                                desc = note.desc,
                                onItemClick = { clickedItem ->
                                    navController.navigate("NoteDetailScreen/${note.id}")
                                },
                                onDeleteClick = {
                                    notesViewModel.deleteNote(note)
                                    notesViewModel.getAllNotes()
                                })
                        }
                    }
                })

            FloatingActionButton(
                shape = CircleShape,
                onClick = {
                    navController.navigate("CreateNoteScreen")
                },
                modifier = Modifier
                    .offset(x = (-25).dp, y = (-40).dp)
                    .align(Alignment.BottomEnd)
                    .size(56.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.Blue)
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationComponent() {

    val notesViewModel: NotesViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") {
            HomeScreen(notesViewModel, navController = navController)
        }

        composable("CreateNoteScreen") {
            CreateNoteScreen(notesViewModel, navController)
        }
        composable("NoteDetailScreen/{note_data}", arguments = listOf(navArgument("note_data") {
            type = NavType.IntType
        })) {
            val id = it.arguments?.getInt("note_data")
            if (id != null) {
                NoteDetailScreen(notesViewModel, id, navController)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNotesItem() {

    NavigationComponent()
}