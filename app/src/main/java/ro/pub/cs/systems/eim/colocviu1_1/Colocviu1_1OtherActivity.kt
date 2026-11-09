package ro.pub.cs.systems.eim.colocviu1_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Colocviu1_1OtherActivity : AppCompatActivity() {
    inner class ClickListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            when (p0!!.id) {

                R.id.buttonBack -> {
                    Toast.makeText(applicationContext, "Back", Toast.LENGTH_LONG).show()
                    toMainActivity()
                }
                R.id.buttonReg -> {
                    Toast.makeText(applicationContext, "Register", Toast.LENGTH_LONG).show()
                    toMainActivity()
                }
            }
        }
    }

    private fun toMainActivity() {
        val myIntent: Intent = Intent(this, Colocviu1_1MainActivity::class.java)
        startActivity(myIntent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_colocviu1_1_sec)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sec)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dirs = getIntent().getExtras()!!.getString("dirs")
        findViewById<EditText>(R.id.editTextDirs2)!!.setText(dirs)
        val click = ClickListener()
        findViewById<Button>(R.id.buttonBack)!!.setOnClickListener(click)
        findViewById<Button>(R.id.buttonReg)!!.setOnClickListener(click)
    }
}