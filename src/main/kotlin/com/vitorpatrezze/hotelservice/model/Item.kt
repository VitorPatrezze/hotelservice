package com.vitorpatrezze.hotelservice.model

import com.vitorpatrezze.hotelservice.exceptions.*
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
    var availability: Int
) {
    @PrePersist
    fun calculateReputationBadge() {
        reputationBadge = when {
            reputation >= 800 -> "green"
            reputation > 500 -> "yellow"
            else -> "red"
        }
    }

    fun updateId(id: Long): Item {
        return Item(
            id = id,
            name = this.name,
            rating = this.rating,
            category = this.category,
            location = this.location,
            imagePath = this.imagePath,
            reputation = this.reputation,
            reputationBadge = this.reputationBadge,
            price = this.price,
            availability = this.availability
        )
    }

    fun updateAvailability(amount: Int) {
        if (amount > this.availability) throw AccommodationNotAvailableException()
        this.availability -= amount
    }
}
