package models

class Workout(val id: Int, var name: String, var exercises: Array<Exercise>) {
    fun addExercise(exercise: Exercise) {
        this.exercises = this.exercises.plus(exercise)
    }

    fun deleteExercise(id: Int) {
        this.exercises = this.exercises.filter { exercise: Exercise -> exercise.id != id }.toTypedArray()
    }
}