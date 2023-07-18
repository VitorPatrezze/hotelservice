package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.exceptions.InvalidRatingException
import com.vitorpatrezze.hotelservice.model.Item

class RatingValidationStep(override val nextStep: ValidationStep?) : ValidationStep {
    override fun validate(item: Item): Boolean {
        return if (item.rating > 5 || item.rating < 0)
            throw InvalidRatingException("Rating must be an integer between 0 and 5")
        else this.nextStep(item)
    }
}