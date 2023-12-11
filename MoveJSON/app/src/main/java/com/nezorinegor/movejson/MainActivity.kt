package com.nezorinegor.movejson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.nezorinegor.movejson.databinding.ActivityMainBinding
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var movies: List<Movie>
    private var ptr = 0

    private lateinit var staticTvs: Array<TextView>
    private fun updateMovies(v: View) {
        viewBinding.errorTv.text = ""
        viewBinding.titleTv.text = ""
        viewBinding.durationTv.text = ""
        viewBinding.countryTv.text = ""
        viewBinding.yearTv.text = ""
        viewBinding.ratingTv.text = ""
        setStaticTvVisibility(View.INVISIBLE)
        initMovies()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        movies = parseMovies(R.raw.movies)
        staticTvs = arrayOf(viewBinding.staticTitleTv, viewBinding.staticDurationTv,
            viewBinding.staticCountryTv, viewBinding.staticYearTv, viewBinding.staticRatingTv)
        setStaticTvVisibility(View.INVISIBLE)
        initMovies()
        viewBinding.btnSelect.setOnClickListener(this::showMovie)
        viewBinding.btnRst.setOnClickListener(this::updateMovies)
    }

    private fun showMovie(v: View) {
        if (ptr >= movies.size) {
            viewBinding.errorTv.text = getString(R.string.err)
            return
        }

        if (viewBinding.staticTitleTv.visibility != View.VISIBLE) {
            setStaticTvVisibility(View.VISIBLE)
        }

        if (viewBinding.errorTv.text.isNotEmpty()) {
            viewBinding.errorTv.text = ""
        }

        val movie = movies[ptr++]
        with(viewBinding) {
            titleTv.text = movie.title
            durationTv.text = movie.duration
            countryTv.text = movie.country.joinToString(", ")
            yearTv.text = movie.year
            ratingTv.text = movie.rating
        }
    }




    private fun initMovies() {
        viewBinding.errorTv.text = getString(R.string.start_msg)
        movies = movies.shuffled()
        ptr = 0
    }

    private fun setStaticTvVisibility(visibility: Int = View.INVISIBLE) {
        staticTvs.forEach { it.visibility = visibility }
    }


    private fun parseMovies(id: Int): List<Movie> {
        val gson = Gson()
        val stream = resources.openRawResource(id)
        val reader = InputStreamReader(stream)
        return gson.fromJson(reader, Movies::class.java).movies.toList()
    }
}