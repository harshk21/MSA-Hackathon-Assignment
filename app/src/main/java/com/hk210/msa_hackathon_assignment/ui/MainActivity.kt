package com.hk210.msa_hackathon_assignment.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hk210.msa_hackathon_assignment.theme.MSAHackathonAssignmentTheme
import com.hk210.msa_hackathon_assignment.ui.screens.places.PlacesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MSAHackathonAssignmentTheme {
                PlacesScreen(location = "MSA Office Location")
            }
        }
    }
}