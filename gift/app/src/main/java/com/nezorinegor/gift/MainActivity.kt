package com.nezorinegor.gift

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nezorinegor.gift.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.getRoot())
    }
}