package com.br.managementtasks.taskview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.managementtasks.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskManagementActivity : AppCompatActivity() {

    private lateinit var taskListView: ListView
    private lateinit var taskAdapter: TaskAdapter
    private var taskList = mutableListOf<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_management)

        taskListView = findViewById(R.id.taskListView)
        val addTaskButton = findViewById<Button>(R.id.btnAddTask)

        taskAdapter = TaskAdapter(this, taskList)
        taskListView.adapter = taskAdapter

        carregarTarefas()


        addTaskButton.setOnClickListener {
        }
    }

    private fun carregarTarefas() {
        val tarefaApi = RetrofitClient.getTarefaApi()
        tarefaApi.listarTarefas().enqueue(object : Callback<List<Tarefa>> {
            override fun onResponse(call: Call<List<Tarefa>>, response: Response<List<Tarefa>>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("API sucesso", "Resposta da API: " + response.body().toString())
                    taskList.clear()
                    taskList.addAll(response.body()!!)
                    taskAdapter.notifyDataSetChanged()
                } else {
                    Log.e("API erro", "Código de erro: ${response.code()} - ${response.message()}")
                    Toast.makeText(
                        this@TaskManagementActivity,
                        "Erro ao carregar tarefas",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


            override fun onFailure(call: Call<List<Tarefa>>, t: Throwable) {
                Log.d("API falha", t.cause.toString() + t.message.toString());
                Log.e("API_ERROR", "Erro ao carregar tarefas", t)
                Toast.makeText(
                    this@TaskManagementActivity,
                    "Erro ao conectar-se à API",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}