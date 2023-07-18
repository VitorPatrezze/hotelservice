package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.exceptions.InvalidReputationException
import com.vitorpatrezze.hotelservice.model.Item

class ReputationValidationStep(override val nextStep: ValidationStep?) : ValidationStep {
    override fun validate(item: Item): Boolean {
        return if (item.reputation < 0 || item.reputation > 1000)
            throw InvalidReputationException("Reputation must be and integer between 0 and 1000")
        else this.nextStep(item)
    }
}