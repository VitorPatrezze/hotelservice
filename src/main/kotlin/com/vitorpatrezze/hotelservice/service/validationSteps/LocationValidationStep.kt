package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.Exceptions.InvalidLocationException
import com.vitorpatrezze.hotelservice.model.Item

class LocationValidationStep(override val nextStep: ValidationStep?) : ValidationStep {
    override fun validate(item: Item): Boolean {
        return if (item.location.zipCode.length != 5)
            throw InvalidLocationException("The zipcode provided for the location is not valid (bigger than 5 digits).")
        else this.nextStep(item)
    }
}