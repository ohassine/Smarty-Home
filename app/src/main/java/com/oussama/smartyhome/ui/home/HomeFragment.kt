package com.oussama.smartyhome.ui.home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oussama.smartyhome.R
import com.oussama.smartyhome.ui.core.getCurrentDateTime
import com.oussama.smartyhome.ui.core.toString


const val dateFormat = "MMM d, yyyy"

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateTextView = view.findViewById<TextView>(R.id.textViewHomeDate)
        val welcomeUsernameTextView = view.findViewById<TextView>(R.id.textViewHomeName)
        recyclerView = view.findViewById(R.id.recyclerViewRooms)

        homeViewModel.getAllRooms()
        homeViewModel.getCurrentUserName()

        dateTextView.text = getCurrentDateTime().toString(dateFormat)

        initAdapter()

        homeViewModel.rooms.observe(viewLifecycleOwner, {
            adapter.setList(it)
        })

        homeViewModel.username.observe(viewLifecycleOwner, {
            welcomeUsernameTextView.text = getString(R.string.welcome_message, it)
        })
    }

    private fun initAdapter() {
        context?.let {
            adapter = HomeAdapter(it)
            recyclerView.layoutManager = LinearLayoutManager(it)
            recyclerView.adapter = adapter
        }

    }
}