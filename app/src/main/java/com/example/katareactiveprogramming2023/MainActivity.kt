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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.katareactiveprogramming2023.ui.theme.KataReactiveProgramming2023Theme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val connectivityStatusAsStateFlow = viewModel.isConnectedStateFlow.value.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val connectivityStatusAsSharedFlowWithEmit = viewModel.isConnectedSharedFlowWithEmit.collectAsState(initial = false).value.toString()
            val connectivityStatusAsSharedFlowWithTryEmit = viewModel.isConnectedSharedFlowWithTryEmit.collectAsState(initial = false).value.toString()

            KataReactiveProgramming2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(connectivityStatusAsStateFlow, connectivityStatusAsSharedFlowWithEmit, connectivityStatusAsSharedFlowWithTryEmit)
                }
            }
        }
    }
}

@Composable
fun Greeting(
    connectivityStatusAsStateFlowFromStateFlow: String,
    connectivityStatusAsSharedFlowWithEmit: String,
    connectivityStatusAsSharedFlowWithTryEmit: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "connectivityStatusAsStateFlowFromStateFlow: $connectivityStatusAsStateFlowFromStateFlow!",
        modifier = modifier
    )

    Text(
        text = "connectivityStatusAsSharedFlowWithEmit: $connectivityStatusAsSharedFlowWithEmit!",
        modifier = modifier
    )
    Text(
        text = "connectivityStatusAsSharedFlowWithTryEmit: $connectivityStatusAsSharedFlowWithTryEmit!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KataReactiveProgramming2023Theme {
        Greeting("true", "false", "true")
    }
}