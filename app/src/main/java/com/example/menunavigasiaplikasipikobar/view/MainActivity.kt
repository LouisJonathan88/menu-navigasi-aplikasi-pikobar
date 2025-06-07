// hari tanggal pengerjaan : 4 Juni 2025
// nim                     : 10122362
// nama lengkap            : Louis Jonathan Susanto Putra
// kelas                   : PA 4


package com.example.menunavigasiaplikasipikobar.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.menunavigasiaplikasipikobar.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(BerandaFragment())
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val badge = bottomNav.getOrCreateBadge(R.id.navigation_pesan)
        badge.isVisible = true
        badge.clearNumber()
        badge.backgroundColor = ContextCompat.getColor(this, android.R.color.holo_red_dark)

        badge.horizontalOffset = 16
        badge.verticalOffset = 20

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_beranda -> {
                    loadFragment(BerandaFragment())
                    true
                }
                R.id.navigation_pesan -> {
                    loadFragment(PesanFragment())
                    true
                }
                R.id.navigation_menu -> {
                    val menuSheet = MenuFragment()
                    menuSheet.show(supportFragmentManager, menuSheet.tag)
                    false
                }
                R.id.navigation_faq -> {
                    loadFragment(FaqFragment())
                    true
                }
                R.id.navigation_akun -> {
                    loadFragment(AkunFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
