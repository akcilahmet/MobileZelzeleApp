package com.example.mobile_zelzele_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var cityName:Array<String>
    lateinit var districtName:Array<String>
    lateinit var magnitude:Array<String>
    lateinit var depth:Array<String>
    lateinit var time:Array<String>
    lateinit var passingTime:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /* var superKahramanIsimleri=ArrayList<String>()
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")
         superKahramanIsimleri.add("batman")
         superKahramanIsimleri.add("superman")
         superKahramanIsimleri.add("Iron man")

         //adapter
         val layoutManager=LinearLayoutManager(this)
         recyclerView.layoutManager=layoutManager;

         val adapter=RecycleAdapter(superKahramanIsimleri)
         recyclerView.adapter=adapter*/

        cityName= arrayOf("izmir","adana","Muş","Elazığ")
        districtName= arrayOf("bornova","merkez","merkez","merkez")
        magnitude= arrayOf("3.1","4.0","2.6","4.8")
        depth= arrayOf("9 km","16.5 km","6.2 km","7 km")
        time= arrayOf("07.00 pm","09.30 pm","12.00 pm","10.30 pm")
        passingTime= arrayOf("55 dakika önce","2 saat önce","3 saat önce","4 saat önce")

        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)

        newArrayList= arrayListOf<News>()
        getUserData()

    }

    private fun getUserData() {
        for (i in cityName.indices){
            val news=News(cityName[i],districtName[i],magnitude[i],depth[i],time[i],passingTime[i])
            newArrayList.add(news)
        }
        newRecyclerView.adapter=RecycleAdapter(newArrayList)
    }
}