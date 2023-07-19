package com.vitorpatrezze.hotelservice.repository

import com.vitorpatrezze.hotelservice.model.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface LocationRepository : JpaRepository<Location, Long> {
}