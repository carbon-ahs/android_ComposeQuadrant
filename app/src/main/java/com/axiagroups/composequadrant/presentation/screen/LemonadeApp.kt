package com.axiagroups.composequadrant.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axiagroups.composequadrant.R


/**
 * Created by Ahsan Habib on 6/3/2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(
    modifier: Modifier = Modifier,
) {
    var imgResId by remember {
        mutableStateOf(R.drawable.lemon_tree)
    }
    var instruction by remember {
        mutableStateOf(R.string.select_lemon_tree)
    }
    var clickCounter by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "Lemonade", fontWeight = FontWeight.Bold)
                    }
                },
                modifier = Modifier.background(Color.Yellow),
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Yellow)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.Green)
                    .clickable {
                        clickCounter++
                        if (clickCounter >= (2..4).random()) {
                            clickCounter = 0
                        }

                    }
            ) {
                Image(
                    painter = painterResource(id = imgResId),
                    contentDescription = "img",
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = instruction),
                fontSize = 18.sp
            )
        }

    }
}


