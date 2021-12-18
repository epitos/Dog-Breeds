package com.example.dogbreeds.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogbreeds.R
import com.example.dogbreeds.ui.view.fragment.BreedDetailsFragment
import com.example.dogbreeds.ui.view.fragment.BreedListFragment

class MainActivity: AppCompatActivity() {
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }

    fun loadFragment() {
        manager.beginTransaction().replace(R.id.container, BreedListFragment()).commit()
    }

    fun loadFragment(mainBreed: String) {
        manager.beginTransaction().replace(R.id.container,
            BreedDetailsFragment.newInstance(mainBreed, true)).commit()
    }

    fun loadFragment(mainBreed: String, subBreed: String) {
        manager.beginTransaction().replace(R.id.container,
            BreedDetailsFragment.newInstance(mainBreed, subBreed, false)).commit()
    }
}