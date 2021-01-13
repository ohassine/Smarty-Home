package com.oussama.smartyhome.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oussama.smartyhome.domain.usecases.getRooms
import com.oussama.smartyhome.domain.usecases.getUserName
import com.oussama.smartyhome.entities.Room
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    var rooms: MutableLiveData<List<Room>> = MutableLiveData()
    var username: MutableLiveData<String> = MutableLiveData()
    var disposable = CompositeDisposable()

    fun getAllRooms() {
        disposable.add(
            getRooms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    rooms.value = it
                }, {})
        )
    }

    fun getCurrentUserName() {
        disposable.add(
            getUserName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    username.value = it
                }, {})
        )
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}