package com.example.memomate.screens.search_note

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memomate.R
import com.example.memomate.room.Notes
import com.example.memomate.screens.home.NotesListItem

@Composable
fun SearchNoteScreen() {

    var searchText by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .background(Color.Black)
        .fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 20.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF818589),
                    shape = RoundedCornerShape(30.dp)
                )
                .background(
                    color = Color(0xFFD3D3D3),
                    shape = RoundedCornerShape(30.dp)
                ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.back), contentDescription = null,
                Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 10.dp)
                    .align(Alignment.CenterVertically)
            )

            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .weight(1f)
            ) {
                if (searchText.isEmpty()) {
                    Text(
                        text = "Search notes",
                        color = Color(0xFF7F8A8E)
                    )
                }

                BasicTextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.None,
                        keyboardType = KeyboardType.Text
                    ),
                    cursorBrush = SolidColor(Color.Black),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Image(
                painter = painterResource(id = R.drawable.cancel), contentDescription = null,
                Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 10.dp, end = 16.dp)
                    .align(Alignment.CenterVertically)

            )

        }

        LazyColumn(modifier = Modifier.fillMaxSize(), content = {
            items(getDummyData()) {
                NotesListItem(title = it.title, desc = it.desc, onItemClick = {}, onDeleteClick ={} )
            }
        })

    }

}

private fun getDummyData(): List<Notes> {
    val list = arrayListOf<Notes>()
    
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))
    list.add(Notes(0, "Work", "Complete Fyp"))

    return list
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchNoteScreenPreview() {
    SearchNoteScreen()
}