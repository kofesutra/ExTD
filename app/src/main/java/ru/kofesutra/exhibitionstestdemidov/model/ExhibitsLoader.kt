package ru.kofesutra.exhibitionstestdemidov.model

import retrofit2.Call
import retrofit2.http.GET

// Интерфейс
interface ExhibitsLoader {
    @GET("list")
    fun getData(): Call<List<Exhibit>>
}