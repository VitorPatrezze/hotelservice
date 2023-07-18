package com.vitorpatrezze.hotelservice.model

import jakarta.persistence.*
import lombok.Data
import java.time.LocalDateTime

@Data
@Entity
@Table(name = "receipt")
data class Receipt (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val itemName: String,
    val amount: Int,
    @OneToOne(cascade=[CascadeType.REFRESH])
    val location: Location,
    val bookingDate: LocalDateTime = LocalDateTime.now()
)