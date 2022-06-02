package ru.kofesutra.exhibitionstestdemidov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.kofesutra.exhibitionstestdemidov.Application.ExhibitAdapter
import ru.kofesutra.exhibitionstestdemidov.Application.ExhibitAdapterInner
import ru.kofesutra.exhibitionstestdemidov.model.Exhibit
import ru.kofesutra.exhibitionstestdemidov.model.ExhibitsLoader
import ru.kofesutra.exhibitionstestdemidov.restExhibitsLoader.Common
import ru.kofesutra.exhibitionstestdemidov.databinding.ActivityMainBinding
import ru.kofesutra.exhibitionstestdemidov.databinding.CardViewBinding

class MainActivity : AppCompatActivity() {

    lateinit var adapterOuter: ExhibitAdapter
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

                adapterOuter = ExhibitAdapter(baseContext, response.body() as List<Exhibit>)
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