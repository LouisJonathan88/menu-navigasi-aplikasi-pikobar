package com.example.menunavigasiaplikasipikobar.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.menunavigasiaplikasipikobar.R
import com.example.menunavigasiaplikasipikobar.adapter.MenuAdapter
import com.example.menunavigasiaplikasipikobar.databinding.FragmentMenuBinding
import com.example.menunavigasiaplikasipikobar.model.MenuItemModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : BottomSheetDialogFragment() {

    private var isExpanded = false
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuAwal = listOf(
            MenuItemModel("Data COVID-19", R.drawable.ic_covid),
            MenuItemModel("Informasi Vaksinasi", R.drawable.ic_vaccine),
            MenuItemModel("Ketersediaan Bed RS", R.drawable.ic_bed),
            MenuItemModel("Hotline Pikobar", R.drawable.ic_hotline),
            MenuItemModel("Nomor Darurat", R.drawable.ic_emergency),
            MenuItemModel("Bantuan Sosial", R.drawable.ic_social_aid),
            MenuItemModel("Isolasi Mandiri", R.drawable.ic_isolation),
            MenuItemModel("Cari Oksigen", R.drawable.ic_oxygen)
        )

        val menuTambahan = listOf(
            MenuItemModel("Daftar Tes Masif", R.drawable.ic_test),
            MenuItemModel("Periksa Mandiri", R.drawable.ic_check),
            MenuItemModel("Tanya Jawab", R.drawable.ic_qa),
            MenuItemModel("Permohonan Logistik", R.drawable.ic_logistics),
            MenuItemModel("Survei Pikobar", R.drawable.ic_survey),
            MenuItemModel("Donasi Covid-19", R.drawable.ic_donation),
            MenuItemModel("Saber Hoax", R.drawable.ic_hoax),
            MenuItemModel("Daftar Relawan", R.drawable.ic_volunteer)
        )

        val adapterAwal = MenuAdapter(menuAwal)
        val adapterTambahan = MenuAdapter(menuTambahan)

        binding.recyclerMenu.adapter = adapterAwal
        binding.recyclerMenu.layoutManager = GridLayoutManager(context, 4)

        binding.recyclerMenuTambahan.adapter = adapterTambahan
        binding.recyclerMenuTambahan.layoutManager = GridLayoutManager(context, 4)
        binding.recyclerMenuTambahan.visibility = View.GONE

        // Tambahkan listener ke seluruh area header
        binding.layoutHeader2.setOnClickListener {
            toggleMenu()
        }
        binding.tvHeader2.setOnClickListener {
            toggleMenu()
        }
        binding.ivArrow.setOnClickListener {
            toggleMenu()
        }
    }

    private fun toggleMenu() {
        isExpanded = !isExpanded
        binding.recyclerMenuTambahan.visibility = if (isExpanded) View.VISIBLE else View.GONE
        binding.ivArrow.setImageResource(
            if (isExpanded) R.drawable.panahatas else R.drawable.panahbawah
        )

        // Expand ke full screen saat menu tambahan dibuka
        if (isExpanded) {
            val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let {
                val behavior = BottomSheetBehavior.from(it)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.let {
            val behavior = BottomSheetBehavior.from(it)
            it.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            behavior.peekHeight = (resources.displayMetrics.heightPixels * 0.6).toInt()
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED

            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                        bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }
    }
}
