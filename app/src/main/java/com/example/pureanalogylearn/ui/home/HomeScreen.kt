package com.example.pureanalogylearn.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.pureanalogylearn.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeRoute(
    onNavigateToDetails: (Int) -> Unit,
    onNavigateToCountry: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
                title = { Text(text = stringResource(R.string.app_name)) },
            )
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                HomeScreen(
                    onNavigateToDetails,
                    onNavigateToCountry,
                )
            }
        },
    )
}

@Composable
fun HomeScreen(
    onNavigateToDetails: (Int) -> Unit,
    onNavigateToCountry: () -> Unit,
) {
    Text(text = "Selamat datang di Home ${stringResource(R.string.app_name)}")
    Button(onClick = { onNavigateToDetails(123) }) {
        Text(text = "Ke Detail")
    }
    Button(onClick = { onNavigateToCountry() }) {
        Text(text = "Ke Country")
    }
}

// EXAMPLE DETAILS SCREEN
@Composable
fun DetailsScreen(id: Int, onNavigateBack: () -> Unit,) {
    Column {
        Text(text = "Layar Details untuk ID: $id")
        Button(onClick = { onNavigateBack() }) {
            Text(text = "Kembali")
        }
    }
}