package org.example.model

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement


object DatabaseCreate {
    private const val URL = "jdbc:sqlite:tasks.db"

    fun createTableIfNotExists() {
        val connection = connect()
        val statement: Statement = connection.createStatement()
        val sql = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                text TEXT NOT NULL
            )
        """
        statement.execute(sql)
        statement.close()
        connection.close()
    }

    private fun connect(): Connection {
        return DriverManager.getConnection(URL)
    }
}