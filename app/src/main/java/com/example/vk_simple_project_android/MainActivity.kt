package com.example.vk_simple_project_android

import android.R.id.message
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vk_simple_project_android.ui.theme.VksimpleprojectandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VksimpleprojectandroidTheme {
                MainScreen();
            }
        }
    }
}
@Composable
fun MainScreen(){
    val context = LocalContext.current
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it},
            label = { Text("Введите...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val text = inputText.trim()
                if(text.isEmpty())
                    Toast.makeText(context, "Поле не может быть пустым!", Toast.LENGTH_SHORT).show()
                else{
                    val intent = Intent(context, SecondActivity::class.java).apply{
                        putExtra(SecondActivity.EXTRA_MESSAGE, text)
                    }
                    context.startActivity(intent)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Перейти ко второй Activity")
        }
    }
}

