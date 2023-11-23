package com.example.to_do_list

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    var isCompleted: Boolean = false,
)

interface TaskDataSource {
    fun getTasks(): List<Task>

    fun setTasks(list: List<Task>)
    fun addTask(task: Task)
    fun deleteTask(task: Task)

    fun getTasksSize(): Int
}