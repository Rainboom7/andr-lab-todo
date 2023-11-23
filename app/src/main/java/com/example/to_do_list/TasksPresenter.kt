package com.example.to_do_list

class TasksPresenter(private val view: TasksContract.View) : TasksContract.Presenter {

    private val dataSource: TaskDataSource = InMemoryTaskDataSource()
    override fun getTasks() {
        val tasks = dataSource.getTasks()
        view.showTasks(tasks)
    }

    override fun addTask(task: Task) {
        dataSource.addTask(task)
        view.updateTasks(task)
    }

    override fun deleteTask(task: Task) {
        dataSource.deleteTask(task)
        view.updateTasks(task)
    }


}