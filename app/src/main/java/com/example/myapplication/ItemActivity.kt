package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spanned
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val name = intent.getStringExtra("name")
        tvName.text = name
        val actionbar = supportActionBar
        actionbar?.title = name
        actionbar?.setDisplayHomeAsUpEnabled(true)

        tvDes.text = intent.getStringExtra("description")
        var icon_url = intent.getStringExtra("icon_url")

        var url = intent.getStringExtra("service_url")
        url = "<u>$url</u>"
        var textSpan: Spanned = android.text.Html.fromHtml(url)
        tvUrl.text = textSpan
        tvUrl.setOnClickListener(){
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(tvUrl.text.toString()))
            startActivity(browserIntent)
        }

        Picasso.get()
            .load(icon_url)
            .placeholder(R.drawable.icon_placeholder)
            .error(R.drawable.icon_error) //
            .into(imageLogo)
    }
}