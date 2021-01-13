package com.oussama.smartyhome.domain.gateways

import com.google.gson.Gson
import com.oussama.smartyhome.domain.DomainIntegration
import com.oussama.smartyhome.entities.Room
import io.reactivex.Single

const val fileName = "rooms.json"

val jsonGateway: JsonGateway by lazy {
    JsonGatewayImpl()
}

interface JsonGateway {
    fun getRooms(): Single<List<Room>>
}

class JsonGatewayImpl : JsonGateway {
    override fun getRooms(): Single<List<Room>> {
        return Single.fromCallable {
            Gson().fromJson(
                getJsonDataFromAsset(DomainIntegration.getApplication(), fileName),
                Array<Room>::class.java
            ).toMutableList()
        }
    }
}

