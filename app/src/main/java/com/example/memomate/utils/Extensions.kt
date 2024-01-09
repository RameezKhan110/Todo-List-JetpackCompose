package com.example.memomate.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Extensions {
    fun getRandomColor(): Color {
        val colorCodes = listOf("#FD99FF", "#FF9E9E", "#91F48F", "#FFF599", "#9EFFFF", "#B69CFF")
        val randomColorCode = colorCodes[Random.nextInt(colorCodes.size)]
        return Color(android.graphics.Color.parseColor(randomColorCode))
    }

}