package com.example.menunavigasiaplikasipikobar.view


import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.menunavigasiaplikasipikobar.R
import com.example.menunavigasiaplikasipikobar.databinding.FragmentBerandaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BerandaFragment : Fragment() {

    private lateinit var binding: FragmentBerandaBinding
    private var currentFragment: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showFragment(JabarHariIniFragment())

        binding.btnJabarHariIni.setOnClickListener {
            updateTabUI(isJabarSelected = true)
            showFragment(JabarHariIniFragment())
        }

        binding.btnCovidInfo.setOnClickListener {
            updateTabUI(isJabarSelected = false)
            showFragment(InformasiCovidFragment())
        }
    }

    private fun updateTabUI(isJabarSelected: Boolean) {
        binding.notifCovid.visibility = if (isJabarSelected) View.VISIBLE else View.GONE

        val green = ContextCompat.getColor(requireContext(), R.color.green)
        val white = ContextCompat.getColor(requireContext(), R.color.white)
        val gray = ContextCompat.getColor(requireContext(), android.R.color.darker_gray)

        // Background warna tombol
        binding.btnJabarHariIni.setBackgroundTintList(
            ColorStateList.valueOf(if (isJabarSelected) green else white)
        )
        binding.btnCovidInfo.setBackgroundTintList(
            ColorStateList.valueOf(if (isJabarSelected) white else green)
        )

        // Warna teks tombol
        binding.btnJabarHariIni.setTextColor(if (isJabarSelected) white else gray)
        binding.btnCovidInfo.setTextColor(if (isJabarSelected) gray else white)
    }


    private fun showFragment(fragment: Fragment) {
        if (fragment::class == currentFragment?.javaClass) return

        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()

        currentFragment = fragment
    }
}