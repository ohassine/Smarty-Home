package com.oussama.smartyhome.domain.repositories

import com.oussama.smartyhome.domain.gateways.JsonGateway
import com.oussama.smartyhome.domain.gateways.jsonGateway
import com.oussama.smartyhome.entities.Room
import io.reactivex.Single

val roomRepository: RoomRepository by lazy {
    RoomRepositoryImpl()
}

interface RoomRepository {
    fun getAllRooms(): Single<List<Room>>
}

class RoomRepositoryImpl(
    private val roomsDataSource: JsonGateway = jsonGateway
) : RoomRepository {
    override fun getAllRooms(): Single<List<Room>> =
        roomsDataSource.getRooms()
}