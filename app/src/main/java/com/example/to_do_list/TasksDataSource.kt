package com.example.to_do_list

class InMemoryTaskDataSource : TaskDataSource {
    private val tasks = mutableListOf<Task>()

    override fun getTasks(): List<Task> {
        return this.tasks.toList()
    }

    override fun setTasks(list: List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(list)
    }

    override fun addTask(task: Task) {
        this.tasks.add(task)
    }

    override fun deleteTask(task: Task) {
        this.tasks.remove(task)
    }

    override fun getTasksSize(): Int {
        return tasks.size
    }
}