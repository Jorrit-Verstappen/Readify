package dev.jorritv.readify.ui.screens.library

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LibraryPage() {
    MaterialTheme {
        val list = listOf("Book 1", "Book 2", "Book 3")
        val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { selectedUri ->
            if (selectedUri != null) {
                println("File selected = $selectedUri")
            } else {
                println("No file was selected")
            }
        }

        Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            list.forEach { item ->
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text(text = item)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Use the file type for .epub and .pdf
            Button(onClick = { launcher.launch("application/*") }) {
                Text("Pick a File")
            }
        }
    }
}
