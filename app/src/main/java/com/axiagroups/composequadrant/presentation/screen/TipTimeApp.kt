package com.axiagroups.composequadrant.presentation.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
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
    var roundUp by remember { mutableStateOf(false) }
    var tipPercentageInput by remember {
        mutableStateOf("")
    }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercentage = tipPercentageInput.toDoubleOrNull() ?: 0.0

    val tip = calculateTip(amount, tipPercentage, roundUp)


    Scaffold(
        modifier = modifier
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 40.dp)
                .safeDrawingPadding()
                .verticalScroll(rememberScrollState()),
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
                    .padding(bottom = 32.dp)
                    .fillMaxWidth(),
                label = R.string.bill_amount,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = R.drawable.ic_money,
                value = amountInput,
                onValueChange = { amountInput = it }
            )
            EditNumberField(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth(),
                label = R.string.how_was_the_service,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = R.drawable.ic_percent,
                value = tipPercentageInput,
                onValueChange = { tipPercentageInput = it }
            )
            RoundTheTipRow(
                roundUp = roundUp,
                onRoundUpChanged = { roundUp = it },
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(R.string.tip_amount, tip),
                style = MaterialTheme.typography.displaySmall
            )
//            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}

private fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean,
): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) tip = kotlin.math.ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun EditNumberField(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    leadingIcon: Int,
    value: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(id = label)) },
        modifier = modifier,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        keyboardOptions = keyboardOptions,
        singleLine = true,
    )
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))

        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged
        )

    }

}

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    MaterialTheme {
        TipTimeApp()
    }
}
