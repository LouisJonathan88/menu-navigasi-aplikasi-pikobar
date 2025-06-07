package com.example.menunavigasiaplikasipikobar.view

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.menunavigasiaplikasipikobar.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AkunFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fullText =
            "Dengan mencentang checkbox ketika login, maka Anda setuju dengan syarat dan ketentuan Terms & Conditions dan privasi data Data Privacy penggunaan aplikasi Pikobar"

        val spannable = SpannableString(fullText)

        val termsStart = fullText.indexOf("Terms & Conditions")
        val termsEnd = termsStart + "Terms & Conditions".length
        spannable.setSpan(
            ForegroundColorSpan(Color.BLUE),
            termsStart, termsEnd,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            UnderlineSpan(),
            termsStart, termsEnd,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val privacyStart = fullText.indexOf("Data Privacy")
        val privacyEnd = privacyStart + "Data Privacy".length
        spannable.setSpan(
            ForegroundColorSpan(Color.BLUE),
            privacyStart, privacyEnd,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            UnderlineSpan(),
            privacyStart, privacyEnd,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val textView = view.findViewById<TextView>(R.id.textDisclaimer)
        textView.text = spannable
    }
}
