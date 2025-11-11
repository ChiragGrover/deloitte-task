package com.deloitte.deloittetask.features.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.deloitte.deloittetask.domain.model.User
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import kotlin.jvm.java

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(userJson: String, onBackClick: () -> Unit = {}) {
    val userData =
        Gson().fromJson(
        URLDecoder.decode(userJson, StandardCharsets.UTF_8.toString()),
        User::class.java
    )
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = {
                Text(
                    "Back",
                    modifier = Modifier.clickable(onClick = {
                        onBackClick()
                    })
                )
            },
        )
    }) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = userData.photo,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = "User Photo"
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    userData.username,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(userData.email, style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.size(5.dp))
            }
        }
    }
}