package com.vitorpatrezze.hotelservice.model

import jakarta.persistence.*
import lombok.Data

@Data
@Entity
@Table(name = "location")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val city: String,
    val state: String,
    val country: String,
    val zipCode: String,
    val address: String
)
