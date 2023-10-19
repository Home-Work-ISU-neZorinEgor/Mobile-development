package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val etA = findViewById<EditText>(R.id.numA)
        val etB = findViewById<EditText>(R.id.numB)
        val strA = etA.text.toString()
        val strB = etB.text.toString()

        if (strA.isEmpty() || strB.isEmpty()) {
            // Один из полей пуст, покажем сообщение "неправильный ввод"
            Toast.makeText(this, "Неправильный ввод. Заполните оба поля.", Toast.LENGTH_SHORT).show()
        } else {
            try {
                val numA = strA.toFloat()
                val numB = strB.toFloat()
                val sum = numA + numB
                val tvSum = findViewById<TextView>(R.id.sum)
                tvSum.text = sum.toString()
            } catch (e: NumberFormatException) {
                // Возникла ошибка при преобразовании строки в число (некорректный ввод)
                Toast.makeText(this, "Неправильный ввод. Введите числа.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}