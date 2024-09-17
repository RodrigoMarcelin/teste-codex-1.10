package org.example.model

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

object DatabaseTaskController {
    private const val URL = "jdbc:sqlite:tasks.db"

    init {
        DatabaseCreate.createTableIfNotExists()
    }

    private fun connect(): Connection {
        return DriverManager.getConnection(URL)
    }



    fun addTask(text: String) {
        val connection = connect()
        val sql = "INSERT INTO tasks (text) VALUES (?)"
        val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, text)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }

    fun deleteTask(id: Int) {
        val connection = connect()
        val sql = "DELETE FROM tasks WHERE id = ?"
        val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
        preparedStatement.setInt(1, id)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }

    fun updateTask(id: Int, newText: String) {
        val connection = connect()
        val sql = "UPDATE tasks SET text = ? WHERE id = ?"
        val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, newText)
        preparedStatement.setInt(2, id)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }

    fun getAllTasks(): List<TaskObjectModel> {
        val taskObjectModels = mutableListOf<TaskObjectModel>()
        val connection = connect()
        val sql = "SELECT * FROM tasks"
        val resultSet: ResultSet = connection.createStatement().executeQuery(sql)
        while (resultSet.next()) {
            taskObjectModels.add(TaskObjectModel(resultSet.getInt("id"), resultSet.getString("text")))
        }
        resultSet.close()
        connection.close()
        return taskObjectModels
    }
}