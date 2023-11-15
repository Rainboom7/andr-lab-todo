package com.example.to_do_list

class InMemoryTaskDataSource : TaskDataSource {
    private val tasks = mutableListOf<Task>()

    override fun getTasks(): List<Task> {
        return tasks.toList()
    }

    override fun addTask(task: Task) {
        tasks.add(task)
    }

    override fun updateTask(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            tasks[index] = task
        }
    }

    override fun deleteTask(task: Task) {
        tasks.remove(task)
    }
}