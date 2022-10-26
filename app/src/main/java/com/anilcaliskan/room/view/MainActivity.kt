package com.anilcaliskan.room.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.anilcaliskan.room.databinding.ActivityMainBinding
import com.anilcaliskan.room.model.User
import com.anilcaliskan.room.roomdb.UserDatabase

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val db = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "Users")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()



        binding.saveButton.setOnClickListener {
            if(binding.editTextName.text.isEmpty() || binding.editTextSurname.text.isEmpty()){
                Toast.makeText(this, "Name or surname is empty!", Toast.LENGTH_SHORT).show()
            }else{
                val name = binding.editTextName.text.toString()
                val surname = binding.editTextSurname.text.toString()
                val user = User(0, name, surname)
                db.userDao().insert(user)
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                "$name $surname".also { binding.resultTextView.text=it }
            }

        }

        binding.allUserButton.setOnClickListener {
            var result  = ""
            val users: ArrayList<User> = db.userDao().getAllUser() as ArrayList<User>
            users.forEach {
                result += it.userName + " " + it.userSurname + "\n"
            }
            binding.resultTextView.text = result


        }
    }


}