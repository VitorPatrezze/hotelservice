package com.vitorpatrezze.hotelservice.model

import com.fasterxml.jackson.annotation.JsonIgnore
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
    val rating: Int,
    val category: String,
    @OneToOne(cascade=[CascadeType.PERSIST])
    val location: Location,
    val imagePath: String,
    val reputation: Int,
    var reputationBadge: String?,
    val price: BigDecimal,
    val availability: Int
) {
    @PrePersist
    fun calculateReputationBadge() {
        reputationBadge = when {
            reputation >= 800 -> "green"
            reputation > 500 -> "yellow"
            else -> "red"
        }
    }
}
