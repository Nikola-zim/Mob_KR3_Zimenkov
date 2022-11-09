package com.example.kr3_zimenkov

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var visitorsList = ArrayList<Visitor>()
    private var first_name: EditText? = null
    private var last_name: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var year: EditText? = null

    companion object{
        const val VISITOR = "visitor"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first_name = findViewById<EditText>(R.id.editTextTextPersonName)
        last_name = findViewById<EditText>(R.id.editTextTextPersonName2)
        height = findViewById<EditText>(R.id.editTextNumber)
        weight = findViewById<EditText>(R.id.editTextNumber2)
        year = findViewById<EditText>(R.id.editTextDate)
        visitorsList.add(Visitor("zero", "zero",
            "zero", "zero", "zero"))

    }

    fun writeNext(view: View?) {
        if (first_name?.getText().toString().equals("") || last_name?.getText().toString().equals("") || height?.getText().toString().equals("") || weight?.getText().toString().equals("") || year?.getText().toString().equals("")){
            Toast.makeText(applicationContext, "Заполните все поля", Toast.LENGTH_SHORT).show()
        }
        else {
            //tvNumber.setText(a.toString());
            visitorsList.add(
                Visitor(
                    first_name?.getText().toString(),
                    last_name?.getText().toString(),
                    height?.getText().toString(),
                    weight?.getText().toString(),
                    year?.getText().toString()
                )
            )
            first_name?.setText("")
            last_name?.setText("")
            height?.setText("")
            weight?.setText("")
            year?.setText("")
            Toast.makeText(applicationContext, "Посетитель добавлен!", Toast.LENGTH_SHORT).show()
        }
    }

    fun finish_reg(view: View?) {
        val intent = Intent(this, ShowActivity2::class.java).apply{
            putExtra(EXTRA_MESSAGE, visitorsList)
        }
        startActivity(intent)
        }
}


