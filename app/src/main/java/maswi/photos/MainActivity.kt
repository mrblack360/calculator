package maswi.photos

import CalculatorUI
import CalculatorViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import maswi.photos.ui.theme.PhotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhotosTheme {
                val viewModel = CalculatorViewModel()
                val systemUiController = rememberSystemUiController()

//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                }
                CalculatorUI(
                    viewModel = viewModel,
                )

            }


        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count = remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color.Blue,

            )
        Text(
            text = count.value.toString(),
            modifier = modifier,
            color = Color.Blue,
        )
        Row {
            Button(onClick = { count.value-- }, modifier = Modifier) {
                Text(text = "-")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = { count.value++ }) {
                Text(text = "+")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhotosTheme {
        Greeting("Android")
    }
}