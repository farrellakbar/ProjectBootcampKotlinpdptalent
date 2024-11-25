package com.example.projectbootcampkotlinpdptalent

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.projectbootcampkotlinpdptalent.fragment.FragmentProfile
import com.example.projectbootcampkotlinpdptalent.fragment.FragmentSchedule

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            loadFragment(FragmentSchedule())
        }
        // Handle button clicks
        findViewById<ImageView>(R.id.btnScheduleUser).setOnClickListener {
            loadFragment(FragmentSchedule())
        }

        findViewById<ImageView>(R.id.btnProfile).setOnClickListener {
            loadFragment(FragmentProfile())
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentMain, fragment)
            .addToBackStack(null)
            .commit()
    }
}
