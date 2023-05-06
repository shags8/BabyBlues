package com.example.babyblues

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.example.babyblues.databinding.ActivityQuizBinding
import com.example.babyblues.databinding.ActivityStartQuizBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class StartQuiz : AppCompatActivity() {

    private lateinit var binding: ActivityStartQuizBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_start_quiz)
        val binding = ActivityStartQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var userid = FirebaseAuth.getInstance().currentUser?.uid.toString()
        var path = buildString {
            append("Users/")
            append(userid)
            append("/Quiz")
        }

        binding.ppd.setOnClickListener{
            val intent = Intent(this,Quiz::class.java)
            database.child(path).setValue("P")
            startActivity(intent)
            finish()
        }
        binding.ocd.setOnClickListener{
            val intent = Intent(this,OCDquiz::class.java)
            database.child(path).setValue("O")
            startActivity(intent)
            finish()
        }
        binding.Adhd.setOnClickListener{
            val intent = Intent(this,ADHDquiz::class.java)
            database.child(path).setValue("A")
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