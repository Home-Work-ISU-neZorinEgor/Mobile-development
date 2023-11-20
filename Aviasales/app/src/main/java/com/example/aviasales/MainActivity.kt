package com.example.aviasales

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.aviasales.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.start.setupDatePicker()
        binding.end.setupDatePicker()
    }

    fun EditText.setupDatePicker() {
        setOnClickListener {
            DatePickerDialog(this@MainActivity).apply {
                setOnDateSetListener { _, _, month, dayOfMonth ->
                    val string = "$dayOfMonth.${month + 1}"
                    setText(string)
                }
                show()
            }
        }


    }


}