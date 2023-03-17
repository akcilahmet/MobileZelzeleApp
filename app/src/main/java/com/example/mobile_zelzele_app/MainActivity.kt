package com.example.mobile_zelzele_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_zelzele_app.service.DepremAPIService
import com.example.mobile_zelzele_app.service.DepremApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {


    internal lateinit var jsonApi:DepremApi
    internal lateinit var newRecyclerView:RecyclerView

    private val disposable=CompositeDisposable()// kullan at her bir istek disposable olacak(devamlı acık kalması hafıza yönetimi acısından sıkıntılı)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit=DepremAPIService.instance
        jsonApi=retrofit.create(DepremApi::class.java)


        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)




        verileriAl()
        //getUserData()
       /* val newsList = listOf(
            News("Başlık 1", "İçerik 1","test","test2","test3","test4"),
            News("Başlık 1", "İçerik 1","test","test2","test3","test4"),
            News("Başlık 1", "İçerik 1","test","test2","test3","test4")

        )
        println("Liste eleman sayısıtest: ")
        newsZelzele.value = newsList*/





    }

    /*private fun getUserData() {
        val news=News(cityName,districtName,magnitude,depth,time,passingTime)

        val newsList=MutableLiveData<News>()
        newRecyclerView.adapter=RecycleAdapter(newsList.value!!)
    }*/

    private fun verileriAl(){
        disposable.add(
            jsonApi.posts
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{posts->displayData(posts)}
        )



    }

    private fun displayData(posts:List<News>?){
        val adapter=RecycleAdapter(this,posts!!)


        newRecyclerView.adapter=adapter;
    }
}