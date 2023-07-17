package com.vitorpatrezze.hotelservice.model

import jakarta.persistence.*
import lombok.Data
import java.math.BigDecimal

@Data
@Entity
@Table(name = "item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,
    val rating: Double,
    val category: String,
    //val location: Location,
    val imagePath: String,
    val reputation: Int,
    val reputationBadge: String,
    val price: BigDecimal,
    val availability: Int
)
