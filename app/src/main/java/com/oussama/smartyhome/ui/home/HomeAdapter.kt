package com.oussama.smartyhome.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oussama.smartyhome.R
import com.oussama.smartyhome.entities.Room
import com.oussama.smartyhome.ui.core.getDevices
import com.oussama.smartyhome.ui.core.getResource

class HomeAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var rooms = listOf<Room>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeViewHolder).apply {
            roomName.text = rooms[position].name
            roomDeviceNumber.text = rooms[position].deviceNumber.getDevices()
            roomImage.setImageDrawable(context.getResource(rooms[position].image))
        }
    }

    override fun getItemCount(): Int = rooms.size

    fun setList(newList: List<Room>) {
        rooms = newList
        notifyDataSetChanged()
    }
}
