package com.akilincarslan.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        var showTask by rememberSaveable { mutableStateOf(true) }
        if (count > 0) {
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 min walk today?",
                    onClose = { showTask = false },
                checked = false,
                onCheckedChange = {})
            }
            Text(text = "You^ve had ${count} glasses")
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text(text = "Add one")
            }
            Button(onClick = { count = 0 },modifier = Modifier.padding(start = 10.dp)) {
                Text("Clear water count")
            }
        }
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit,modifier:Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (count >0 ) {
            Text(text = "You've had $count glasses.")
        }
        Button(onClick = onIncrement,modifier = Modifier.padding(top = 8.dp),enabled = count < 10) {
            Text(text = "Add one")
        }
    }
}

@Composable
fun StatefulCounter() {
    var waterCount by rememberSaveable { mutableStateOf(0)}
  //  var juiceCount by remember { mutableStateOf(0)}
    StatelessCounter(count = waterCount, onIncrement = { waterCount++ })
 //   StatelessCounter(count = juiceCount, onIncrement = { juiceCount++ })
}