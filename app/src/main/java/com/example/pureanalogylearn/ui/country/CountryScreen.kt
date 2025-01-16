package com.example.pureanalogylearn.ui.country

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.pureanalogylearn.R
import com.example.pureanalogylearn.data.model.Country
import com.example.pureanalogylearn.ui.base.ShowError
import com.example.pureanalogylearn.ui.base.ShowLoading
import com.example.pureanalogylearn.ui.base.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryRoute(
    viewModel: CountryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
                CountryScreen(uiState)
            }
        },
    )
}

@Composable
fun CountryScreen(uiState: UiState<List<Country>>) {
    when (uiState) {
        is UiState.Success -> {
            CountryList(countries = uiState.data)
        }

        is UiState.Error -> {
            ShowError(uiState.message)
        }

        is UiState.Loading -> {
            ShowLoading()
        }
    }
}

@Composable
fun CountryList(countries: List<Country>) {
    LazyColumn {
        items(countries) { country ->
            Country(country)
        }
    }
}

@Composable
fun Country(country: Country) {
    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                println("Country: ${country.name}")
            },
            shape = RectangleShape,
            modifier = Modifier.size(width = 340.dp, height = 40.dp)
        ) {
            Text(text = country.name)
        }
    }
}