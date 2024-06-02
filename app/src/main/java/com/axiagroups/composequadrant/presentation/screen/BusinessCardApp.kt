package com.axiagroups.composequadrant.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Created by Ahsan Habib on 6/2/2024.
 */
@Composable
fun BusinessCardApp(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
            .background(color = Color.Cyan),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Pic",
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = "Ahsan Habib",
                fontSize = 50.sp,
                fontWeight = FontWeight.Thin,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Kamla",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Icon(imageVector = Icons.Default.Call, contentDescription = "call")
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "01755215173")
            }
            Row(
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "call")
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "shehanuk.ahsan@gmail.com")
            }
            Row(
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Icon(imageVector = Icons.Default.Share, contentDescription = "call")
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "www.github.com/carbon-ahs")
            }

        }

    }

}