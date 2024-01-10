package com.example.memomate.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memomate.R
import com.example.memomate.room.Notes
import com.example.memomate.utils.Extensions

@Composable
fun NotesListItem(title: String, desc: String, onItemClick: (String) -> Unit, onDeleteClick: (String) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Extensions.getRandomColor()
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(title)
            }
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Text(
                text = title,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .weight(1f),
                color = Color.Black,
                fontFamily = FontFamily.SansSerif
            )

            Image(
                painter = painterResource(id = R.drawable.delete),
                contentDescription = "delete",
                modifier = Modifier
                    .padding(PaddingValues(end = 20.dp, top = 20.dp, bottom = 20.dp))
                    .clickable { onDeleteClick(title) }
            )
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotesItemPreview() {
    NotesListItem(title = "Work", desc = "asdada", onItemClick = {}, onDeleteClick = {})
}
