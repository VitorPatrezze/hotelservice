package com.vitorpatrezze.hotelservice.service

import com.vitorpatrezze.hotelservice.model.Item
import com.vitorpatrezze.hotelservice.model.Receipt
import com.vitorpatrezze.hotelservice.repository.ItemRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val repository: ItemRepository,
    private val validationService: ValidationService
) {
    fun getItems(cityFilter: String?): List<Item> {
        return if (cityFilter == null) repository.findAll()
            else repository.findByLocationCity(cityFilter)
    }

    fun getItemById(id: Long): Item {
        return try {
            repository.getReferenceById(id)
        } catch (ex: Exception) {
            throw EntityNotFoundException("Could not find item with id $id")
        }
    }

    fun saveItem(item: Item): Item {
        validationService.validate(item)
        return repository.save(item)
    }

    fun updateItem(updatedItem: Item, id: Long): Item {
        getItemById(id) // checks if item exists
        validationService.validate(updatedItem)
        return repository.save(updatedItem.updateId(id))
    }

    fun deleteItem(id: Long): String {
        val item = getItemById(id)
        repository.delete(item)
        return "Sucessfully deleted item with id=${item.id}"
    }

    fun book(amount: Int, id: Long): Receipt {
        if (amount < 0) throw Exception("Invalid booking amount")
        val item = getItemById(id)
        item.updateAvailability(amount)
        updateItem(item, id)
        return Receipt(
            id, "Receipt - " + item.name, amount, item.location
        )
    }
}