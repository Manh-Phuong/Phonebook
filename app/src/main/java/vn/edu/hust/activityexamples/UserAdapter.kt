package vn.edu.hust.activityexamples

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView


class UserAdapter(val users: ArrayList<UserModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.user_item, parent, false)


        itemView.findViewById<TextView>(R.id.full_name).text = users[position].fullName
        itemView.findViewById<TextView>(R.id.text_user_name).text =
            users[position].fullName[0].toString()


        val backgroundColors = listOf("#5a99fa", "#fb8c67", "#9acd68", "#92a3ad", "#8C33FF")
        val color = Color.parseColor(backgroundColors[position % backgroundColors.size])
//        val color = Color.parseColor(backgroundColors[3])

        itemView.findViewById<CardView>(R.id.card_view_2).setCardBackgroundColor(color)


        return itemView
    }

}