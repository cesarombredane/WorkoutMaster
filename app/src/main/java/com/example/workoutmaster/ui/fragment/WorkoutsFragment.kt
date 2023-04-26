package com.example.workoutmaster.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.workoutmaster.R
import models.Workouts
import utils.DatabaseHelper
import utils.WorkoutItemAdapter


class WorkoutsFragment : Fragment() {
    private lateinit var workouts: Workouts

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_workouts, container, false)

        this.workouts = DatabaseHelper.getWorkouts()

        val listView: ListView = view.findViewById(R.id.list_view_workouts)
        val adapter = WorkoutItemAdapter(requireContext(), this.workouts.workouts)
        listView.adapter = adapter

        return view
    }
}