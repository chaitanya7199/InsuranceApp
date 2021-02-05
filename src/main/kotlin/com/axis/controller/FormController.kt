package com.axis.controller

import com.axis.model.FormField
import com.axis.service.FormService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin("http://localhost:3000", "http://localhost:3001")
//@RequestMapping("/esperanza")
@RestController
class FormController {

    @Autowired
    private var formService: FormService? = null

    @ApiOperation(value = "Get form details for a particular product")
    @GetMapping("/forms/{insuranceProductId}")
    fun getFormsForProduct(@PathVariable insuranceProductId: String): Optional<FormField>? {
        return formService?.getFormsForProduct(insuranceProductId)
    }

    @ApiOperation(value = "Get form fields for all products")
    @GetMapping("/forms")
    fun getFormsForAllProducts(): MutableList<FormField>? {
        return formService?.getFormsForAllProducts()
    }

    @ApiOperation(value = "Add form fields for a product")
    @PostMapping("/forms")
    fun addFormFields(@RequestBody formFields: FormField): FormField? {
        return formService?.addFormFields(formFields)
    }

    @ApiOperation(value = "Update form details for a product")
    @PutMapping("/forms")
    fun updateFormFieldsForAProduct(@RequestBody formFields: FormField) {
        formService?.updateFormFieldsForAProduct(formFields)
    }

    @ApiOperation(value = "Delete a form for a product")
    @DeleteMapping("/forms")
    fun deleteFormForAProduct(productID: String) {
        formService?.deleteFormForAProduct(productID)
    }
}