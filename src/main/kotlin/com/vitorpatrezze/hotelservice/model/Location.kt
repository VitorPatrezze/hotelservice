package com.vitorpatrezze.hotelservice.model

import jakarta.persistence.*
import lombok.Data

data class Location(
    val city: String,
    val state: String,
    val country: String,
    val zipCode: String,
    val address: String
)
