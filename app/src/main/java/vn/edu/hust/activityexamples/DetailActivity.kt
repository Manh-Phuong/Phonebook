package vn.edu.hust.activityexamples

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user = intent.getParcelableExtra<UserModel>("detail_user")
        val id = findViewById<TextView>(R.id.id_user)
        val name = findViewById<TextView>(R.id.name)
        val phone = findViewById<TextView>(R.id.phone)
        val email = findViewById<TextView>(R.id.email)
        findViewById<TextView>(R.id.text_user_name).text = user?.fullName?.get(0).toString()

        val backgroundColors = listOf("#5a99fa", "#fb8c67", "#9acd68", "#92a3ad", "#8C33FF")
        val color = user?.idUser?.toInt()?.let { Color.parseColor(backgroundColors[(it-1) % backgroundColors.size]) }

        val colorValue = color ?: Color.TRANSPARENT
        findViewById<CardView>(R.id.card_view_2).setCardBackgroundColor(colorValue)

        id.text = "ID: ${user?.idUser.toString()}"
        name.text = "Họ và tên: ${user?.fullName.toString()}"
        phone.text = "SĐT: ${user?.numberPhone.toString()}"
        email.text = "Email: ${user?.email.toString()}"

    }
}