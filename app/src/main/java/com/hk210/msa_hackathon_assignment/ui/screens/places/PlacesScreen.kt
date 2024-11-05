package com.hk210.msa_hackathon_assignment.ui.screens.places

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hk210.msa_hackathon_assignment.util.NetworkResult

@Composable
fun PlacesScreen(viewModel: PlacesViewModel = hiltViewModel(), location: String) {
    // Trigger data fetch
    LaunchedEffect(Unit) {
        viewModel.fetchPlaces(location)
        viewModel.fetchJuicePlaces(location)
    }

    // Collect data
    val pizzaPlacesResult by viewModel.pizzaPlaces.collectAsState()
    val juicePlacesResult by viewModel.juicePlaces.collectAsState()

    LazyColumn {
        item { Text("Pizza Places") }
        when (pizzaPlacesResult) {
            is NetworkResult.Loading -> item { Text("Loading...") }
            is NetworkResult.Error -> item { Text("Error: ${pizzaPlacesResult.message}") }
            is NetworkResult.Success -> {
                items(pizzaPlacesResult.data!!) { place ->
                    Text("${place.name} - ${place.location.address1}, Rating: ${place.rating}")
                }
            }
        }


        item { Text("Juice Places") }
        when (juicePlacesResult) {
            is NetworkResult.Loading -> item { Text("Loading...") }
            is NetworkResult.Error -> item { Text("Error: ${pizzaPlacesResult.message}") }
            is NetworkResult.Success -> {
                items(juicePlacesResult.data!!) { place ->
                    Text("${place.name} - ${place.location.address1}, Rating: ${place.rating}")
                }
            }
        }
    }
}