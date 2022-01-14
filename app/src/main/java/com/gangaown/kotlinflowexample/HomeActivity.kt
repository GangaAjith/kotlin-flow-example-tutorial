package com.gangaown.kotlinflowexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gangaown.kotlinflowexample.ui.HomeViewModel
import com.gangaown.kotlinflowexample.ui.theme.KotlinFlowExampleTutorialTheme


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinFlowExampleTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(" .....")
                }
                val viewModel = viewModel<HomeViewModel>()
                val count = viewModel.stateFlow.collectAsState(initial = 0)
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Button(onClick = { viewModel.incrementCounter() }) {
                        Text(text = "Counter value ${count.value}")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Welcome $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinFlowExampleTutorialTheme {
        Greeting("Android")
    }
}