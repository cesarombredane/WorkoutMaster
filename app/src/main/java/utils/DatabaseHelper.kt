package utils

import models.Exercise
import models.Workout
import models.Workouts
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

class DatabaseHelper {
    /*
    Note :
    - replace ip by your machine ip or "10.0.2.2" if you use virtual android
    - grant all right to your root user in the database (all host)
     */
    companion object {
        private const val database_connexion_string: String = "jdbc:mysql://192.168.0.16:3306/workoutmaster"

        fun getWorkouts(): Workouts {
            val workouts = Workouts(emptyArray())

            val t = Thread {
                try {
                    val connection: Connection = DriverManager.getConnection(this.database_connexion_string, "root", "")

                    val resultWorkouts: ResultSet = connection.prepareStatement("SELECT * FROM workout").executeQuery()
                    while (resultWorkouts.next()) {
                        val idWorkout = resultWorkouts.getInt("id")
                        val nameWorkout = resultWorkouts.getString("name")
                        val workout = Workout(idWorkout, nameWorkout, emptyArray())

                        val resultExercise: ResultSet = connection.prepareStatement("SELECT * FROM exercise WHERE workout = $idWorkout").executeQuery()
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
                } catch (e: java.lang.Exception) { e.printStackTrace() }
            }

            t.start()
            t.join()

            return workouts
        }
    }
}