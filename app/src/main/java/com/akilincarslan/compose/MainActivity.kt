package com.akilincarslan.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.akilincarslan.compose.ui.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetBasics()
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun BottomSheetBasics() {
        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState(
            ModalBottomSheetValue.Hidden
        )
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {
                TextButton(
                    onClick = {
                        hideBottomSheet(scope,sheetState)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share"
                    )
                    Text(
                        text = "Share",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    )
                }

                TextButton(
                    onClick = {
                        hideBottomSheet(scope,sheetState)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Call"
                    )
                    Text(
                        text = "Call",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    )
                }

                TextButton(
                    onClick = {
                        hideBottomSheet(scope,sheetState)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit"
                    )
                    Text(
                        text = "Edit",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    )
                }


                TextButton(
                    onClick = {
                        hideBottomSheet(scope,sheetState)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                    Text(
                        text = "Delete",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    )
                }
            },
            modifier = Modifier
                .fillMaxSize()

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = {
                    scope.launch {
                        sheetState.show()
                    }
                }) {
                    Text(text = "Open drawer")
                }
            }

        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    private fun hideBottomSheet(scope: CoroutineScope, state: ModalBottomSheetState) {
        scope.launch {
            state.hide()
        }
    }

}

