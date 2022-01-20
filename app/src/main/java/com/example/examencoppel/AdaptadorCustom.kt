package com.example.examencoppel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examencoppel.DataRetrofit.HeroeData
import com.squareup.picasso.Picasso

class AdaptadorCustom(private var dataSet: ArrayList<HeroeData>) :
    RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.template_heroe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nombre.text = dataSet.get(position).name

        Picasso.get()
            .load(dataSet.get(position).image.url)
            .placeholder(R.drawable.logo)
            .error(R.drawable.ic_baseline_error_24)
            .into(holder.imagen)
    }

    override fun getItemCount()= dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView
        val imagen: ImageView

        init {
            nombre = view.findViewById(R.id.TVNombre)
            imagen = view.findViewById(R.id.IVHeroe)
        }
    }
}