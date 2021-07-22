package com.demirli.a5causeeffectexample.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.demirli.a5causeeffectexample.R
import com.demirli.a5causeeffectexample.ui.detail.DetailActivity
import com.demirli.a5causeeffectexample.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PeopleAdapter.OnPeopleClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        people_names_rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getAllPeople.observe(this, Observer {

            adapter = PeopleAdapter(this, it)
            people_names_rv.adapter = adapter
            adapter.setOnPeopleClickListener(this)

        })
    }

    override fun onPeopleClick(peopleId: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Constants.PEOPLE_EXTRA,peopleId)
        startActivity(intent)
    }
}
