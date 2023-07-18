package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.exceptions.InvalidLocationException
import com.vitorpatrezze.hotelservice.model.Item

class LocationValidationStep(override val nextStep: ValidationStep?) : ValidationStep {
    override fun validate(item: Item): Boolean {
        return if (item.location.zipCode.length != 5)
            throw InvalidLocationException()
        else this.nextStep(item)
    }
}