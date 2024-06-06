package com.axiagroups.composequadrant.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


/**
 * Created by Ahsan Habib on 6/6/2024.
 */
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
