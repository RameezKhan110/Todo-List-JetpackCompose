package com.example.memomate.screens.add_edit_note

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.memomate.R

@Composable
fun CustomDialog(
    dialogText: String,
    setDialog: (Boolean) -> Unit,
    onButtonClick: (Boolean) -> Unit
) {
    Dialog(onDismissRequest = { setDialog(false) }) {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            ), modifier = Modifier.wrapContentSize(),
            border = BorderStroke(width = 2.dp, color = Color.DarkGray)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.wrapContentSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.info),
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(top = 28.dp))
                )

                Text(
                    text = "Save Changes?", color = Color.White, fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(top = 15.dp)),
                    textAlign = TextAlign.Center
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 28.dp)) {
                    Button(
                        onClick = { onButtonClick(false) },
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.padding(PaddingValues(start = 40.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Text(text = "Discard")
                    }
                    Spacer(modifier = Modifier.weight(.1f))
                    Button(
                        onClick = { onButtonClick(true) },
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.padding(PaddingValues(end = 40.dp)),

                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                    ) {
                        Text(text = "Save")
                    }
                }


            }
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CustomDialogPreview() {
    CustomDialog("Save Changes?", setDialog = {}, onButtonClick = {})
}