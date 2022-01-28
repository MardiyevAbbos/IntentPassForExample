package com.example.intentpassexample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.intentpassexample.R
import com.example.intentpassexample.model.Member
import com.example.intentpassexample.model.User

class SecondActivity : AppCompatActivity() {

    private lateinit var tvSecondInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvSecondInfo = findViewById(R.id.tv_second_info)
        receiveResultMemberUseIntentAndParcelable()

    }


    private fun receiveResultMemberUseIntentAndParcelable() {
        val member: Member? = intent.getParcelableExtra<Member>("member")
        tvSecondInfo.text = "${member!!.firstName}: ${member!!.lastName}"
    }

    private fun sendResultParcelable(member: Member) {
        val intent = Intent()
        intent.putExtra("memberResult", member)
        setResult(10, intent)
        finish()
    }

    override fun onBackPressed() {
/*        val user = User("Result Serializable", 19)
        sendResultSerializable(user)
        // for Serializable result
 */

        val member = Member("Result Parcelable", "17 letters")
        sendResultParcelable(member)
        super.onBackPressed()
    }


    private fun receiveResultUserUseIntentAndSerializable() {
        val user: User = intent.getSerializableExtra("user") as User
        tvSecondInfo.text = "${user.name}: ${user.age} letters."
    }

    private fun sendResultSerializable(user: User) {
        val intent = Intent()
        intent.putExtra("userResult", user)
        setResult(12, intent)
        finish()
    }


    private fun receiveMemberUseIntentAndParcelable() {
        val member: Member? = intent.getParcelableExtra<Member>("member")
        tvSecondInfo.text = "${member!!.firstName} ${member!!.lastName} "
    }


    private fun receiveUserUseIntentAndSerializable() {
        val user: User = intent.getSerializableExtra("user") as User
        tvSecondInfo.text = "${user.name}: ${user.age} ages."
    }


    private fun receiveMessageUseIntent() {
        val message: String? = intent.getStringExtra("message")
        tvSecondInfo.text = message
    }

}