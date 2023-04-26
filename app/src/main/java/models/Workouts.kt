package models

class Workouts(var workouts: Array<Workout>) {
    fun addWorkout(workout: Workout) {
        this.workouts = this.workouts.plus(workout)
    }

    fun deleteWorkout(id: Int) {
        this.workouts = this.workouts.filter { workout: Workout -> workout.id != id }.toTypedArray()
    }
}