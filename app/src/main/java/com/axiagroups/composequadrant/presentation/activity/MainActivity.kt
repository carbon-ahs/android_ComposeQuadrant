package com.axiagroups.composequadrant.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.axiagroups.composequadrant.presentation.screen.AffirmationApp
import com.axiagroups.composequadrant.presentation.screen.ArtSpaceApp
import com.axiagroups.composequadrant.presentation.screen.BusinessCardApp
import com.axiagroups.composequadrant.presentation.screen.ComposeQuadrantApp
import com.axiagroups.composequadrant.presentation.screen.CoursesApp
import com.axiagroups.composequadrant.presentation.screen.DiceRollerApp
import com.axiagroups.composequadrant.presentation.screen.LemonadeApp
import com.axiagroups.composequadrant.presentation.screen.TipTimeApp
import com.axiagroups.composequadrant.presentation.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                CoursesApp()
//                AffirmationApp()
//                ArtSpaceApp()
//                TipTimeApp()
//                LemonadeApp()
//                ComposeQuadrantApp(modifier = Modifier.padding(innerPadding))
//                BusinessCardApp(modifier = Modifier.padding(innerPadding))
//                DiceRollerApp(Modifier.padding(innerPadding))
//
            }
        }
    }
}



