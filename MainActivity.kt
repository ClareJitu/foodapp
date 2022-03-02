package com.example.foodapp

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import layout.Food

class MainActivity : AppCompatActivity() {
    private var adapter: FoodAdapter? = null
    private var foodlist = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        foodlist.add(Food("Burger", "Burger is a delicious meal made of veggies, meat and cheese", "R.drawable.burger"))
        foodlist.add(Food("Chicken", "Chicken nugget deeply fried in the goodness of honey, natural spices and bread crumbs", "R.drawable.chicken"))

        adapter = FoodAdapter(this, foodlist)
        GridView.adapter = adapter
    }
    class FoodAdapter(private var context: Context?, private var foodlist: ArrayList<Food>) :
        BaseAdapter() {


        override fun getCount(): Int {
            return foodlist.size
        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
            val food: Food = this.foodlist[index]
            val inflater= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodview = inflater.inflate(R.layout.mylayout, null)
            foodview.imageView.setImageResource(food.image!!)
            foodview.textView.setText(food.name!!)
            return foodview
        }
    }
}
