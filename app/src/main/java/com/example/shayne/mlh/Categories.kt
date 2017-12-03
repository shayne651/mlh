package com.example.shayne.mlh

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

/*4*
 * Created by Robert on 2017-12-02.
 */

class Categories : AppCompatActivity() {

    val newCatReqCode = 1
    lateinit var curClass: Class;
    lateinit var gradeArrayAdapter: GradeArrayAdapter
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        curClass = intent.extras.getSerializable("class") as Class
        println(curClass)
        listView = findViewById(R.id.Category_list) as ListView
        gradeArrayAdapter = GradeArrayAdapter(applicationContext,curClass.assignments)
        listView.adapter = gradeArrayAdapter;
    }

    fun updateGradeList() {
        gradeArrayAdapter = GradeArrayAdapter(applicationContext,curClass.assignments)
        listView.adapter = gradeArrayAdapter;
    }

    fun openNew(v:View) {
        val newCat = Intent(this, new_category::class.java)
        startActivityForResult(newCat, newCatReqCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == newCatReqCode){
            if (resultCode == Activity.RESULT_OK) {
                val name = data!!.getStringExtra("category_name")
                val weight = data!!.getFloatExtra("weight", 0f)
                addGrade(curClass,name,weight, emptyArray<Float>())
                gradeArrayAdapter.notifyDataSetChanged()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onBackPressed() {
        val int = Intent()
        int.putExtra("class", curClass)
        int.putExtra("position", intent.extras.getInt("position"))
        super.setResult(Activity.RESULT_OK, int)
        super.onBackPressed()
    }


}

