package com.oussama.smartyhome.domain.gateways

import android.content.Context
import com.oussama.smartyhome.domain.DomainIntegration
import io.reactivex.Single

val preferencesGateway by lazy { PreferencesGateway() }

const val PREFERENCES_NAME = "PREFERENCES_NAME"

class PreferencesGateway {

    fun save(key: String, value: String): Single<String> {
        return Single.fromCallable {
            DomainIntegration.getApplication()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(key, value)
                .apply()
            value
        }
    }

    fun isSaved(key: String): Single<Boolean> {
        return Single.fromCallable {
            DomainIntegration.getApplication()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
                .contains(key)
        }
    }

    fun loadString(key: String, defaultValue: String): Single<String> {
        return Single.fromCallable {
            DomainIntegration.getApplication()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
                .getString(key, defaultValue)
        }
    }

}
