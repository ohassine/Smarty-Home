package com.oussama.smartyhome.domain.usecases

import com.oussama.smartyhome.domain.repositories.RoomRepository
import com.oussama.smartyhome.domain.repositories.roomRepository
import com.oussama.smartyhome.entities.Room
import io.reactivex.Single

fun getRooms(
    repository: RoomRepository = roomRepository
): Single<List<Room>> =
    repository.getAllRooms()
