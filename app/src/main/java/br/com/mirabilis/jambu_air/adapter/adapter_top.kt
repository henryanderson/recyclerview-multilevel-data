package br.com.mirabilis.jambu_air.adapter

import br.com.mirabilis.jambu_air.R
import br.com.mirabilis.jambu_air.model.mTOP

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mirabilis.jambu_air.model.mSubTOP
import org.json.JSONObject

class adapter_top(val Datane: ArrayList<mTOP>): RecyclerView.Adapter<adapter_top.ViewHolder>() {


    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: adapter_top.ViewHolder, position: Int) {

        holder.tvHeader?.text = Datane[position].header

       holder.rvList?.layoutManager = LinearLayoutManager(holder.rvList.context, LinearLayout.VERTICAL, false)
       var adapterSub = adapter_sub(arrayListOf(Datane[position].sub))

        holder.rvList?.adapter = adapterSub
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter_top.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_top, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Datane.count()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvHeader = itemView.findViewById<TextView>(R.id.tvHeader)
        val rvList = itemView.findViewById<RecyclerView>(R.id.rvItem)
    }
}
