package com.akilincarslan.compose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldBasics()
        }
    }

    @Composable
    fun ScaffoldBasics() {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                MyTopAppBar(scaffoldState.drawerState)
            },
            bottomBar = {
                MyBottomAppBar()
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val result = scaffoldState.snackbarHostState
                                .showSnackbar(
                                    message = "Snackbar",
                                    actionLabel = "Action",
                                    duration = SnackbarDuration.Indefinite
                                )
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    Log.d("MainActivity", "actionPerformed")
                                }
                                SnackbarResult.Dismissed -> {
                                    Log.d("MainActivity", "dismissed")
                                }
                            }

                        }
                    }) {
                    Icon(imageVector = Icons.Default.Call, contentDescription = "Add")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = true,
            drawerContent = {
                Text(
                    text = "Drawer title",
                    modifier = Modifier.padding(16.dp)
                )
                Divider()
            },

            ) { contentPadding ->

        }
    }

    @Composable
    fun MyBottomAppBar() {
        BottomAppBar(
            cutoutShape = MaterialTheme.shapes.small.copy(
                CornerSize(percent = 50)
            )
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add"
            )
        }
    }

    @Composable
    fun MyTopAppBar(drawerState :DrawerState) {
        val scope = rememberCoroutineScope()
        TopAppBar(
            title = {
                Text(text = "Page title")
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Back",
                    Modifier.clickable {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            },
            actions = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    Modifier.clickable {
                        showMessage("Favorite clicked!")
                    }
                )
                Spacer(modifier = Modifier.size(15.dp))
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    Modifier.clickable {
                        showMessage("Search clicked!")
                    }
                )
            }
        )
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}

