package com.axiagroups.composequadrant.domain.model

import com.axiagroups.composequadrant.R


/**
 * Created by Ahsan Habib on 6/6/2024.
 */
data class Fridge(
    val modelName: String,
    val imageResId: Int,
    val year: Int,
) {
    companion object {
        val fridgeList = listOf(
            Fridge("WSD-WPM-124", R.drawable.walton_fridge_01, 2024),
            Fridge("WSD-WPM-555", R.drawable.walton_fridge_02, 2020),
            Fridge("WSD-WPM-666", R.drawable.walton_fridge_03, 2019),
        )
    }
}
