package com.example.to_do_list

import android.app.AlertDialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface TasksContract {
    interface View {
        fun showTasks(tasks: List<Task>)
        fun updateTasks(task: Task)
    }

    interface Presenter {
        fun getTasks()
        fun addTask(task: Task)
        fun deleteTask(task: Task)
    }
}

class TasksActivity : AppCompatActivity(), TasksContract.View {

    private lateinit var presenter: TasksContract.Presenter
    private lateinit var fabAddTask: FloatingActionButton
    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)
        fabAddTask = findViewById(R.id.fabAddTask)
        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)
        presenter = TasksPresenter(this)

        adapter = RecyclerViewAdapter(emptyList(),presenter::deleteTask)

        recyclerViewTasks.adapter = adapter
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)


        fabAddTask.setOnClickListener {
            showAddTaskDialog()
        }

        presenter.getTasks()
    }

    private fun showAddTaskDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_task, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Add Task")
            .setPositiveButton("Add") { _, _ ->
                val titleInput = dialogView.findViewById<EditText>(R.id.editTextTitle).text.toString()
                val descriptionInput = dialogView.findViewById<EditText>(R.id.editTextDescription).text.toString()
                if (titleInput.isNotEmpty() && descriptionInput.isNotEmpty()) {
                    val newTask = Task(System.currentTimeMillis(), titleInput, descriptionInput)
                    presenter.addTask(newTask)
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    override fun showTasks(tasks: List<Task>) {
        adapter.setTasks(tasks)
    }

    override fun updateTasks(task: Task) {
        presenter.getTasks()
    }

}