package com.axiagroups.composequadrant.presentation.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axiagroups.composequadrant.R
import com.axiagroups.composequadrant.domain.model.Fridge


/**
 * Created by Ahsan Habib on 6/6/2024.
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var fridgeId : Int by remember {
        mutableStateOf(0)
    }
    var painter = painterResource(Fridge.fridgeList.get(fridgeId).imageResId)
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Card(
                    onClick = {},
                    modifier = Modifier.size(width = 250.dp, height = 350.dp),
                    enabled = false,
                    shape = RoundedCornerShape(2.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 24.dp,
                        disabledElevation = 16.dp
                    )
                ) {
                    Image(
                        painter = painter, //painterResource(id = Fridge.fridgeList.get(fridgeId).imageResId),
                        contentDescription = "rick",
                        modifier = Modifier.padding(32.dp)
                            .weight(1f, fill = false)
                            .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                            .fillMaxWidth(),
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Walton Fridge",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light
                    )
                    Row {
                        Text(
                            text = Fridge.fridgeList.get(fridgeId).modelName,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "(${Fridge.fridgeList.get(fridgeId).year})",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(24.dp)
            ) {
                Button(
                    onClick = { if (fridgeId > 0) fridgeId-- else return@Button},
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Previous")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    onClick = { if (fridgeId < Fridge.fridgeList.size - 1) fridgeId++ else return@Button},
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Next")
                }

            }
        }
    }

}

fun makeToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}
