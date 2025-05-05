package com.example.trendagainfrontend.ui.theme.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trendagainfrontend.data.data.model.Prenda

class PrendasAdapter(private val prendas: List<Prenda>) :
    RecyclerView.Adapter<PrendasAdapter.PrendaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrendaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prenda, parent, false)
        return PrendaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrendaViewHolder, position: Int) {
        holder.bind(prendas[position])
    }

    override fun getItemCount(): Int = prendas.size

    inner class PrendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(prenda: Prenda) {
            itemView.tvNombre.text = prenda.nombre
            itemView.tvPrecio.text = "$${prenda.precio}"
            // Cargar imagen con Glide
            Glide.with(itemView)
                .load(prenda.imagenUrl)
                .into(itemView.ivPrenda)
        }
    }
}