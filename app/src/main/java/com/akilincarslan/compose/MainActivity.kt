package com.akilincarslan.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akilincarslan.compose.ui.theme.ComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme() {
                MyApp()

            }
        }
    }

    @Composable
    fun MyApp(names: List<String> = listOf("World", "Compose")) {
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
            ) {
            Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
                Text(text = "Hello,")
                Text(text = name)
            }

        }
    }

    @Preview(uiMode = UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
    @Preview(showBackground = true, name = "Text Preview", widthDp = 320)
    @Composable
    fun DefaultPreview() {
        ComposeTheme {
            MyApp()
        }
    }

}

