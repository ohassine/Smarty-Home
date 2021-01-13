package com.oussama.smartyhome.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.oussama.smartyhome.R
import com.oussama.smartyhome.domain.usecases.isUserSaved
import com.oussama.smartyhome.domain.usecases.saveUsername
import com.oussama.smartyhome.ui.home.HomeFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainFragment : Fragment(R.layout.fragment_main) {

    private val disposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val continueButton = view.findViewById<Button>(R.id.buttonMainContinue)
        val nameTextView = view.findViewById<TextView>(R.id.textInputEditTextMainName)

        continueButton?.setOnClickListener {
            if (nameTextView.text.isEmpty()) {
                nameTextView.error = getString(R.string.txt_enter_your_name)
                nameTextView.requestFocus()
            } else {
                disposable.add(
                    saveUsername(nameTextView.text.toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Log.d("MainActivity", "saveUsername: $it")
                            goToHome()
                        }, {
                            Log.d("MainActivity", "error: $it")
                        })
                )
            }

        }

    }

    private fun goToHome() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, HomeFragment())
            ?.commit()
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}