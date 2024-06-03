package com.axiagroups.composequadrant.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.axiagroups.composequadrant.R


/**
 * Created by Ahsan Habib on 6/3/2024.
 */

@Composable
fun DiceRollerApp(
    modifier: Modifier = Modifier,
) {
    DiceWithButtonAndImage(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )

}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 = remember {
        mutableStateOf(1)
    }
    var result2 by remember {
        mutableStateOf(1)
    }
    val imageResource1 = when (result1.value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val imageResource2 = when (result2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = (result1.value + result2).toString())
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Image(
                painter = painterResource(id = imageResource1),
                contentDescription = "dice image 1"
            )
            Image(
                painter = painterResource(id = imageResource2),
                contentDescription = "dice image 2"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result1.value = (1..6).random()
            result2 = (1..6).random()
        }) {
            Text(text = stringResource(R.string.roll))
        }

    }
}
