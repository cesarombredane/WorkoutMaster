package utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.workoutmaster.R
import models.Workout


class WorkoutItemAdapter(private val context: Context, private val items: Array<Workout>) : BaseAdapter() {
    private lateinit var name: TextView

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Workout {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val newConvertView = LayoutInflater.from(context).inflate(R.layout.fragment_item_workout, parent, false)

        name = newConvertView.findViewById(R.id.textview_workout)
        name.text = items[position].name

        return newConvertView
    }
}
