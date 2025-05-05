package com.example.trendagainfrontend

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trendagainfrontend.data.data.api.RetrofitClient
import com.example.trendagainfrontend.ui.theme.adapters.PrendasAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvPrendas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadPrendas() // Cargar datos desde el backend
    }

    private fun loadPrendas() {
        lifecycleScope.launch {
            try {
                val prendas = RetrofitClient.instance.getPrendas()
                recyclerView.adapter = PrendasAdapter(prendas)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
