package utils

import models.Exercise
import models.Workout
import models.Workouts
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet


class DatabaseHelper {
    companion object {
        private val database_connexion: Connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/workoutmaster", "", "")

        fun getWorkouts(): Workouts {
            val workouts = Workouts(emptyArray())

            try {
                val requestGetWorkouts = "SELECT * FROM workout"
                val resultWorkouts: ResultSet = database_connexion.prepareStatement(requestGetWorkouts).executeQuery()
                while (resultWorkouts.next()) {
                    val idWorkout = resultWorkouts.getInt("id")
                    val nameWorkout = resultWorkouts.getString("name")

                    val workout = Workout(idWorkout, nameWorkout, emptyArray())

                    val requestGetExercise = "SELECT * FROM exercise WHERE workout = $idWorkout"
                    val resultExercise: ResultSet = database_connexion.prepareStatement(requestGetExercise).executeQuery()
                    while (resultExercise.next()) {
                        val idExercise = resultWorkouts.getInt("id")
                        val nameExercise = resultWorkouts.getString("name")
                        val nbRepExercise = resultWorkouts.getInt("nb_rep")
                        val nbSeriesExercise = resultWorkouts.getInt("nb_series")

                        val exercise = Exercise(idExercise, nameExercise, nbRepExercise, nbSeriesExercise)
                        workout.addExercise(exercise)
                    }

                    workouts.addWorkout(workout)
                }
            } catch (e: Exception) { e.printStackTrace() }

            return workouts
        }
    }
}