package com.example.myapplication

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.platform.app.InstrumentationRegistry
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.classes.CustomRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    var arrayList: ArrayList<HashMap<String, String>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar?.title = "Проекты VK"

        val jsonUrl = "https://mobile-olympiad-trajectory.hb.bizmrg.com/semi-final-data.json"
        json2Data(jsonUrl) //!

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun isOnline(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun json2Data(url:String){
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url, // url
            null, // json request
            { response -> // response listener
                try {
                    val res: JSONObject = response
                    val arr: JSONArray = res.getJSONArray("items")

                    arrayList = ArrayList()
                    var hMap: HashMap<String, String>
                    for (i in 0 until arr.length()) {

                        hMap = HashMap()
                        val item: JSONObject = arr.getJSONObject(i)

                        hMap["name"] = item.getString("name")
                        hMap["description"] = item.getString("description")
                        hMap["icon_url"] = item.getString("icon_url")
                        hMap["service_url"] = item.getString("service_url")

                        arrayList!!.add(hMap)

                    }

                    recyclerView?.adapter = CustomRecyclerAdapter(arrayList!!)

                } catch (e: JSONException) {
                    Log.e("JSONException", e.message.toString())
                }
            },
            { error -> // error listener
                Log.e("error response", "error listener")
                if (!isOnline()){
                    Toast.makeText(applicationContext, "Проверьте подключение к сети", Toast.LENGTH_LONG).show()
                }
            }
        )

        val queue = Volley.newRequestQueue(this)
        // +запрос в очередь
        queue.add(jsonObjectRequest)
    }

}