package org.example

import org.example.controller.TaskController

fun main() {
    while (true) {
        println("Gerenciador de Tarefas")
        println("1. Adicionar Tarefa")
        println("2. Excluir Tarefa")
        println("3. Atualizar Tarefa")
        println("4. Listar Tarefas")
        println("5. Sair")
        print("Escolha uma opção: ")

        when (readLine()) {
            "1" -> {
                print("Digite o texto da tarefa: ")
                val text = readLine() ?: ""
                if (text.isNotBlank()) {
                    TaskController.addTask(text)
                    println("Tarefa adicionada com sucesso!")
                } else {
                    println("Texto da tarefa não pode ser vazio.")
                }
            }
            "2" -> {
                print("Digite o ID da tarefa a ser excluída: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    TaskController.deleteTask(id)
                    println("Tarefa excluída com sucesso!")
                } else {
                    println("ID inválido.")
                }
            }
            "3" -> {
                print("Digite o ID da tarefa a ser atualizada: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    print("Digite o novo texto da tarefa: ")
                    val newText = readLine() ?: ""
                    if (newText.isNotBlank()) {
                        TaskController.updateTask(id, newText)
                        println("Tarefa atualizada com sucesso!")
                    } else {
                        println("Texto da tarefa não pode ser vazio.")
                    }
                } else {
                    println("ID inválido.")
                }
            }
            "4" -> {
                println("Lista de Tarefas:")
                val tasks = TaskController.getTasks()
                if (tasks.isEmpty()) {
                    println("Nenhuma tarefa encontrada.")
                } else {
                    tasks.forEach { task ->
                        println("ID: ${task.id}, Texto: ${task.text}")
                    }
                }
                println()
                println()
                println("Pressione Enter para continuar...")
                readLine()
            }
            "5" -> {
                println("Saindo...")
                return
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}