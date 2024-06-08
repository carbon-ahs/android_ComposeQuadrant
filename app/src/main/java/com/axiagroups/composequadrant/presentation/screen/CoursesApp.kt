package com.axiagroups.composequadrant.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axiagroups.composequadrant.data.local.DataSource
import com.axiagroups.composequadrant.presentation.component.TopicCard


/**
 * Created by Ahsan Habib on 6/8/2024.
 */

@Composable
fun CoursesApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(DataSource.topics) { topic ->
                    TopicCard(
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        topic = topic
                    )
                }
            }
        }
    }
}