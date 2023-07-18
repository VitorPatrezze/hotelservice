package com.vitorpatrezze.hotelservice.exceptions

class InvalidRatingException(message: String = "Rating must be an integer between 0 and 5."): Exception(message)