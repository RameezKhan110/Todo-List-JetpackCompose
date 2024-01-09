package com.example.memomate.screens.add_note

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.memomate.R
import com.example.memomate.room.Notes
import com.example.memomate.viewmodel.NotesViewModel
import java.time.format.TextStyle


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNoteScreen(navController: NavController) {

    val viewModel = NotesViewModel()

    var title by remember {
        mutableStateOf("")
    }

    var desc by remember {
        mutableStateOf("")
    }
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
                    painter = painterResource(id = R.drawable.visibility),
                    contentDescription = "visible",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))


            Box(
                modifier = Modifier
                    .background(Color.DarkGray, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
//                    .clickable {
//                        viewModel.createNote(Notes(0, title, desc))
//                        navController.popBackStack()
//                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.save),
                    contentDescription = "save",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.Black)
        ) {
            if (title.isEmpty()) {
                Text(
                    text = "Title Goes Here",
                    color = Color.DarkGray,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                )
            }

            BasicTextField(
                value = title,
                onValueChange = { newText -> title = newText },
                cursorBrush = SolidColor(Color.White),
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 30.sp),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.Black)
        ) {
            if (desc.isEmpty()) {
                Text(
                    text = "Add Your Thoughts...",
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                )
            }

            BasicTextField(
                value = desc,
                onValueChange = { newText -> desc = newText },
                cursorBrush = SolidColor(Color.White),
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 25.sp),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNoteScreen_Preview() {

    var title by remember {
        mutableStateOf("")
    }

    var desc by remember {
        mutableStateOf("")
    }
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
                    painter = painterResource(id = R.drawable.visibility),
                    contentDescription = "visible",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))


            Box(
                modifier = Modifier
                    .background(Color.DarkGray, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
//                    .clickable {
//                        viewModel.createNote(Notes(0, title, desc))
//                        navController.popBackStack()
//                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.save),
                    contentDescription = "save",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        var text by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.Black)
        ) {
            if (text.isEmpty()) {
                Text(
                    text = "Title Goes Here",
                    color = Color.DarkGray,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                )
            }

            BasicTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                cursorBrush = SolidColor(Color.White),
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 30.sp),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.Black)
        ) {
            if (text.isEmpty()) {
                Text(
                    text = "Add Your Thoughts...",
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                )
            }

            BasicTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                cursorBrush = SolidColor(Color.White),
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 25.sp),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFunction() {
    CreateNoteScreen_Preview()
}