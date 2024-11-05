package com.hk210.msa_hackathon_assignment.data.models

data class YelpSearchResponse(
    val businesses: List<Business>
)

data class Business(
    val name: String,
    val rating: Double,
    val location: Location
)

data class Location(
    val address1: String,
    val city: String
)