package com.mycodinglab.angelapp.data


import com.squareup.moshi.Json

data class StockDetail(

    @field:Json(name = "Security Code")
    val securityCode: String,

    @field:Json(name = "Issuer Name")
     val isssuerName: String,

    @field:Json(name = "Security Id")
    val securityId: String,

    @field:Json(name = "Security Name")
    val securityName: String,

    @field:Json(name = "Status")
    val Status: String,
    @field:Json(name = "Group")
    val group: String,
    @field:Json(name = "Face Value")
    val faceValue: String,
    @field:Json(name = "ISIN No")
    val isinNo: String,
    @field:Json(name = "Industry")
    val industry: String,
    @field:Json(name = "Instrument")
    val instrument: String

)