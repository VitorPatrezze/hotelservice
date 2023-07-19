package com.vitorpatrezze.hotelservice.repository

import com.vitorpatrezze.hotelservice.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ItemRepository : JpaRepository<Item, Long> {
    fun findByLocationCity(city: String): List<Item>
}