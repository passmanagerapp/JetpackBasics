package com.akilincarslan.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstrainBasic2()
        }
    }

    @Composable
    fun ConstrainBasic1() {
        val constraints = ConstraintSet {
            val greenBox = createRefFor("greenbox")
            val redBox = createRefFor("redbox")
            constrain(greenBox) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
            constrain(redBox) {
                top.linkTo(parent.top)
                start.linkTo(greenBox.end)
                end.linkTo(parent.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
            createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Spread)
        }
        ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .layoutId("greenbox")
            )

            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .layoutId("redbox")
            )
        }
    }
    @Preview
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun ConstrainBasic2() {
        ConstraintLayout() {
            val (button, text) = createRefs()

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(button) {
                    top.linkTo(parent.top, margin = 16.dp)
                }
            ) {
                Text(text = "Button")

            }

            Text(text = "Text", modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom,margin = 16.dp)
                start.linkTo(button.end)
            })
        }

    }

}

