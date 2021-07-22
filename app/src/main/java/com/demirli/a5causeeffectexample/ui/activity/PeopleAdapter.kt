package com.demirli.a5causeeffectexample.ui.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demirli.a5causeeffectexample.R
import com.demirli.a5causeeffectexample.model.People

class PeopleAdapter(var context: Context, var peopleList: List<People>): RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    private lateinit var onPeopleClickListener: OnPeopleClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.people_item, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = peopleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.peopleName.text = peopleList[position].name + " " + peopleList[position].surname

        holder.itemView.setOnClickListener {
            onPeopleClickListener.let {
                it.onPeopleClick(peopleList[position].pid)
            }
        }
    }

    fun setOnPeopleClickListener(onPeopleClickListener: OnPeopleClickListener){
        this.onPeopleClickListener = onPeopleClickListener
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val peopleName = view.findViewById<TextView>(R.id.name_and_surname_tv)
    }

    interface OnPeopleClickListener{
        fun onPeopleClick(peopleId: Int)
    }
}