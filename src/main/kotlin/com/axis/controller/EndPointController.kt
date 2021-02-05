package com.axis.controller

import com.axis.model.Endpoint
import com.axis.service.EndPointService
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import io.swagger.annotations.ApiOperation
import org.bson.Document
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000", "http://localhost:3001")
//@RequestMapping("/esperanza")
@RestController
class EndPointController {

    @Autowired
    private var endpointService: EndPointService? = null

    @ApiOperation(value = "Get all endPoints details")
    @GetMapping("/endPoints")
    fun getAllEndPoints(): MutableList<Endpoint>? {
        return endpointService?.getAllEndPoints()
    }

    @ApiOperation(value = "Get endpoint for a particular product of a particular partner")
    @GetMapping("/endPoints/{insuranceProductId}/{partnerID}")
    fun getEndpointForProductOfPartner(@PathVariable insuranceProductId: String, @PathVariable partnerID: String): Endpoint? {
        return endpointService?.getEndpointForProductOfPartner(insuranceProductId, partnerID)
    }

    @ApiOperation(value = "Get all endpoints for a particular product")
    @GetMapping("/endPoints/{insuranceProductId}")
    fun getAllEndpointsForProduct(@PathVariable insuranceProductId: String): MutableList<Endpoint>? {
        return endpointService?.getAllEndpointsForProduct(insuranceProductId)
    }

    @ApiOperation(value = "Add new endpoint")
    @PostMapping("/endPoints")
    fun addEndPoints(@RequestBody endpoint: Endpoint): Endpoint? {
        return endpointService?.addEndPoint(endpoint)
    }

    @ApiOperation(value = "Update api config of a product for a partner")
    @PutMapping("/endPoints")
    fun updateFormFieldsForAProduct(@RequestBody endpointDetails: Endpoint) {
        endpointService?.updateFormFieldsForAProduct(endpointDetails)
    }

    @ApiOperation(value = "Delete endPoints for a product")
    @DeleteMapping("/endPoints")
    fun deleteEndPointsForAProduct(productID: String) {
        endpointService?.deleteEndPointsForAProduct(productID)
    }

    @ApiOperation(value = "Delete endPoints of a product for a partner")
    @DeleteMapping("/endPoints/{productID}/{partnerID}")
    fun deleteEndPointsOfAProductForAPartner(@PathVariable productID: String, @PathVariable partnerID: String) {
        endpointService?.deleteEndPointOfAProductForAPartner(productID, partnerID)
    }
}