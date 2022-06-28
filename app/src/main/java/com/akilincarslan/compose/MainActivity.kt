package com.akilincarslan.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxBasics()
        }
    }

    @Preview
    @Composable
    fun BoxBasics() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.background(Color.Red)
            ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .border(1.dp,Color.White, CircleShape)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_check_24),
                contentDescription = "",
                modifier = Modifier.size(15.dp)
                    .border(0.1.dp,Color.Black, CircleShape)
            )
        }
    }

}

