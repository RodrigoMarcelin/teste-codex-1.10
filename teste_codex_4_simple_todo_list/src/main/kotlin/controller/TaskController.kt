package org.example.controller

import org.example.model.DatabaseTaskController
import org.example.model.TaskObjectModel

object TaskController {
    fun addTask(text: String) {
        DatabaseTaskController.addTask(text)
    }

    fun deleteTask(id: Int) {
        DatabaseTaskController.deleteTask(id)
    }

    fun updateTask(id: Int, newText: String) {
        DatabaseTaskController.updateTask(id, newText)
    }

    fun getTasks(): List<TaskObjectModel> {
        return DatabaseTaskController.getAllTasks()
    }
}