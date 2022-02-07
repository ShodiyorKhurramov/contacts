package com.example.contacts

import android.Manifest

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.adapter.Adapter
import com.example.contacts.model.Item
import android.provider.ContactsContract




class MainActivity : AppCompatActivity() {



    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         initView()

    }

    private fun initView() {

        recyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        checkPermission()


        refreshAdapter(kontactList())

    }

    fun refreshAdapter(items: ArrayList<Item>) {
        val adapter = Adapter(this, items)
        recyclerView.adapter = adapter
    }
    fun kontactList():ArrayList<Item>{
        val items= ArrayList<Item>()
        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null)!!

        cursor.moveToFirst()

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))

            if(name[0].toInt()<64||name[0].toInt()>90||name[0].toInt()<97||name[0].toInt()>122){
                items.add(Item(name))
            }

        }

        return items
    }


    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_CONTACTS),
                909
            )
        }
    }


}
