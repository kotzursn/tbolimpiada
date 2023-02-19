package com.example.myapplication

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.junit.Assert.*
import org.junit.Test


class UnitTest{
/*
    @Test
    fun json2Text(){
        val jsonUrl = "https://mobile-olympiad-trajectory.hb.bizmrg.com/semi-final-data.json"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            jsonUrl, // url
            null, // json request
            { response -> // response listener
                try {
                    val res: JSONObject = response
                    val arr: JSONArray = res.getJSONArray("items")

                    var name0 = arr.getJSONObject(0).getString("name")
                    assertEquals("ВКонтакте", name0)

                } catch (e: JSONException) {
                    Log.e("JSONException", e.message.toString())
                }
            },
            { error -> // error listener
                Log.e("error response", "error listener")
            }
        )
        //val queue = Volley.newRequestQueue(InstrumentationRegistry.getInstrumentation().targetContext)
        val queue = Volley.newRequestQueue(context)

        // +запрос в очередь
        queue.add(jsonObjectRequest)
    }
*/
}