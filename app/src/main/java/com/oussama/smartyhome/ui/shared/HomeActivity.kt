package com.oussama.smartyhome.ui.shared

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oussama.smartyhome.R
import com.oussama.smartyhome.domain.usecases.isUserSaved
import com.oussama.smartyhome.ui.home.HomeFragment
import com.oussama.smartyhome.ui.main.MainFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class HomeActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        disposable.add(
            isUserSaved()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if (it) {
                        supportFragmentManager.takeIf { savedInstanceState == null }
                            ?.beginTransaction()
                            ?.add(R.id.container, HomeFragment())
                            ?.commit()
                    } else {
                        supportFragmentManager.takeIf { savedInstanceState == null }
                            ?.beginTransaction()
                            ?.add(R.id.container, MainFragment())
                            ?.commit()
                    }
                }, {})
        )


    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}