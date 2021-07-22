package com.demirli.a5causeeffectexample.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demirli.a5causeeffectexample.R
import com.demirli.a5causeeffectexample.ui.activity.MainActivity
import com.demirli.a5causeeffectexample.util.Constants
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var pid: Int? = null

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.extras.let {
            pid = it?.getInt(Constants.PEOPLE_EXTRA)
        }

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        viewModel.getPeople(pid).observe(this, Observer {
            if (it != null){
                detail_name_tv.text = it.name
                detail_surname_tv.text = it.surname
                detail_street_tv.text = it.street
                detail_city_tv.text = it.city
                detail_state_tv.text = it.state
                detail_country_tv.text = it.country
                detail_telephone_tv.text = it.telephone
                detail_birthday_tv.text = it.birthday
            }
        })

        detail_delete_btn.setOnClickListener {
            viewModel.deletePeople(pid)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}
