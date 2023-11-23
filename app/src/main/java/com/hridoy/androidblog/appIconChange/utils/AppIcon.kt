package com.hridoy.androidblog.appIconChange.utils

import androidx.annotation.DrawableRes

data class AppIcon(
    val component: String,

    @DrawableRes
    val foregroundResource: Int,
)
