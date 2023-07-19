package com.vitorpatrezze.hotelservice.controller

import com.vitorpatrezze.hotelservice.model.Item
import com.vitorpatrezze.hotelservice.model.Receipt
import com.vitorpatrezze.hotelservice.service.ItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.math.BigDecimal

@RestController
@RequestMapping("/items")
class ItemsController(private val service: ItemService) {

    @GetMapping
    fun getItems(@RequestParam(required = false) city: String?): ResponseEntity<List<Item>> {
        return ResponseEntity.ok(service.getItems(city))
    }

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): Item {
        return service.getItemById(id)
    }

    @PostMapping
    fun saveItem(@RequestBody item: Item, uriBuilder: UriComponentsBuilder): ResponseEntity<Item> {
        val createdItem = service.saveItem(item)
        val uri = uriBuilder.path("/items/${createdItem.id}").build().toUri()
        return ResponseEntity.created(uri).body(createdItem)
    }

    @PutMapping
    fun updateById(@RequestBody item: Item, uriBuilder: UriComponentsBuilder): ResponseEntity<Item> {
        val updatedItem = service.updateItem(item, item.id ?: throw Exception("Missing required item id"))
        return ResponseEntity.ok(updatedItem)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteItemById(@PathVariable id: Long) {
        service.deleteItem(id)
    }

    @PostMapping("/{id}/book/{amount}")
    fun bookAccomodation(@PathVariable id: Long, @PathVariable amount: Int, uriBuilder: UriComponentsBuilder): ResponseEntity<Receipt> {
        val receipt = service.book(amount, id)
        return ResponseEntity.ok(receipt)
    }
}