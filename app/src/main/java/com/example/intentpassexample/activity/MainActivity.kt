package com.example.intentpassexample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intentpassexample.R
import com.example.intentpassexample.model.Member
import com.example.intentpassexample.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var tvMainInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        val btnSend: Button = findViewById(R.id.btn_open_secondActivity)
        tvMainInfo = findViewById(R.id.tv_main_info)

        btnSend.setOnClickListener {
            sendResultMemberUseIntentAndParcelable()
        }

    }


    private fun sendResultMemberUseIntentAndParcelable() {
        val member = Member("Send Parcelable", "15 letters")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("member", member)
        launcher2.launch(intent)
    }

    val launcher2: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> {
            if (it.resultCode == 10) {
                val member = it.data!!.getParcelableExtra<Member>("memberResult")
                tvMainInfo.text = "${member!!.firstName}: ${member!!.lastName}"
            }
        }
    )



    private fun sendResultUserUseIntentAndSerializable() {
        val user = User("Send Serializable", 17)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        launcher1.launch(intent)
    }

    val launcher1: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> {
            if (it.resultCode == 12) {
                val user = it.data!!.getSerializableExtra("userResult") as User
                tvMainInfo.text = "${user.name}: ${user.age} letters"
            }
        }
    )



    private fun sendMemberUseIntentAndParcelable() {
        val member = Member("Abbos", "Mardiyev")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("member", member)
        startActivity(intent)
    }



    private fun sendUserUseIntentAndSerializable() {
        val user = User("Abbos", 22)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }



    private fun sendMessageUseIntent() {
        val message: String = "send Message to Second"
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("message", message)
        startActivity(intent)
    }

}