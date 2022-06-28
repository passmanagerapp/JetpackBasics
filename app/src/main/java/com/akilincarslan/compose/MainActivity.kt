package com.akilincarslan.compose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MaterialBasics()
            }
        }
    }

    @Preview
    @Composable
    fun MaterialBasics() {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                )
                Spacer(
                    modifier = Modifier
                        .size(ButtonDefaults.IconSpacing)
                )
                Text(text = "Like")
            }
            Spacer(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color.Red)
            )
            ExtendedFloatingActionButton(
                text = { Text(text = "Like") },
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite"
                    )
                }
            )

        }
    }

}

