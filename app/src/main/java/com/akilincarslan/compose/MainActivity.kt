package com.akilincarslan.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akilincarslan.compose.model.AlignYourBody
import com.akilincarslan.compose.ui.theme.MySootheTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val alignYourBodyData = listOf<AlignYourBody>(
        AlignYourBody(R.string.ab1_inversions, R.drawable.ab1_inversions),
        AlignYourBody(R.string.ab2_quick_yoga, R.drawable.ab2_quick_yoga),
        AlignYourBody(R.string.ab3_stretching, R.drawable.ab3_stretching),
        AlignYourBody(R.string.ab4_tabata, R.drawable.ab4_tabata),
        AlignYourBody(R.string.ab5_hiit, R.drawable.ab5_hiit),
        AlignYourBody(R.string.ab6_pre_natal_yoga, R.drawable.ab6_pre_natal_yoga),
    )

    private val favoriteCollectionData = listOf<AlignYourBody>(
        AlignYourBody(R.string.fc1_short_mantras, R.drawable.fc1_short_mantras),
        AlignYourBody(R.string.fc2_nature_meditations, R.drawable.fc2_nature_meditations),
        AlignYourBody(R.string.fc3_stress_and_anxiety, R.drawable.fc3_stress_and_anxiety),
        AlignYourBody(R.string.fc4_self_massage, R.drawable.fc4_self_massage),
        AlignYourBody(R.string.fc5_overwhelmed, R.drawable.fc5_overwhelmed),
        AlignYourBody(R.string.fc6_nightly_wind_down, R.drawable.fc6_nightly_wind_down),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenContentPreview()
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun ScreenContentPreview() {
        MySootheTheme {
            HomeScreen()
        }
    }


    @Preview
    @Composable
    fun SearchBarPreview() {
        SearchBar()
    }

    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            ),
            placeholder = {
                Text(text = stringResource(id = R.string.placeholder_search))
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun AlignYourBodyElementPreview() {
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }

    @Composable
    fun AlignYourBodyElement(
        @DrawableRes drawable: Int,
        @StringRes text: Int,
        modifier: Modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(id = text),
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }


    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun FavoriteCollectionCardPreview() {
        FavoriteCollectionCard(
            Modifier.padding(8.dp),
            drawable = R.drawable.fc2_nature_meditations,
            text = R.string.fc2_nature_meditations
        )
    }

    @Composable
    fun FavoriteCollectionCard(
        modifier: Modifier = Modifier,
        @DrawableRes drawable: Int,
        @StringRes text: Int
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = modifier
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(255.dp)
            ) {
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = stringResource(id = text),
                    modifier = Modifier.padding(horizontal = 6.dp),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun AlignYourBodyRowPreview() {
        AlignYourBodyRow(
            Modifier.padding(8.dp)
        )
    }

    @Composable
    fun AlignYourBodyRow(
        modifier: Modifier = Modifier
    ) {
        LazyRow(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(alignYourBodyData) { item ->
                AlignYourBodyElement(drawable = item.drawable, text = item.text)
            }
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun FavoriteCollectionsGridPreview() {
        FavoriteCollectionsGrid(
            Modifier.padding(8.dp)
        )
    }

    @Composable
    fun FavoriteCollectionsGrid(
        modifier: Modifier = Modifier
    ) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(favoriteCollectionData) { item ->
                FavoriteCollectionCard(drawable = item.drawable, text = item.text)
            }
        }
    }

    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {
        Column(modifier) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(Modifier.padding(horizontal = 16.dp))
            HomeSection(title = R.string.align_your_body) {
                AlignYourBodyRow()
            }
            HomeSection(title = R.string.favorite_collections) {
                FavoriteCollectionsGrid()
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun HomeSectionPreview() {
        MySootheTheme {
            HomeSection(R.string.align_your_body) {
                AlignYourBodyRow()
            }
        }
    }

    @Composable
    fun HomeSection(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Column(modifier) {
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
            )
            content()
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun SootheBottomNavigationPreview() {
        SootheBottomNavigation()
    }

    @Composable
    fun SootheBottomNavigation(modifier: Modifier = Modifier) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface,
            modifier = modifier
        ) {
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = R.string.bottom_navigation_home))
                }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = R.string.bottom_navigation_profile))
                }
            )
        }
    }

}

