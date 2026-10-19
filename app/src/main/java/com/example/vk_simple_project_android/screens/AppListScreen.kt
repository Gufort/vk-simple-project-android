package com.example.vk_simple_project_android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vk_simple_project_android.components.AppCard
import com.example.vk_simple_project_android.data.AppItem
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material3.Icon

private val sampleApps = listOf(
    AppItem(
        name = "ScheduleMe",
        description = "Планирование смен и рабочего расписания",
        category = "Продуктивность",
        icon = "📅"
    ),
    AppItem(
        name = "Guitar Trainer",
        description = "Тренировка техники игры на гитаре",
        category = "Обучение",
        icon = "🎸"
    ),
    AppItem(
        name = "ListOfCode",
        description = "Заметки, фрагменты кода и идеи",
        category = "Разработка",
        icon = "💻"
    ),
    AppItem(
        name = "CatchAndRevenge",
        description = "Небольшая приключенческая игра",
        category = "Игры",
        icon = "🎮"
    ),
    AppItem(
        name = "Калькулятор",
        description = "Полезная штуковина",
        category = "Инструменты",
        icon = "\uD83E\uDDEE"
    ),
    AppItem(
        name = "NoiseBox",
        description = "Музыкальный плеер для любимых треков",
        category = "Музыка",
        icon = "🎧"
    ),
    AppItem(
        name = "QuickNotes",
        description = "Быстрые заметки и списки дел",
        category = "Продуктивность",
        icon = "📝"
    )
)

@Composable
fun AppListScreen(){
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .statusBarsPadding()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Apps,
                    contentDescription = "Иконка приложения",
                    modifier = Modifier.size(28.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = "App Gallery",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sampleApps) { app ->
                AppCard(app = app)
            }
        }
    }
}