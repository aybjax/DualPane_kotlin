package com.aybjax.dualpane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

const val STAR_SIGN_ID = "STAR_SIGN_ID"

interface StarSignListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), StarSignListener {
    var isDualPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("aybjax", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isDualPane = findViewById<View>(R.id.star_sign_detail) != null
    }

    override fun onSelected(id: Int) {
        if(isDualPane) {
            Log.d("aybjax", "if")
            val detailFragment = supportFragmentManager
                .findFragmentById(R.id.star_sign_detail) as DetailFragment

            detailFragment.setStarSignData(id)
        }
        else {
            val detailIntent = Intent(this,
                DetailActivity  ::class.java
            ).apply {
                putExtra(STAR_SIGN_ID, id)
            }

            startActivity(detailIntent)
        }
    }
}