package com.vitorpatrezze.hotelservice.exceptions

class InvalidLocationException(
    message: String = "The zipcode provided for the location is not valid (bigger than 5 digits)."
): Exception(message)