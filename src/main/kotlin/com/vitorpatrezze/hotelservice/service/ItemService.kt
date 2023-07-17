package com.vitorpatrezze.hotelservice.service

import com.vitorpatrezze.hotelservice.model.Item
import com.vitorpatrezze.hotelservice.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val repository: ItemRepository,
    private val validationService: ValidationService
) {
    fun allItems(): List<Item> {
        return repository.findAll()
    }

    fun getItemById(id: Long): Item {
        return repository.getReferenceById(id)
    }

    fun saveItem(item: Item): Long {
        validationService.validate(item)
        return repository.save(item).id ?: 0
    }
}