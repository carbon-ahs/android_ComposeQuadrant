package com.axiagroups.composequadrant.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.axiagroups.composequadrant.presentation.component.ComposableInfoCard


/**
 * Created by Ahsan Habib on 6/2/2024.
 */

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            ComposableInfoCard(
                modifier = Modifier.weight(1f),
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF)
            )
            ComposableInfoCard(
                modifier = Modifier.weight(1f),
                title = "Image  composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            ComposableInfoCard(
                modifier = Modifier.weight(1f),
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8)
            )
            ComposableInfoCard(
                modifier = Modifier.weight(1f),
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF)
            )
        }

    }

}