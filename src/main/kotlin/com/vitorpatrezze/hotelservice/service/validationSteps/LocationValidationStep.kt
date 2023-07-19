package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.exceptions.InvalidLocationException
import com.vitorpatrezze.hotelservice.model.Item

const val MAXIMUM_ZIPCODE_SIZE = 5

class LocationValidationStep(override val nextStep: ValidationStep?) : ValidationStep {

    override fun validate(item: Item): Boolean {
        try {
            item.location.zipCode.toInt()
        } catch (ex: Exception) {
            throw InvalidLocationException("Zipcode must be an integer.")
        }
        return if (item.location.zipCode.length != MAXIMUM_ZIPCODE_SIZE)
            throw InvalidLocationException("The zipcode provided for the location is bigger than 5 digits.")
        else this.nextStep(item)
    }
}