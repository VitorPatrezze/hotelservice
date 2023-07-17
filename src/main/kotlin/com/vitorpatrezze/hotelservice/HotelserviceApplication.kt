package com.vitorpatrezze.hotelservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class HotelserviceApplication

fun main(args: Array<String>) {
	runApplication<HotelserviceApplication>(*args)
}
