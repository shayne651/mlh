package com.example.shayne.mlh

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

/*4*
 * Created by Robert on 2017-12-02.
 */

class grade_edit : AppCompatActivity() {

    lateinit var save: Button
    lateinit var cancel: Button
    lateinit var grade:  Grade
    lateinit var gradeField: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade_edit)

        grade = intent.extras.getSerializable("grade") as Grade

        save = findViewById(R.id.save_button) as Button
        cancel = findViewById(R.id.cancel_button) as Button
        gradeField = findViewById(R.id.grade_val) as EditText
        gradeField.hint = grade.mark.toString()

        cancel.setOnClickListener {
            finish()
        }
        save.setOnClickListener{
            try {
                print(gradeField.text.toString())
                grade.components = arrayOf(gradeField.text.toString().toFloat())
            } catch (e: Exception) {
                e.printStackTrace()
            }
            println(grade)
            val int = Intent()
            int.putExtra("grade", grade)
            int.putExtra("position", intent.extras.getInt("position"))
            setResult(Activity.RESULT_OK,int)
            finish()
        }
    }

}

