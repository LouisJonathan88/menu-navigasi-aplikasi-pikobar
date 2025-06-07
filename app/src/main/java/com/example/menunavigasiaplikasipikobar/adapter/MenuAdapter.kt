package com.example.menunavigasiaplikasipikobar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menunavigasiaplikasipikobar.databinding.ItemMenuBinding
import com.example.menunavigasiaplikasipikobar.model.MenuItemModel

class MenuAdapter(private var menuList: List<MenuItemModel>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(private val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuItemModel) {
            binding.icon.setImageResource(item.iconResId)
            binding.label.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuList[position])
    }

    override fun getItemCount(): Int = menuList.size

    fun updateData(newList: List<MenuItemModel>) {
        menuList = newList
        notifyDataSetChanged()
    }
}
