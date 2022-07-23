package com.akilincarslan.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent: Animal? = intent.extras?.getParcelable("animal")
            AnimalDetail(intent!!)
        }
    }

    @Composable
    fun AnimalDetail(animal: Animal) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                IconButton(
                    onClick = {
                        onBackPressed()
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.padding(15.dp)
                    )
                }
                Image(
                    painter = painterResource(id = animal.imageDrawable),
                    contentDescription = animal.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(top = 25.dp)
                        .clip(RoundedCornerShape(percent = 10))
                        .border(4.dp, Color.Gray, RoundedCornerShape(percent = 10))
                        .size(250.dp),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = animal.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(top = 25.dp),
                    style = MaterialTheme.typography.h6,
                )
            }

        }
    }
}