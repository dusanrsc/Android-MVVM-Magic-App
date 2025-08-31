package com.example.mvvm_retrofit_magicapp.model

data class WizardData (
    val elixirs: List<WizardElixir>?,
    val id: String,
    val firstName: String?,
    val lastName: String?
)

data class WizardElixir(
    val id: String,
    val name: String?,
)