package com.axis.repo

import com.axis.model.Endpoint
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EndPointRepo: MongoRepository<Endpoint, String> {

    @Query("{'productID' : ?0}")
    fun findEndpointsForAProduct(productID: String): MutableList<Endpoint>

    @Query("{'productID' : ?0, 'partnerID' : ?1}")
    fun findEndpointForProductOfPartner(productID: String, partnerID: String): Endpoint

}