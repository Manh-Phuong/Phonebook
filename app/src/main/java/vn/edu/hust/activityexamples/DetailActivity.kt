package vn.edu.hust.activityexamples

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

        id.text = "ID: ${user?.idUser.toString()}"
        name.text = "Họ và tên: ${user?.fullName.toString()}"
        phone.text = "SĐT: ${user?.numberPhone.toString()}"
        email.text = "Email: ${user?.email.toString()}"

    }
}