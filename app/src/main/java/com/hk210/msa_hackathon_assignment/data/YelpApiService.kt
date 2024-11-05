package com.hk210.msa_hackathon_assignment.data

import com.hk210.msa_hackathon_assignment.data.models.YelpSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface YelpApiService {
    @GET("v3/businesses/search")
    suspend fun searchBusinesses(
        @Query("term") term: String,
        @Query("location") location: String
    ): YelpSearchResponse
}