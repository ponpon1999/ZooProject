package com.example.animal

data class dataView(var name: String, var info: String?,var pic: String?)

data class animal(
    val result: Result
)

data class Result(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<ResultX>
)

data class ResultX(
    val _id: Int,
    val _importdate: Importdate,
    val e_no: String,
    val e_category: String,
    val e_name: String,
    val e_pic_url: String,
    val e_info: String,
    val e_memo: String,
    val e_geo: String,
    val e_url: String
)

data class Importdate(
    val date: String,
    val timezone_type: Int,
    val timezone: String
)

data class Plant(
    val result: PlantResult
)

data class PlantResult(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<PlantResultX>
)

data class PlantResultX(
    val _id: Int,
    val F_Name_Ch: String,
    val F_Summary: String,
    val F_Keywords: String,
    val F_AlsoKnown: String,
    val F_Geo: String,
    val F_Location: String,
    val F_Name_En: String,
    val F_Name_Latin: String,
    val F_Family: String,
    val F_Genus: String,
    val F_Brief: String,
    val F_Feature: String,
    val F_Code: String,
    val F_Pic01_ALT: String,
    val F_Pic01_URL: String,
    val F_Pic02_ALT: String,
    val F_Pic02_URL: String,
    val F_Pic03_ALT: String,
    val F_Pic03_URL: String,
    val F_Pic04_ALT: String,
    val F_Pic04_URL: String,
    val F_pdf01_ALT: String,
    val F_pdf01_URL: String,
    val F_pdf02_ALT: String,
    val F_pdf02_URL: String,
    val F_Voice01_ALT: String,
    val F_Voice01_URL: String,
    val F_Voice02_ALT: String,
    val F_Voice02_URL: String,
    val F_Voice03_ALT: String,
    val F_Voice03_URL: String,
    val F_Vedio_URL: String,
    val F_Update: String,
    val F_CID: String
)