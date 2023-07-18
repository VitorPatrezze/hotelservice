package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.exceptions.InvalidImagePathException
import com.vitorpatrezze.hotelservice.model.Item
import java.net.MalformedURLException
import java.net.URL

class ImageValidationStep(override val nextStep: ValidationStep?) : ValidationStep {
    override fun validate(item: Item): Boolean {
        return try {
            URL(item.imagePath)
            nextStep(item)
        } catch (e: MalformedURLException) {
            throw InvalidImagePathException()
        }
    }
}