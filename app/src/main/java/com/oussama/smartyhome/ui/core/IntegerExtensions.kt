package com.oussama.smartyhome.ui.core

fun Int.getDevices() : String{
    return if (this <= 1)
        "1 device"
    else "$this devices"
}