package com.vitorpatrezze.hotelservice.service

import com.vitorpatrezze.hotelservice.model.Item
import com.vitorpatrezze.hotelservice.service.validationSteps.*
import org.springframework.stereotype.Service

@Service
class ValidationService {
    // Chain of responsability design pattern for validation purposes - Makes it easier to add/change validations
    private val reputationStep = ReputationValidationStep(null)
    private val imageStep = ImageValidationStep(reputationStep)
    private val locationStep = LocationValidationStep(imageStep)
    private val categoryStep = CategoryValidationStep(locationStep)
    private val ratingStep = RatingValidationStep(categoryStep)
    private val nameStep = NameValidationStep(ratingStep)

    fun validate(item: Item) : Boolean {
        return nameStep.validate(item)
    }

}