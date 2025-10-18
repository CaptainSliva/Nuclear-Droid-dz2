package com.example.dz2

import android.R.attr.onClick
import android.R.attr.text
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.dz2.ui.theme.Dz2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dz2Theme {
                Column {
                    Greeting()
                }
            }
        }
    }
}

@ExperimentalStdlibApi
@Composable
fun Greeting() {
    var color by remember { mutableStateOf(Color.White) }

    Column(modifier = Modifier.fillMaxSize().background(color), horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Color: ${color.value.toHexString().replace("00000000", "")}")

        Button(onClick = {
            color = generateColor()
        }) {
            Text(text = "Change screen color")
        }
        Button(onClick = {
            color = Color.White
        }) {
            Text(text = "Clear screen color")
        }
    }

}

@ExperimentalStdlibApi
fun generateColor(): Color {
    val randomR = (0..255).random()
    val randomG = (0..255).random()
    val randomB = (0..255).random()
    val randomA = (0..255).random()

    return Color(
        randomR,
        randomG,
        randomB,
        randomA
    )
}

@ExperimentalStdlibApi
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dz2Theme {
        Greeting()
    }
}