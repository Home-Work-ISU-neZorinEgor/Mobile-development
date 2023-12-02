package com.example.portraitlandscapepresentk2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.neZorinEgor.adapter.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO: заменять картинку на ту, которую установили при нажатии кнопки
        // иначе будет исходная с котиком
    }

    fun onChangePictureClick(v: View) {
        val iv = findViewById<ImageView>(R.id.picture)

        // TODO: картинку менять по очереди на следущую
        iv.setImageResource(R.drawable.car1)

    }
}