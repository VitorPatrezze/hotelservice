package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.Exceptions.InvalidCategoryException
import com.vitorpatrezze.hotelservice.model.Item

class CategoryValidationStep(override val nextStep: ValidationStep?) : ValidationStep {
    override fun validate(item: Item): Boolean {
        val validCategories = listOf("hotel", "alternative", "hostel", "lodge", "resort", "guest-house")
        return if (item.category.lowercase() !in validCategories)
            throw InvalidCategoryException("The category specified is not valid.")
        else this.nextStep(item)
    }
}