package com.oussama.smartyhome.ui

import android.app.Application
import com.oussama.smartyhome.domain.DomainIntegration

class SmartyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DomainIntegration.with(this)
    }
}