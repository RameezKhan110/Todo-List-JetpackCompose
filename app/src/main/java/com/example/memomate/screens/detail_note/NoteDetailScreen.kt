package com.example.memomate.screens.detail_note

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memomate.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen() {

    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(vertical = 20.dp, horizontal = 10.dp)
            .fillMaxSize()
    ) {
        Row(horizontalArrangement = Arrangement.End) {
            Box(
                modifier = Modifier
                    .background(Color.DarkGray, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.leftchevron),
                    contentDescription = "left chevron",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .background(Color.DarkGray, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "edit",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "This is title", color = Color.White, fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(), fontWeight =  FontWeight.Bold)

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "This is Description", color = Color.White, fontSize = 25.sp,
            modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewFunction() {
    NoteDetailScreen()
}