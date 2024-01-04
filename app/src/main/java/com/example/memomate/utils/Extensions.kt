package com.example.memomate.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Extensions {
    fun getRandomColor(): Color {
        return Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
        )
    }

}