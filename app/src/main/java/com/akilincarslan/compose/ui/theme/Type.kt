package com.akilincarslan.compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.akilincarslan.compose.R

// Set of Material typography styles to start with
private val fontFamilyKulim = FontFamily(
    listOf(
        Font(
            resId = R.font.kulim_park_regular
        ),
        Font(
            resId = R.font.kulim_park_light,
            weight = FontWeight.Light
        )
    )
)

private val fontFamilyLato = FontFamily(
    listOf(
        Font(
            resId = R.font.lato_regular
        ),
        Font(
            resId = R.font.lato_bold,
            weight = FontWeight.Bold
        )
    )
)

val typography = Typography(
    h1 = TextStyle(
        fontFamily = fontFamilyKulim,
        fontWeight = FontWeight.Light,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    h2 = TextStyle(
        fontFamily = fontFamilyKulim,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    h3 = TextStyle(
        fontFamily = fontFamilyKulim,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),
    h4 = TextStyle(
        fontFamily = fontFamilyLato,
        fontWeight = FontWeight(500),
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.15).sp
    ),
    h5 = TextStyle(
        fontFamily = fontFamilyLato,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.4).sp
    ),
    h6 = TextStyle(
        fontFamily = fontFamilyLato,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.25).sp
    ),
    subtitle1 = TextStyle(
        fontFamily = fontFamilyLato,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.5).sp
    ),
    subtitle2 = TextStyle(
        fontFamily = fontFamilyLato,
        fontWeight = FontWeight(500),
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.5).sp,
        textAlign = TextAlign.Center
    ),
    body1 = TextStyle(
        fontFamily = fontFamilyLato,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.1).sp
    )
)