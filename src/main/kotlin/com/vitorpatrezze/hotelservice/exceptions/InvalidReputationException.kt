package com.vitorpatrezze.hotelservice.exceptions

class InvalidReputationException(
    message: String = "Reputation must be and integer between 0 and 1000."
): Exception(message)