package com.example.babyblues

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class StartQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_quiz)
        val button = findViewById<ImageView>(R.id.start)
        button.setOnClickListener{
            val intent = Intent(this,Quiz::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        AlertDialog.Builder(this).setTitle("Exit")
            .setMessage("Are you sure?")
            .setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_HOME)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }).setNegativeButton("no", null).show()
    }
}