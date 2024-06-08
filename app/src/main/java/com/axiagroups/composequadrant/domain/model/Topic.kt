package com.axiagroups.composequadrant.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


/**
 * Created by Ahsan Habib on 6/8/2024.
 */
data class Topic(
    @StringRes val nameResId: Int,
    val numberOfCourse: Int,
    @DrawableRes val imageResId: Int
)
