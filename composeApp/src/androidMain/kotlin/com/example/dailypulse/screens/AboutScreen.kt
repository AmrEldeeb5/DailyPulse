package com.example.dailypulse.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dailypulse.Platform

@Composable
fun AboutScreen(
) {
    Column{
        ToolBar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar() {
    TopAppBar(
        title = {Text("About")}
    )
}

@Composable
fun ContentView() {
    val items = makeItems()

    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(items){ row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

// Simple data for the About list
private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating System","${platform.osName} ${platform.osVersion}"),
        Pair("Version", platform.deviceModel),
        Pair("Density",platform.density.toString())
    )
}
@Composable
private fun RowView(
    title: String,
    subtitle: String) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text = title,
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray)
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    HorizontalDivider()
}
