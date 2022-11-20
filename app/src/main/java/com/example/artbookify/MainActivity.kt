package com.example.artbookify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.artbookify.databinding.ActivityDetailsBinding
import com.example.artbookify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view = binding.root;
        setContentView(view);

    }
}