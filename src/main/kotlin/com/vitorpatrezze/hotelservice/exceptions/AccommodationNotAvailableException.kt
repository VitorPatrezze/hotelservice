package com.vitorpatrezze.hotelservice.exceptions

class AccommodationNotAvailableException(
    message: String = "There is no availability in this accomodation"
): Exception(message)