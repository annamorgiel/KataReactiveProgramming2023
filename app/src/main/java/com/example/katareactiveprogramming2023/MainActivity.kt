package com.example.katareactiveprogramming2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.katareactiveprogramming2023.ui.theme.KataReactiveProgramming2023Theme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val connectivityStatus = viewModel.isConnected.value.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KataReactiveProgramming2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(connectivityStatus)
                }
            }
        }
    }
}

@Composable
fun Greeting(connectivityStatus: String, modifier: Modifier = Modifier) {
    Text(
        text = "Android connectivity status: $connectivityStatus!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KataReactiveProgramming2023Theme {
        Greeting("Android")
    }
}