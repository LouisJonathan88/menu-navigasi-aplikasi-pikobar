package com.example.menunavigasiaplikasipikobar.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menunavigasiaplikasipikobar.R
import com.example.menunavigasiaplikasipikobar.adapter.InformasiCovidAdapter
import com.example.menunavigasiaplikasipikobar.databinding.FragmentInformasiCovidBinding
import com.example.menunavigasiaplikasipikobar.model.InformasiCovidModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformasiCovidFragment : Fragment() {

    private lateinit var binding: FragmentInformasiCovidBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInformasiCovidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Layout managers
        binding.rvInfoPraktikal.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBerita.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvVideo.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvDokumen.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Dummy data
        val infoPraktikalList = listOf(
            InformasiCovidModel("Cuci Masker Kain Dengan Benar", R.drawable.info1, "Hari Ini"),
            InformasiCovidModel("Ventilasi Udara Baik, Cegah Covid19", R.drawable.info2, "Kemarin"),
            InformasiCovidModel("Jangan Kendo 3M! Waspada Kluster Baru", R.drawable.info3, "12 Okt")
        )

        val beritaList = listOf(
            InformasiCovidModel("Ridwan Kamil Tinjau Drainase Kota Depok", R.drawable.berita1, "Hari Ini"),
            InformasiCovidModel("Inovasi Jabar Tingkatkan Pelacakan", R.drawable.berita2, "Kemarin"),
            InformasiCovidModel("Uu Ruzhanul Hadiri Penen Raya Padi", R.drawable.berita3, "12 Okt")
        )

        val videoList = listOf(
            InformasiCovidModel("Laporan Mingguan Penanganan COVID19", R.drawable.video1, "Hari Ini"),
            InformasiCovidModel(
                "Siapa penerima bantuan sosial selama COVID-19?",
                R.drawable.video2,
                "Kemarin"
            ),
            InformasiCovidModel("Uu Ruzhanul Hadiri Penen Raya Padi", R.drawable.video3, "12 Okt")
        )

        val dokumenList = listOf(
            InformasiCovidModel("Keputusan Gubernur Jawa Barat Nomor 443", R.drawable.pdf1, "5 Okt 2020"),
            InformasiCovidModel("Instruksi Gubernur Jawa Barat Nomor 443/07", R.drawable.pdf2, "5 Okt 2020"),
            InformasiCovidModel("Evaluasi PSBB 14 s.d. 20 September", R.drawable.pdf3, "14 Sep 2020")
        )

        // Set adapters
        binding.rvInfoPraktikal.adapter = InformasiCovidAdapter(infoPraktikalList)
        binding.rvBerita.adapter = InformasiCovidAdapter(beritaList)
        binding.rvVideo.adapter = InformasiCovidAdapter(videoList)
        binding.rvDokumen.adapter = InformasiCovidAdapter(dokumenList)
    }
}
