package br.com.mirabilis.jambu_air.adapter

import br.com.mirabilis.jambu_air.R
import br.com.mirabilis.jambu_air.model.mSubTOP


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_sub(val Datane: ArrayList<mSubTOP>): RecyclerView.Adapter<adapter_sub.ViewHolder>() {

    override fun onBindViewHolder(holder: adapter_sub.ViewHolder, position: Int) {
        val location = Datane[position]
        holder.tvName?.text = location.warna
        holder.tvHobi?.text = location.jenis

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter_sub.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_sub, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Datane.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvJenis)
        val tvHobi = itemView.findViewById<TextView>(R.id.tvWarna)
    }
}