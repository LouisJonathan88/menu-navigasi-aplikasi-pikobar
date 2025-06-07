package com.example.menunavigasiaplikasipikobar.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menunavigasiaplikasipikobar.R
import com.example.menunavigasiaplikasipikobar.databinding.ItemFaqBinding

class FaqAdapter(
    private val faqList: List<Pair<String, String>>
) : RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {

    // Buka pertanyaan pertama saat awal
    private var expandedPosition = 0

    inner class FaqViewHolder(val binding: ItemFaqBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val binding = ItemFaqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FaqViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        val (question, answer) = faqList[position]
        val isExpanded = position == expandedPosition

        with(holder.binding) {
            questionText.text = question
            answerText.text = answer
            answerText.visibility = if (isExpanded) View.VISIBLE else View.GONE

            // Bold saat aktif, normal saat tidak aktif
            questionText.setTypeface(null, if (isExpanded) Typeface.BOLD else Typeface.NORMAL)

            // Icon panah dinamis
            arrowIcon.setImageResource(
                if (isExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_right
            )

            // Click listener: hanya satu yang terbuka
            root.setOnClickListener {
                val previousPosition = expandedPosition
                expandedPosition = if (isExpanded) -1 else position
                notifyItemChanged(previousPosition)
                notifyItemChanged(expandedPosition)
            }
        }
    }

    override fun getItemCount(): Int = faqList.size
}
