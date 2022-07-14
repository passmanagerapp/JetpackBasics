package com.akilincarslan.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val scaffoldState =
                rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed)
            BackdropScaffold(
                scaffoldState = scaffoldState,
                appBar = {
                    TopAppBar(
                        title = { Text(text = "Backdrop") },
                        navigationIcon = {
                            if (scaffoldState.isConcealed) {
                                IconButton(
                                    onClick = {
                                        scope.launch { scaffoldState.reveal() }
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Menu"
                                    )
                                }
                            } else {
                                IconButton(onClick = {
                                    scope.launch { scaffoldState.conceal() }
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close"
                                    )
                                }
                            }
                        },
                        elevation = 0.dp,
                        backgroundColor = Color.Transparent
                    )
                },

                backLayerContent = {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "BackLayer")
                    }
                },
                frontLayerContent = {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "FrontLayer")
                    }
                },
                peekHeight = 40.dp,
                headerHeight = 60.dp,
                gesturesEnabled = false
            ) {

            }
        }
    }

}

