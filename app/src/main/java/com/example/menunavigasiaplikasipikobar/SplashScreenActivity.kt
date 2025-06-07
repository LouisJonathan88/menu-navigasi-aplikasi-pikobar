package com.example.menunavigasiaplikasipikobar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.menunavigasiaplikasipikobar.view.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val lottie = findViewById<LottieAnimationView>(R.id.lottieView)

        Handler(Looper.getMainLooper()).postDelayed({
            lottie.visibility = LottieAnimationView.VISIBLE
            lottie.alpha = 0f
            lottie.animate().alpha(1f).setDuration(500).withEndAction {
                lottie.playAnimation()
            }.start()

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)

        }, 2000)
    }
}
