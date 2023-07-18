package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.exceptions.InvalidNameException
import com.vitorpatrezze.hotelservice.model.Item

class NameValidationStep(override val nextStep: ValidationStep?) : ValidationStep {
    override fun validate(item: Item): Boolean {
        val prohibitedWords = listOf("free", "offer", "book", "website")

        if (item.name.length < 10)
            throw InvalidNameException("The name provided is too short (must have at least 10 characters)")

        else if (containsProhibitedWords(item.name, prohibitedWords))
            throw InvalidNameException("The name provided contains prohibited words.")
        return this.nextStep(item)
    }

    fun containsProhibitedWords(name: String, prohibitedWords: List<String>): Boolean {
        for (word in prohibitedWords) {
            if (name.lowercase().contains(word)) {
                return true
            }
        }
        return false
    }
}