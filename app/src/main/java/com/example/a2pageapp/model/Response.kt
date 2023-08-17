package com.example.a2pageapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse(
    val id: String?,
    var firstName: String?,
    var lastName: String?,
    val email: String?,
    val dob: String?
)