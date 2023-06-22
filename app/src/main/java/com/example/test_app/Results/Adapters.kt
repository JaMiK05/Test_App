package com.example.test_app.Results

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.Repository.Question
import com.example.test_app.R

class Adapters(
    private val test: List<Question>,
    private val javob: List<String>,
) : Adapter<Adapters.Holder>() {


    private lateinit var click: (Int) -> Unit

    fun setclick(cl: (Int) -> Unit) {
        click = cl
    }

    class Holder(view: View) : ViewHolder(view) {
        var savol: TextView = view.findViewById(R.id.item_savol)
        var javob: TextView = view.findViewById(R.id.item_javob)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (test[position].answer == javob[position]) {
            holder.itemView.setBackgroundResource(R.drawable.item_tr)
        } else {
            if (javob[position].isEmpty()) {
                holder.itemView.setBackgroundResource(R.drawable.item_sk)
            } else {
                holder.itemView.setBackgroundResource(R.drawable.item_fl)
            }
        }
        holder.itemView.setOnClickListener {
            click.invoke(position)
        }
        holder.savol.text = test[position].question
        holder.javob.text = javob[position]
    }

    override fun getItemCount(): Int = test.size
}