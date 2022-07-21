package com.akilincarslan.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.akilincarslan.compose.ui.theme.ComposeTheme
import com.akilincarslan.compose.ui.theme.LightGreen
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LazyRowShop()
            }
        }
    }

    @Composable
    fun LazyRowShop(list: List<Animal> = Animal.dummyAnimalList) {
        Surface() {
            LazyRow(
                modifier = Modifier.padding(15.dp)
            ) {
                items(list) { animal ->
                    AnimalItem(animal)
                }
            }
        }
    }

    @Composable
    fun AnimalItem(animal: Animal) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(150.dp, 185.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            AnimalContent(animal)
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun AnimalContent(animal: Animal) {
        ConstraintLayout() {
            val (image, text) = createRefs()
            val random = Random()
            Spacer(
                modifier = Modifier
                    .height(85.dp)
                    .background(Color.Magenta)
                    .fillMaxWidth()
            )

            Image(
                painter = painterResource(id = animal.imageDrawable),
                contentDescription = animal.name,
                modifier = Modifier
                    .size(72.dp)
                    .border(1.dp, Color.Black, CircleShape)
                    .clip(CircleShape)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
            )

            Text(
                text = animal.name,
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(image.bottom, margin = 10.dp)
                        centerHorizontallyTo(image)
                    }
            )

        }
    }

    @Preview
    @Composable
    private fun LazyColumnBook(list: List<Book> = Book.dummyBookList) {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxSize()
        ) {
            LazyColumn(
            ) {
                item {
                    Text(
                        text = "Book List",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.h6
                    )
                }
                items(list) { item: Book ->
                    BookItem(item)
                }
            }
        }
    }

    @Composable
    fun BookItem(book: Book) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 8.dp),
            backgroundColor = LightGreen,
            elevation = 5.dp,
            shape = CutCornerShape(10.dp)
        ) {
            BookContent(book)
        }
    }

    @Composable
    fun BookContent(book: Book) {
        var showMore by remember { mutableStateOf(false) }
        val extraPadding by animateDpAsState(
            targetValue = if (showMore) 48.dp else 0.dp,
            animationSpec = tween(250)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(bottom = extraPadding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = book.authorImageDrawable),
                    contentDescription = "author image",
                    modifier = Modifier
                        .border(1.dp, Color.Red, CircleShape)
                        .clip(CircleShape)
                        .size(48.dp)
                )

                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = book.title,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = book.author,
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }

            IconButton(onClick = { showMore = !showMore }) {
                Icon(
                    imageVector = if (showMore) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "drop down"
                )
            }
        }
    }

}

