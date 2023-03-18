package com.example.mobile_zelzele_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_zelzele_app.service.DepremAPIService
import com.example.mobile_zelzele_app.service.DepremApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.core.content.ContextCompat
import android.animation.ValueAnimator
import android.animation.ArgbEvaluator

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi:DepremApi
    internal lateinit var newRecyclerView:RecyclerView
    internal lateinit var swipeRefreshLayout: SwipeRefreshLayout
    internal  lateinit var adapter: RecycleAdapter

    private val disposable=CompositeDisposable()

    private var mHandler = Handler(Looper.getMainLooper())
    private var mUpdateInterval: Long = 70 * 1000



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //refrehBtnClicked
        val button = findViewById<Button>(R.id.refreshBtn)
        refreshBtnClicked(button)

        //swipeRefresh
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        setRefreshLayout(swipeRefreshLayout)

        //recycleView setup
        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)

        //recycleview item offset
        val itemDecoration = ItemOffsetDecoration(40)
        newRecyclerView.addItemDecoration(itemDecoration)

        getEarthquakeStartRepeatingTask()



    }

    private fun recycleViewShowData(posts:List<News>?){

        val adapter=RecycleAdapter(this,posts!!)
        adapter.updateData(posts!!)
        newRecyclerView.adapter=adapter;

    }

    private fun getEarthquakeStartRepeatingTask() {
        earthquakeStatusUpdate.run()
    }

    private val earthquakeStatusUpdate = object : Runnable {
        override fun run() {
            try {
                // error
            } finally {
                mHandler.postDelayed(this, mUpdateInterval)
                disposable.add(
                    DepremAPIService.getEarthquake()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object :DisposableSingleObserver<List<News>>(){
                            override fun onSuccess(t: List<News>) {
                                recycleViewShowData(t)
                            }

                            override fun onError(e: Throwable) {
                                e.printStackTrace()
                            }

                        })
                )
            }
        }
    }

    private fun refreshBtnClickedEarthquakeStatusUpdate(){
        disposable.add(
            DepremAPIService.getEarthquake()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<News>>(){
                    override fun onSuccess(t: List<News>) {

                        recycleViewShowData(t)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )

    }

    private fun refreshBtnClicked(button: Button){

        button.setOnClickListener {
            refreshBtnClickedEarthquakeStatusUpdate()
            setBtnClickedColorChanged(button)



        }
    }

    private fun setBtnClickedColorChanged(button: Button){
        val colorFrom = ContextCompat.getColor(this, R.color.colorPrimary)
        val colorTo = ContextCompat.getColor(this, R.color.colorAccent)

        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)

        colorAnimation.duration = 500

        colorAnimation.addUpdateListener {
            button.setBackgroundColor(it.animatedValue as Int)
        }

        colorAnimation.start()

        Handler().postDelayed({
            val colorBack = ContextCompat.getColor(this, R.color.colorPrimary)
            val colorReturn = ContextCompat.getColor(this, R.color.colorAccent)

            val colorBackAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorReturn, colorBack)

            colorBackAnimation.duration = 500

            colorBackAnimation.addUpdateListener {
                button.setBackgroundColor(it.animatedValue as Int)
            }

            colorBackAnimation.start()
        }, 1000)

    }

    private fun setRefreshLayout(swipeRefreshLayout: SwipeRefreshLayout){
        swipeRefreshLayout.setOnRefreshListener {
            refreshBtnClickedEarthquakeStatusUpdate()

            swipeRefreshLayout.isRefreshing=false

        }
    }
}