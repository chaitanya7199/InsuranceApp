package com.axis.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("endPoints")
class Endpoint {

    @Id
    var _id: String = ""
    var productID: String = ""
    var partnerID: String = ""
    var apiEndpoint: String = ""
    var apiMethod: String = ""
    var apiSignature: Map<String, String>? = null

    constructor()
    constructor(
        productID: String,
        partnerID: String,
        apiEndpoint: String,
        apiMethod: String,
        apiSignature: Map<String, String>?
    ) {
        this.productID = productID
        this.partnerID = partnerID
        this.apiEndpoint = apiEndpoint
        this.apiMethod = apiMethod
        this.apiSignature = apiSignature
    }

    override fun toString(): String {
        return "Endpoint(productID='$productID', partnerID='$partnerID', apiEndpoint='$apiEndpoint', apiMethod='$apiMethod', apiSignature=$apiSignature)"
    }


}