package com.example.menunavigasiaplikasipikobar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menunavigasiaplikasipikobar.model.InformasiCovidModel
import com.example.menunavigasiaplikasipikobar.databinding.ItemInformasiCovidBinding


class InformasiCovidAdapter(private val itemList: List<InformasiCovidModel>) :
    RecyclerView.Adapter<InformasiCovidAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemInformasiCovidBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemInformasiCovidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.ivImage.setImageResource(item.imageRes)
        holder.binding.tvDate.text = item.date
    }

    override fun getItemCount(): Int = itemList.size
}