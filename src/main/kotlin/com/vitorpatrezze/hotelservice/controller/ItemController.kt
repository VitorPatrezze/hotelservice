package com.vitorpatrezze.hotelservice.controller

import com.vitorpatrezze.hotelservice.model.Item
import com.vitorpatrezze.hotelservice.service.ItemService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}