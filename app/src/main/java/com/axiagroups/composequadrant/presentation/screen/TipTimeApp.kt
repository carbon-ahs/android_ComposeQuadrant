package com.axiagroups.composequadrant.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axiagroups.composequadrant.R
import java.text.NumberFormat


/**
 * Created by Ahsan Habib on 6/3/2024.
 */

@Composable
fun TipTimeApp(
    modifier: Modifier = Modifier,
) {
    var amountInput by remember {
        mutableStateOf("")
    }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)


    Scaffold(
        modifier = modifier
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 40.dp)
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.calculate_tip),
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
            )
            EditNumberField(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth(),
                value = amountInput,
                onValueChange = { amountInput = it }
            )
            Text(
                text = stringResource(R.string.tip_amount, tip),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun EditNumberField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Bill Amount") },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Number),
        singleLine = true,
    )
}

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    MaterialTheme {
        TipTimeApp()
    }
}
