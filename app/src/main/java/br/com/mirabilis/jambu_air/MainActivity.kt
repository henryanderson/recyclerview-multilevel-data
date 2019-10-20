package br.com.mirabilis.jambu_air

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mirabilis.jambu_air.adapter.adapter_top
import br.com.mirabilis.jambu_air.model.mTOP
import com.example.recynestedgroupdate.ApiInterface
import com.example.recynestedgroupdate.ApiKlien
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface : ApiInterface = ApiKlien.ambilKlien().create(ApiInterface::class.java)
        ambilJSON(apiInterface)

    }


    fun ambilJSON(apiInterface: ApiInterface) {

        val call : Call<ArrayList<mTOP>> = apiInterface.getBuah()

        call.enqueue(object : Callback<ArrayList<mTOP>> {

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call<ArrayList<mTOP>>?, response: Response<ArrayList<mTOP>>?) {

                Log.d("hasil", "hasil ${response!!.body()}")

                val rv = findViewById<RecyclerView>(R.id.RvMain)
                rv.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)
                //val adapter = response!!.body()?.let { adapter_top(it) }
                val adapter =  adapter_top(response!!.body() as ArrayList<mTOP>)
                rv.adapter = adapter

            }

            override fun onFailure(call: Call<ArrayList<mTOP>>?, t: Throwable?) {
                Log.d("hasil fail ", "hasil " + t)
            }

        })
    }


}
