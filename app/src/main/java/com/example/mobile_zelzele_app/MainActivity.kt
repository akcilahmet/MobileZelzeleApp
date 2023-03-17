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

        //recycleView setup
        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)

        //recycleview item offset
        val itemDecoration = ItemOffsetDecoration(40)
        newRecyclerView.addItemDecoration(itemDecoration)


        verileriAl()



    }



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