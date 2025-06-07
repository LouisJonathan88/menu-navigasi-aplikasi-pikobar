package com.example.menunavigasiaplikasipikobar.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menunavigasiaplikasipikobar.adapter.FaqAdapter
import com.example.menunavigasiaplikasipikobar.databinding.FragmentFaqBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FaqFragment : Fragment() {

    private var _binding: FragmentFaqBinding? = null
    private val binding get() = _binding!!

    private lateinit var faqAdapter: FaqAdapter

    private val faqData = listOf(
        "Apa itu Novel Coronavirus (2019-nCoV)?" to "Novel coronavirus (2019-nCoV) adalah jenis baru coronavirus yang belum pernah diidentifikasi sebelumnya pada manusia. Coronavirus merupakan keluarga besar virus yang menyebabkan penyakit pada manusia dan hewan. Pada manusia menyebabkan penyakit mulai flu biasa hingga penyakit yang serius seperti Middle East Respiratory Syndrome (MERS) dan Sindrom Pernapasan Akut Berat/ Severe Acute Respiratory Syndrome (SARS).\n" +
                "\n" +
                "Pada 11 Februari 2020, World Health Organization (WHO) mengumumkan nama penyakit yang disebabkan 2019-nCoV, yaitu Coronavirus Disease (COVID-19).",
        "Bagaimana cara mencegah penularan COVID-19?" to "Cara mencegah: sering mencuci tangan, menggunakan masker, menjaga jarak, dll.",
        "Apa saja gejala COVID-19?" to "Gejala umum meliputi demam, batuk kering, kelelahan, hilangnya penciuman.",
        "Seberapa bahaya COVID-19 ini?" to "COVID-19 bisa menyebabkan komplikasi serius terutama pada kelompok rentan seperti lansia atau penderita penyakit kronis."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFaqBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        faqAdapter = FaqAdapter(faqData)
        binding.faqRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = faqAdapter
        }

        // Tab clicks (example handling)
        binding.btnInfoCovid.setOnClickListener {
            // Ganti data jika perlu
        }
        binding.btnVaksin.setOnClickListener {
            // Ganti data jika perlu
        }
        binding.btnPsbb.setOnClickListener {
            // Ganti data jika perlu
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
