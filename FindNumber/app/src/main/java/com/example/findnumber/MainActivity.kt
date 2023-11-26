package com.example.findnumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.findnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var minNum = 0
    var maxNum = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        minNum = intent.getIntExtra("min", 0)
        maxNum = intent.getIntExtra("max", 0)

        binding.textView.text = ((maxNum + minNum) / 2).toString()
    }

    fun onClick2(view: View) {
        if (maxNum - minNum <= 1){
            binding.textView.text = "Ваше число $minNum"
            binding.textView.setTextColor(Color.GREEN)
        }
        else{
            if (view.id == R.id.button2){
                maxNum = (maxNum + minNum) / 2
            }
            else if (view.id == R.id.button3){
                minNum = (maxNum + minNum) / 2
            }
            binding.textView.text = "${((maxNum + minNum) / 2)}"
        }
    }
}
