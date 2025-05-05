package com.example.trendagainfrontend.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.R
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.trendagainfrontend.data.data.api.RetrofitClient
import com.example.trendagainfrontend.data.data.model.Prenda
import kotlinx.coroutines.launch

class UploadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        findViewById<Button>(R.id.btnSubir).setOnClickListener {
            val nombre = findViewById<EditText>(R.id.etNombre).text.toString()
            val precio = findViewById<EditText>(R.id.etPrecio).text.toString().toDouble()

            val nuevaPrenda = Prenda(
                id = 0, // El backend lo asigna
                nombre = nombre,
                precio = precio,
                descripcion = "Descripción opcional",
                imagenUrl = "https://ejemplo.com/imagen.jpg" // Reemplaza con lógica para subir imágenes
            )

            subirPrenda(nuevaPrenda)
        }
    }

    private fun subirPrenda(prenda: Prenda) {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.uploadPrenda(prenda)
                if (response.isSuccessful) {
                    Toast.makeText(this@UploadActivity, "¡Prenda subida!", Toast.LENGTH_SHORT).show()
                    finish() // Cierra la actividad
                }
            } catch (e: Exception) {
                Toast.makeText(this@UploadActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
