package com.axiagroups.composequadrant.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axiagroups.composequadrant.R
import com.axiagroups.composequadrant.domain.model.Topic


/**
 * Created by Ahsan Habib on 6/8/2024.
 */

@Composable
fun TopicCard(modifier: Modifier = Modifier, topic: Topic) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResId),
                contentDescription = null,
                modifier = Modifier.size(68.dp)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = LocalContext.current.getString(topic.nameResId),
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.numberOfCourse.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun TopicCardPrev() {
    TopicCard(topic = Topic(R.string.business, 55, R.drawable.photography))

}