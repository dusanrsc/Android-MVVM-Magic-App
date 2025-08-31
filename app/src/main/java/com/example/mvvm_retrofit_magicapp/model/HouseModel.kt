package com.example.mvvm_retrofit_magicapp.model

data class HouseData(
    val id: String,
    val name: String,
    val houseColours: String,
    val founder: String,
    val animal: String,
    val element: String,
    val ghost: String,
    val commonRoom: String,
    val heads: List<HouseHead>,
    //val traits: List<Trait>
)

data class HouseHead(
    val id: String,
    val firstName: String,
    val lastName: String
)