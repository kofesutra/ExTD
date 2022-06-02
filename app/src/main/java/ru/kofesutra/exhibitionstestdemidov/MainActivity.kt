package ru.kofesutra.exhibitionstestdemidov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.kofesutra.exhibitionstestdemidov.databinding.ActivityMainBinding
import ru.kofesutra.exhibitionstestdemidov.application.ExhibitAdapterOuter
import ru.kofesutra.exhibitionstestdemidov.model.Exhibit
import ru.kofesutra.exhibitionstestdemidov.restExhibitsLoader.Common

class MainActivity : AppCompatActivity() {

    lateinit var adapterOuter: ExhibitAdapterOuter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        runLoader()
    }

    private fun runLoader() {

        Common.retrofitService.getData().enqueue(object : Callback<List<Exhibit>> {
            override fun onResponse(call: Call<List<Exhibit>>, response: Response<List<Exhibit>>) {

                adapterOuter = ExhibitAdapterOuter(baseContext, response.body() as List<Exhibit>)
                val recOut = binding.recyclerOuter
                recOut.adapter = adapterOuter
                adapterOuter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<Exhibit>?>, t: Throwable) {
                d("MainActivity", "onFailure: "+t.message)
            }
        })
    }
}