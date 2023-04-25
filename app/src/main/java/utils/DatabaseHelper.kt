package utils

import java.sql.DriverManager

class DatabaseHelper {
    companion object {
        val database_connexion = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/workoutmaster", "", "")
    }
}