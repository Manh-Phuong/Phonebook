package vn.edu.hust.activityexamples

import android.graphics.Color
import vn.edu.hust.activityexamples.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Copy the content of onCreate method from the original Activity
        val args = arguments
//        val user = args?.getParcelable<UserModel>("detail_user")
//        println(user)

        if (args != null) {
            val user = args?.getParcelable<UserModel>("detail_user")
            if (user != null) {
                // Rest of the code...
                // ...
                val id = view.findViewById<TextView>(R.id.id_user)
                val name = view.findViewById<TextView>(R.id.name)
                val phone = view.findViewById<TextView>(R.id.phone)
                val email = view.findViewById<TextView>(R.id.email)
                view.findViewById<TextView>(R.id.text_user_name).text = user.fullName[0].toString()

                val backgroundColors = listOf("#5a99fa", "#fb8c67", "#9acd68", "#92a3ad", "#8C33FF")
                val color = user?.idUser?.toInt()?.let { Color.parseColor(backgroundColors[(it-1) % backgroundColors.size]) }

                val colorValue = color ?: Color.TRANSPARENT
                view.findViewById<CardView>(R.id.card_view_2).setCardBackgroundColor(colorValue)

                id.text = "ID: ${user?.idUser.toString()}"
                name.text = "Họ và tên: ${user?.fullName.toString()}"
                phone.text = "SĐT: ${user?.numberPhone.toString()}"
                email.text = "Email: ${user?.email.toString()}"
            }
        }
    }
}