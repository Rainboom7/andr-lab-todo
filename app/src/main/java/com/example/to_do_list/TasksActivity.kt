package com.example.to_do_list

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

interface TasksContract {
    interface View {
        fun showTasks(tasks: List<Task>)
        fun updateTaskAdded(task: Task)
        fun updateTaskUpdated(task: Task)
        fun updateTaskDeleted(task: Task)
    }

    interface Presenter {
        fun getTasks()
        fun addTask(task: Task)
        fun updateTask(task: Task)
        fun deleteTask(task: Task)
    }
}

class TasksActivity : AppCompatActivity(), TasksContract.View {

    private lateinit var presenter: TasksContract.Presenter
    private lateinit var fabAddTask: Button
    private lateinit var textViewTasks: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)
        fabAddTask = findViewById(R.id.fabAddTask)
        textViewTasks = findViewById(R.id.textViewTasks)

        presenter = TasksPresenter(this)


        fabAddTask.setOnClickListener {
            // Simulate adding a task - replace this with your actual logic
            val newTask = Task(1, "New Task", "Description")
            presenter.addTask(newTask)
        }

        presenter.getTasks()
    }

    override fun showTasks(tasks: List<Task>) {
        // Displaying tasks directly in a TextView for simplicity
        val stringBuilder = StringBuilder()
        for (task in tasks) {
            stringBuilder.append("Task: ${task.title}\nDescription: ${task.description}\n\n")
        }
        textViewTasks.text = stringBuilder.toString()
    }

    override fun updateTaskAdded(task: Task) {
        // Show a toast or perform any UI update when a task is added
        // For simplicity, let's just refresh the task list
        presenter.getTasks()
    }

    override fun updateTaskUpdated(task: Task) {
        // Update the UI when a task is updated
        // For simplicity, let's just refresh the task list
        presenter.getTasks()
    }

    override fun updateTaskDeleted(task: Task) {
        // Update the UI when a task is deleted
        // For simplicity, let's just refresh the task list
        presenter.getTasks()
    }
}