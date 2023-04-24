package com.example.workoutmaster.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.workoutmaster.R
import androidx.fragment.app.Fragment
import com.example.workoutmaster.ui.fragment.MapFragment
import com.example.workoutmaster.ui.fragment.PicturesFragment
import com.example.workoutmaster.ui.fragment.StatisticsFragment
import com.example.workoutmaster.ui.fragment.WorkoutsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(WorkoutsFragment())

        this.bottomNav = findViewById(R.id.bottomNav)
        this.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.workout -> {
                    loadFragment(WorkoutsFragment())
                    true
                }
                R.id.stats -> {
                    loadFragment(StatisticsFragment())
                    true
                }
                R.id.map -> {
                    loadFragment(MapFragment())
                    true
                }
                R.id.pictures -> {
                    loadFragment(PicturesFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}
