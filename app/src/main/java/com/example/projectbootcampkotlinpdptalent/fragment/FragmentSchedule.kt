package com.example.projectbootcampkotlinpdptalent.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectbootcampkotlinpdptalent.R
import com.example.projectbootcampkotlinpdptalent.adapter.UserScheduleAdapter
import com.example.projectbootcampkotlinpdptalent.model.UserSchedule
import com.example.projectbootcampkotlinpdptalent.services.NetworkConfig
import com.example.projectbootcampkotlinpdptalent.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class FragmentSchedule : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_fragment_schedule, container, false)

        recyclerView = view.findViewById(R.id.lstSchedule)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            fetchSchedules()
        }

        fetchSchedules()

        return view
    }

    private fun fetchSchedules() {
        swipeRefreshLayout.isRefreshing = true
        val userScheduleService = NetworkConfig.getRetrofit().create(UserService::class.java)

        userScheduleService.getUserSchedules(20).enqueue(object : Callback<List<UserSchedule>> {
            override fun onResponse(call: Call<List<UserSchedule>>, response: Response<List<UserSchedule>>) {
                swipeRefreshLayout.isRefreshing = false
                if (response.isSuccessful) {
                    val schedules = response.body() ?: emptyList()
                    recyclerView.adapter = UserScheduleAdapter(schedules)
                } else {
                    Log.e("API_ERROR", "Response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<UserSchedule>>, t: Throwable) {
                swipeRefreshLayout.isRefreshing = false
                Log.e("API_ERROR", "Error: ${t.message}")
            }
        })
    }
}
