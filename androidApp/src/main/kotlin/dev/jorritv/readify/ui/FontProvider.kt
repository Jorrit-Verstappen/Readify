package dev.jorritv.readify.ui

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import dev.jorritv.readify.R

object FontProvider {

    private val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val caladeaFont = FontFamily(
        Font(googleFont = GoogleFont("Caladea"), fontProvider = provider)
    )
    val comfortaaFont = FontFamily(
        Font(googleFont = GoogleFont("Comfortaa"), fontProvider = provider)
    )
}
