package ru.kofesutra.exhibitionstestdemidov.restExhibitsLoader

import ru.kofesutra.exhibitionstestdemidov.model.ExhibitsLoader

object Common {
    private const val BASE_URL = "https://my-json-server.typicode.com/Reyst/exhibit_db/"
    val retrofitService: ExhibitsLoader
        get() = RetrofitClient.getClient(BASE_URL).create(ExhibitsLoader::class.java)
}