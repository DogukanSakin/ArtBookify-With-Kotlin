package com.example.artbookify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.artbookify.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater);
        val view = binding.root;
        setContentView(view);
    }
    fun saveInfo(view: View){

    }
    fun uploadImage(view:View){

    }
}