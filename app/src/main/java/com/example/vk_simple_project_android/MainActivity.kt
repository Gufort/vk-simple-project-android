package com.example.vk_simple_project_android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vk_simple_project_android.ui.theme.VksimpleprojectandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VksimpleprojectandroidTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    val context = LocalContext.current
    var inputText by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Введите номер...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val number = inputText.trim()
                when{
                    number.isEmpty() ->
                        Toast.makeText(context, "Введите номер телефона", Toast.LENGTH_SHORT).show()
                    !number.matches(Regex("^[+]?[0-9\\-\\s()]{5,20}$")) ->
                        Toast.makeText(context, "Некорректный номер телефона", Toast.LENGTH_SHORT).show()
                    else -> {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                        try {
                            context.startActivity(intent)
                        } catch (e: android.content.ActivityNotFoundException) {
                            Toast.makeText(context, "Приложение для звонков не найдено", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }, modifier = Modifier.fillMaxWidth()
        ){
            Text("Позвонить другу")
        }
    }
}