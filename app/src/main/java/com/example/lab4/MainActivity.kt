package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val manager = LinearLayoutManager(this)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, manager.orientation))
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = Adapter(resources.openRawResource(R.raw.articles))
        setContentView(binding.root)
    }
}