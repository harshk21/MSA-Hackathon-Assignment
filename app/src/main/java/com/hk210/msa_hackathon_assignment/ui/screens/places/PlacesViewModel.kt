package com.hk210.msa_hackathon_assignment.ui.screens.places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hk210.msa_hackathon_assignment.data.models.Business
import com.hk210.msa_hackathon_assignment.data.PlacesRepository
import com.hk210.msa_hackathon_assignment.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlacesViewModel @Inject constructor(private val repository: PlacesRepository) : ViewModel() {

    private val _pizzaPlaces = MutableStateFlow<NetworkResult<List<Business>>>(NetworkResult.Loading())
    val pizzaPlaces: StateFlow<NetworkResult<List<Business>>> = _pizzaPlaces

    private val _juicePlaces = MutableStateFlow<NetworkResult<List<Business>>>(NetworkResult.Loading())
    val juicePlaces: StateFlow<NetworkResult<List<Business>>> = _juicePlaces

    fun fetchPlaces(location: String) {
        viewModelScope.launch {
           repository.getPlaces("pizza", location).collect {
               _pizzaPlaces.value = it
           }
        }
    }

    fun fetchJuicePlaces(location: String) {
        viewModelScope.launch {
            repository.getPlaces("juice", location).collect {
                _juicePlaces.value = it
            }
        }
    }
}