package com.axis.repo

import com.axis.model.FormField
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FormRepo: MongoRepository<FormField, String> {

}