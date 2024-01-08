package com.example.memomate.screens.home
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.memomate.model.NotesModel
import com.example.memomate.screens.add_note.CreateNoteScreen


@Composable
fun HomeScreen(navController: NavController) {

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
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "visibility",
                    tint = Color.White,
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .background(Color.DarkGray, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "save",
                    tint = Color.White,
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
                    items(getDummyData()) { note ->
                        NotesListItem(title = note.title, desc = note.desc)
                    }
                })

//            Spacer(modifier = Modifier.align(Alignment.BottomEnd).width(10.dp).height(20.dp))

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

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") {
            HomeScreen(navController = navController)
        }
        composable("CreateNoteScreen") {
            CreateNoteScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNotesItem() {
//    NotesListItem("gsgsdgsd", "aasdsaasdasd")
//    HomeScreen()
    NavigationComponent()
}