package com.example.memomate.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.memomate.utils.Extensions

@Composable
fun NotesListItem(title: String, desc: String, onItemClick: (String) -> Unit) {
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
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth(),
            color = Color.Black,
            fontFamily = FontFamily.SansSerif
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotesItemPreview() {
    NotesListItem(title = "Work", desc = "asdada", onItemClick = {})
}
