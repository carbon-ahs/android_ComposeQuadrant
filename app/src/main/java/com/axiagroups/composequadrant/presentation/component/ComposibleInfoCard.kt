package com.axiagroups.composequadrant.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Ahsan Habib on 6/2/2024.
 */
@Composable
fun ComposableInfoCard(
    modifier: Modifier = Modifier,
    title: String = "Title",
    description: String = "Description",
    backgroundColor: Color = Color.Red,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .border(BorderStroke(5.dp, Color.Black))
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = description)


    }

}

@Preview
@Composable
private fun Prev() {
    ComposableInfoCard()
}