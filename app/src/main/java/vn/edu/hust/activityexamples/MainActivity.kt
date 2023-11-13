package vn.edu.hust.activityexamples

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.view.ActionMode

class MainActivity : AppCompatActivity() {

    private val items = arrayListOf<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(UserModel("1", "Mạnh Phương", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("2", "Josefina Lehner", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("3", "Stuart Vandervort II", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("4", "Maddison Russel", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("5", "Halie Morar II", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("6", "Karelle Simonis", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("7", "Hannah Welch", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("8", "Fanny Frami", "0123456789", "manhphuong1702@gmail.com" ));
        items.add(UserModel("9", "Elfrieda Wisozk", "0123456789", "manhphuong1702@gmail.com" ));


        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = UserAdapter(items)

        listView.setOnItemClickListener { parent, view, position, id ->
            // Get the clicked item's text
            val selectedItem = parent.getItemAtPosition(position) as UserModel

            // Create an Intent to start the DetailActivity
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            // Pass data to the DetailActivity
            intent.putExtra("detail_user", selectedItem)

            // Start the DetailActivity
            startActivity(intent)
        }

        registerForContextMenu(findViewById(R.id.list_view))

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.sub_menu, menu)
    }


}