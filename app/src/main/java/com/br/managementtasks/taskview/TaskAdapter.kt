package com.br.managementtasks.taskview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.Toast
import com.example.managementtasks.R


class TaskAdapter(private val context: Context, private val tasks: MutableList<Tarefa>) : BaseAdapter() {

    override fun getCount(): Int = tasks.size
    override fun getItem(position: Int): Tarefa = tasks[position]
    override fun getItemId(position: Int): Long = tasks[position].id ?: 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_task, parent, false)
        val task = getItem(position)

        val titleTextView = view.findViewById<TextView>(R.id.taskTitle)
        titleTextView.text = task.titulo

        val descTextView = view.findViewById<TextView>(R.id.taskDescription)
        descTextView.text = task.descricao

        val descriptionTextView = view.findViewById<TextView>(R.id.taskPriority)
        descriptionTextView.text = task.prioridade

        val dueDateTextView = view.findViewById<TextView>(R.id.taskDueDate)
        dueDateTextView.text =  task.dataLimite


        val statusTextView = view.findViewById<TextView>(R.id.taskStatus)
        statusTextView.text = task.status

        val updateStatusButton = view.findViewById<Button>(R.id.updateStatusButton)

        updateStatusButton.setOnClickListener {
            val newStatus = if (task.status == "PENDENTE") "EM ANDAMENTO" else "CONCLUÍDO"
            task.status = newStatus
            statusTextView.text = newStatus

            Toast.makeText(context, "Status atualizado para $newStatus", Toast.LENGTH_SHORT).show()

        }

        return view
    }
}
