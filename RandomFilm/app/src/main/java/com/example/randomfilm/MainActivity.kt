package com.example.randomfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.randomfilm.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var movieList: MutableList<String>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieList = getFilms()
    }

    fun randomFilm(v: View) {
        if (movieList.isEmpty()) {
            binding.textView2.text = getString(R.string.finish)
        } else {
            val idx = Random.nextInt(movieList.size)
            val movie = movieList[idx]
            movieList.removeAt(idx)
            binding.textView2.text = movie
        }
    }


    private fun getFilms(): MutableList<String> =
        resources.getStringArray(R.array.movie_list).toMutableList()

    fun restartFilms(v: View){
        movieList = getFilms()
        binding.textView2.text = getString(R.string.header)
    }
}
