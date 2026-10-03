package com.example.vk_simple_project_android

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vk_simple_project_android.ui.theme.VksimpleprojectandroidTheme


class SecondActivity: ComponentActivity() {
    companion object {
        const val EXTRA_MESSAGE = "com.example.vk_simple_project_android.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message: String = intent.getStringExtra(EXTRA_MESSAGE).orEmpty()

        setContent {
            VksimpleprojectandroidTheme {
                SecondScreen(message = message)
            }
        }
    }
}

@Composable
fun SecondScreen(message: String){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message.ifEmpty { "Текст не передан" },
            style = MaterialTheme.typography.headlineSmall
        )
    }
}