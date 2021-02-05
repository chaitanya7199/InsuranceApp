package com.axis.model


import org.json.simple.JSONObject
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("formFields")
class FormField {

    @Id
    var productID: String = ""
    var fields: ArrayList<JSONObject>? = null

    constructor()
    constructor(productID: String, fields: ArrayList<JSONObject>?) {
        this.productID = productID
        this.fields = fields
    }


    override fun toString(): String {
        return "FormField(productID='$productID', fields=$fields)"
    }
}