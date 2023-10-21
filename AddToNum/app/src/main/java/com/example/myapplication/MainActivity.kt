package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Нет необходимости использовать findViewById, так как все элементы уже доступны через View Binding
    }

    fun onClick(view: View) {
        val strA = binding.numA.text.toString()
        val strB = binding.numB.text.toString()

        if (strA.isEmpty() || strB.isEmpty()) {
            // Одно из полей пусто, выводим сообщение "Неверный ввод. Заполните оба поля."
            Toast.makeText(this, "Неверный ввод. Заполните оба поля.", Toast.LENGTH_SHORT).show()
        } else {
            try {
                val numA = strA.toFloat()
                val numB = strB.toFloat()
                val sum = numA + numB
                binding.sum.text = sum.toString()
            } catch (e: NumberFormatException) {
                // Произошла ошибка при преобразовании строки в число (некорректный ввод)
                Toast.makeText(this, "Неверный ввод. Введите числа.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
