package ro.pub.cs.systems.eim.colocviu1_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Colocviu1_1MainActivity : AppCompatActivity() {
    private var editTextDirs: EditText? = null


    inner class ClickListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            when (p0!!.id) {

                R.id.buttonE -> addDirText("East")
                R.id.buttonN -> addDirText("North")
                R.id.buttonW -> addDirText("West")
                R.id.buttonS -> addDirText("South")
                R.id.buttonAct -> launchActivity()
            }
        }
    }

    private fun addDirText(s: String) {
        if (editTextDirs!!.getText().toString() == "") {
            editTextDirs!!.setText(s)
        } else {
            editTextDirs!!.setText(editTextDirs!!.getText().toString() + ", " + s)
        }
    }

    private fun launchActivity() {
        val myIntent: Intent = Intent(this, Colocviu1_1OtherActivity::class.java)
        myIntent.putExtra("dirs", editTextDirs!!.getText().toString())
        startActivity(myIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_colocviu1_1_main)
        editTextDirs = findViewById<EditText>(R.id.editTextDirs)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var click = ClickListener()
        findViewById<Button>(R.id.buttonN)!!.setOnClickListener(click)
        findViewById<Button>(R.id.buttonW)!!.setOnClickListener(click)
        findViewById<Button>(R.id.buttonE)!!.setOnClickListener(click)
        findViewById<Button>(R.id.buttonS)!!.setOnClickListener(click)

        findViewById<Button>(R.id.buttonAct)!!.setOnClickListener(click)

    }
}