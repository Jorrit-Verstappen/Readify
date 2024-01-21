package dev.jorritv.readify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.jorritv.readify.theme.ReadifyTheme
import dev.jorritv.readify.ui.screens.library.LibraryPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReadifyTheme {
                LibraryPage()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    ReadifyTheme {
        LibraryPage()
    }
}
