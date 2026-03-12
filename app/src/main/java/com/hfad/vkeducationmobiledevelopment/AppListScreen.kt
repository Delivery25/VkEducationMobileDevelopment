package com.hfad.vkeducationmobiledevelopment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.hfad.vkeducationmobiledevelopment.ui.theme.VkEducationMobileDevelopmentTheme

@Composable
fun AppListScreen(
    onAppClick: (App) -> Unit,
    modifier: Modifier = Modifier,
) {
    val apps = remember { getAppList() }

    Column(
        modifier = modifier.background(Color(0xFFF5F5F5))
    ) {
        // Toolbar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF3A7BD5)),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = "https://static.rustore.ru/rustore-strapi/6/logo_color_30_px_2_fa2039288f.svg",
                            contentDescription = "logo",
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = "RuStore",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Grid View",
                        tint = Color.White
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(apps) { app ->
                AppListItem(
                    app = app,
                    onClick = { onAppClick(app) }
                )
            }
        }
    }
}

@Composable
fun AppListItem(
    app: App,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = app.iconUrl,
                contentDescription = app.name,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = app.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    maxLines = 1
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = app.developer,
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 1
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = app.category.displayName,
                    fontSize = 14.sp,
                    color = Color(0xFFA3A19F),
                    maxLines = 1
                )
            }
        }

        // Разделитель между элементами
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 88.dp)
                .height(0.5.dp)
                .background(Color(0xFFEEEEEE))
        )
    }
}

private fun getAppList(): List<App> = listOf(
    App(
        name = "Сбербанк Онлайн — с Салютом",
        developer = "Больше чем банк",
        category = Category.FINANCE,
        ageRating = 12,
        size = 150.5f,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        screenshotUrlList = emptyList(),
        description = "Мобильный банк для управления финансами"
    ),
    App(
        name = "Яндекс.Браузер — с Алисой",
        developer = "Быстрый и безопасный браузер",
        category = Category.TOOLS,
        ageRating = 12,
        size = 120.3f,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        screenshotUrlList = emptyList(),
        description = "Браузер с голосовым помощником Алиса"
    ),
    App(
        name = "Почта Mail.ru",
        developer = "Почтовый клиент для любых ящиков",
        category = Category.TOOLS,
        ageRating = 12,
        size = 85.2f,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        screenshotUrlList = emptyList(),
        description = "Удобный почтовый клиент"
    ),
    App(
        name = "Яндекс Навигатор",
        developer = "Парковки и заправки — по пути",
        category = Category.TRANSPORT,
        ageRating = 12,
        size = 95.7f,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        screenshotUrlList = emptyList(),
        description = "Навигация с пробками и парковками"
    ),
    App(
        name = "Мой МТС",
        developer = "Мой МТС — центр экосистемы МТС",
        category = Category.TOOLS,
        ageRating = 12,
        size = 110.4f,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        screenshotUrlList = emptyList(),
        description = "Управление услугами МТС"
    ),
    App(
        name = "Яндекс — с Алисой",
        developer = "Яндекс — поиск всегда под рукой",
        category = Category.TOOLS,
        ageRating = 12,
        size = 130.8f,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        screenshotUrlList = emptyList(),
        description = "Поиск и голосовой помощник"
    )
)

@Preview
@Composable
private fun AppListScreenPreview() {
    VkEducationMobileDevelopmentTheme {
        AppListScreen(
            onAppClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
