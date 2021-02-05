package com.axis.service

import com.axis.model.Endpoint
import com.axis.repo.EndPointRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EndPointService {
    @Autowired
    private var endpointRepo: EndPointRepo? = null

    fun getAllEndPoints(): MutableList<Endpoint>? {
        return endpointRepo?.findAll()
    }

    fun getEndpointForProductOfPartner(insuranceProductId: String, partnerID: String): Endpoint? {
        return endpointRepo?.findEndpointForProductOfPartner(insuranceProductId, partnerID)
    }

    fun getAllEndpointsForProduct(insuranceProductId: String): MutableList<Endpoint>? {
        return endpointRepo?.findEndpointsForAProduct(insuranceProductId)
    }

    fun addEndPoint(endpoint: Endpoint): Endpoint? {
        return endpointRepo?.save(endpoint)
    }

    fun updateFormFieldsForAProduct(endpointDetails: Endpoint) {
        endpointRepo?.save(endpointDetails)
    }

    fun deleteEndPointsForAProduct(productID: String) {
        var endpoints: MutableList<Endpoint>? = endpointRepo?.findEndpointsForAProduct(productID)
        if (endpoints != null) {
            endpointRepo?.deleteAll(endpoints)
        }
    }

    fun deleteEndPointOfAProductForAPartner(productID: String, partnerID: String) {
        var endpoint: Endpoint? = endpointRepo?.findEndpointForProductOfPartner(productID, partnerID)
        if (endpoint != null) {
            endpointRepo?.delete(endpoint)
        }
    }
}