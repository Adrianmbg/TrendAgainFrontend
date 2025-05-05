package com.example.trendagainfrontend.data.data.api

import com.example.trendagainfrontend.data.data.model.Prenda
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    // Obtener todas las prendas
    @GET("prendas")
    suspend fun getPrendas(): List<Prenda>

    // Subir una nueva prenda (POST)
    @POST("prendas")
    suspend fun uploadPrenda(@Body prenda: Prenda): Response<Prenda>

    // Ejemplo con parámetros: GET prendas por usuario
    @GET("prendas/usuario/{userId}")
    suspend fun getPrendasByUser(@Path("userId") userId: Int): List<Prenda>

    // Ejemplo con query params: Búsqueda por nombre
    @GET("prendas/search")
    suspend fun searchPrendas(@Query("nombre") query: String): List<Prenda>
}