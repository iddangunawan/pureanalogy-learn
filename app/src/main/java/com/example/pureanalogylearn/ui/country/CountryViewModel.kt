package com.example.pureanalogylearn.ui.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pureanalogylearn.data.model.Country
import com.example.pureanalogylearn.data.repository.CountryRepository
import com.example.pureanalogylearn.ui.base.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Country>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Country>>> = _uiState

    init {
        fetchCountry()
    }

    private fun fetchCountry() {
        viewModelScope.launch {
            countryRepository.getCountry()
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }.collect {
                    _uiState.value = UiState.Success(it.sortedBy { name -> name.name })
                }

        }
    }

}