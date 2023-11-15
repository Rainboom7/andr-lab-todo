package com.example.to_do_list

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    var isCompleted: Boolean = false,
)

interface TaskDataSource {
    fun getTasks(): List<Task>
    fun addTask(task: Task)
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
}