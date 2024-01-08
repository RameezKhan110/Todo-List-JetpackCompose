package com.example.memomate.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.memomate.utils.Extensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListItem(title: String, desc: String, onItemClick: (String) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Extensions.getRandomColor()
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .clickable {
                onItemClick(title)
            }
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
