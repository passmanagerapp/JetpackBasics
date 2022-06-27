package com.akilincarslan.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akilincarslan.compose.ui.theme.Typography
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // ChatItem()
            ShowMessage()
        }
    }

    @Composable
    private fun ColumnBasics() {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(vertical = 15.dp)
        ) {
            Text(
                text = "Hello!",
                color = Color.Green,
                style = Typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            )
            Text(
                text = "Columns",
                color = Color.Red,
                style = Typography.h6
            )
        }
    }

    @Composable
    fun RowBasics() {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            ColumnBasics()
        }
    }

    @Preview
    @Composable
    fun ChatItem() {
        Row(
            modifier = Modifier
                .background(Color.LightGray, shape = RectangleShape)
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    Toast
                        .makeText(this, "I am clicked!", Toast.LENGTH_SHORT)
                        .show()
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_account),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .border(
                        1.dp, Color.Black,
                        CircleShape
                    )
            )
            Column() {
                Text(
                    text = "Username",
                    style = Typography.h5,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Text(
                    text = "Last message..",
                    style = Typography.subtitle2,
                    modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                )
            }

        }
    }

    @Preview
    @Composable
    fun ShowMessage() {
        val userName = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                label = { Text(text = "Enter username") },
                keyboardActions = KeyboardActions(onSend = {
                    Toast.makeText(this@MainActivity, "Username: ${userName.value}", Toast.LENGTH_SHORT).show()
                    userName.value = ""
                }),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send
                )
            )
            Button(
                onClick = {
                    Toast.makeText(this@MainActivity, "Username: ${userName.value}", Toast.LENGTH_SHORT).show()
                    userName.value = ""
                },
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(text = "Send")
            }
        }
    }
}

