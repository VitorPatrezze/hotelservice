package com.vitorpatrezze.hotelservice.controller

import com.vitorpatrezze.hotelservice.model.Item
import com.vitorpatrezze.hotelservice.service.ItemService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/items")
class ItemsController(private val service: ItemService) {

    @GetMapping
    fun getItems(): List<Item> {
        return service.allItems()
    }

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): Item {
        return service.getItemById(id)
    }

    @PostMapping
    fun saveItem(@RequestBody item: Item): Long {
        return service.saveItem(item)
    }

    @PutMapping
    fun updateById(@RequestBody item: Item): Item {
        return service.updateItem(item, item.id ?: throw Exception("Missing required item id for updating info"))
    }

    @DeleteMapping("/{id}")
    fun deleteItemById(@PathVariable id: Long): String {
        return service.deleteItem(id)
    }
}