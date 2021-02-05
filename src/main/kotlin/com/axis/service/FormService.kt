package com.axis.service

import com.axis.model.FormField
import com.axis.repo.FormRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FormService {

    @Autowired
    private var formRepo: FormRepo? = null

    fun getFormsForProduct(productID: String): Optional<FormField>? {
        return formRepo?.findById(productID)
    }

    fun getFormsForAllProducts(): MutableList<FormField>? {
        return formRepo?.findAll()
    }

    fun addFormFields(formFields: FormField): FormField? {
        return formRepo?.save(formFields)
    }

    fun updateFormFieldsForAProduct(formFields: FormField) {
        formRepo?.save(formFields)
    }

    fun deleteFormForAProduct(productID: String) {
        formRepo?.deleteById(productID)
    }
}