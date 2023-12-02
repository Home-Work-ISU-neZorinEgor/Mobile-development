package com.nezorinegor.adaptability

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.nezorinegor.adaptability.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pictures: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pictures = intArrayOf(R.drawable.squarecat, R.drawable.car1, R.drawable.car2, R.drawable.car3)
        binding.spinner.adapter = ArrayAdapter.createFromResource(this, R.array.pictures, R.layout.item)
        binding.picture.setImageResource(pictures[binding.spinner.selectedItemPosition])
    }

    fun nextPictureClick(v: View) {
        binding.picture.setImageResource(pictures[binding.spinner.selectedItemPosition])
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt("KEY", binding.spinner.selectedItemPosition)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val position = savedInstanceState.getInt("KEY")
        binding.picture.setImageResource(pictures[position])
    }
}
