package com.example.trendagainfrontend.data.data.model

data class Prenda(
    val id: Long,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imagenUrl: String,
    val usuarioId: Long
)