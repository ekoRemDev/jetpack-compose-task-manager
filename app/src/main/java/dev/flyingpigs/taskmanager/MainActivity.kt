package dev.flyingpigs.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.flyingpigs.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskResultBody(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun TaskResultBody(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TaskCompletedImage()
        TaskTitle(title = stringResource(R.string.task_title), modifier = modifier)
        CongratulationMessage(message = stringResource(R.string.message), modifier = modifier)
    }
}

@Composable
fun CongratulationMessage(message: String, modifier: Modifier) {
    Text(message, fontSize = 16.sp)
}

@Composable
fun TaskTitle(title: String, modifier: Modifier) {
    Text(
        title,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun TaskCompletedImage() {
    val completedIcon = painterResource(id = R.drawable.ic_task_completed);

    Image(painter = completedIcon, contentDescription = null)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {

    }
}