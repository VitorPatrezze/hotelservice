package com.vitorpatrezze.hotelservice.service.validationSteps

import com.vitorpatrezze.hotelservice.model.Item

interface ValidationStep {
    fun validate(item: Item): Boolean
    fun nextStep(item: Item): Boolean {
        return nextStep?.validate(item) ?: true
    }
    val nextStep: ValidationStep?
}