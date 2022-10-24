package com.course.dinnerdecider

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private var foodList = arrayListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDecide.setOnClickListener {
            tvSelectedFood.text = getRandomFood();
        }

        btnAddFood.setOnClickListener {
            if(edAddFood.text.isEmpty())
            {
                Toast.makeText(this, "Please enter food name", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }

            if(ifExist(edAddFood.text.toString()))
            {
                Toast.makeText(this,"${edAddFood.text} already exists" , Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }
            foodList.add(edAddFood.text.toString())
            edAddFood.text.clear();
        }
    }

    private fun ifExist(food: String): Boolean {
       return foodList.stream().anyMatch { s -> s.equals(food,true) }
    }

    private fun getRandomFood(): String {
        val index = Random().nextInt(foodList.size)
        return foodList.get(index);
    }
}