package com.oussama.smartyhome.domain.usecases

import com.oussama.smartyhome.domain.repositories.UserRepository
import com.oussama.smartyhome.domain.repositories.userRepository
import io.reactivex.Single

fun saveUsername(username: String, repository: UserRepository = userRepository) =
    repository.saveUserName(username)

fun isUserSaved(repository: UserRepository = userRepository) : Single<Boolean> =
    repository.isUserSaved()

fun getUserName(repository: UserRepository = userRepository) : Single<String> =
    repository.getUserName()
