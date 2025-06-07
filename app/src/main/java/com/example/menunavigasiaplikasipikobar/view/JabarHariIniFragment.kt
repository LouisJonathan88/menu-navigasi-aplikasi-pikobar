package com.example.menunavigasiaplikasipikobar.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.menunavigasiaplikasipikobar.R
import com.example.menunavigasiaplikasipikobar.adapter.BannerAdapter
import com.example.menunavigasiaplikasipikobar.databinding.FragmentJabarHariIniBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JabarHariIniFragment : Fragment() {

    private var _binding: FragmentJabarHariIniBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJabarHariIniBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bannerList = listOf(
            R.drawable.banner_1,
            R.drawable.banner_2,
            R.drawable.banner_3
        )
        val bannerAdapter = BannerAdapter(bannerList)
        binding.bannerViewPager.adapter = bannerAdapter

        // Hubungkan dots indicator dengan viewpager2
        binding.dotsIndicator.setViewPager2(binding.bannerViewPager)

        binding.btnCekZona.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


