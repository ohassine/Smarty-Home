package com.oussama.smartyhome.domain.repositories

import com.oussama.smartyhome.domain.gateways.PreferencesGateway
import com.oussama.smartyhome.domain.gateways.preferencesGateway
import io.reactivex.Single

private const val KEY_USERNAME = "key_username"
private const val DEFAULT_VALUE = ""

val userRepository: UserRepository by lazy {
    UserRepositoryImpl()
}

interface UserRepository {
    fun saveUserName(name: String): Single<String>
    fun isUserSaved(): Single<Boolean>
    fun getUserName() : Single<String>
}

class UserRepositoryImpl(
    private val preferences: PreferencesGateway = preferencesGateway
) : UserRepository {
    override fun saveUserName(name: String): Single<String> {
        return preferences.save(KEY_USERNAME, name)
    }

    override fun isUserSaved(): Single<Boolean> {
        return preferences.isSaved(KEY_USERNAME)
    }

    override fun getUserName(): Single<String> {
        return preferences.loadString(KEY_USERNAME,DEFAULT_VALUE)
    }
}