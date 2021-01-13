package com.oussama.smartyhome.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oussama.smartyhome.R

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var roomName: TextView = itemView.findViewById(R.id.textViewRoomName)
    var roomDeviceNumber: TextView = itemView.findViewById(R.id.textViewDevice)
    var roomImage: ImageView = itemView.findViewById(R.id.imageViewRoomImage)
}