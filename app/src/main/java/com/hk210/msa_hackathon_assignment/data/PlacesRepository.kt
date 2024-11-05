package com.hk210.msa_hackathon_assignment.data

import com.hk210.msa_hackathon_assignment.util.NetworkResult
import com.hk210.msa_hackathon_assignment.data.models.Business
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesRepository @Inject constructor(private val yelpApiService: YelpApiService)  {

    fun getPlaces(search: String, location: String) = flow<NetworkResult<List<Business>>> {
        val response = yelpApiService.searchBusinesses(search, location).businesses
        emit(NetworkResult.Success(response))
    }.onStart {
        emit(NetworkResult.Loading())
    }.catch {
        emit(NetworkResult.Error(it.message))
    }
}