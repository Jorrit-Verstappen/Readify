package dev.jorritv.readify

import dev.jorritv.readify.ui.screens.library.LibraryPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LibraryPage()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    LibraryPage()
}
