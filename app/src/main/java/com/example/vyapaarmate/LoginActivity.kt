package com.example.vyapaarmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vyapaarmate.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        binding.signin.setOnClickListener{
            auth.createUserWithEmailAndPassword(binding.email.text.toString(), binding.password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        // Log.d(TAG, "createUserWithEmail:success")
                        // val user = auth.currentUser
                        Toast.makeText(this,task.result.toString(), Toast.LENGTH_LONG).show()
                        // updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        // Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        // updateUI(null)
                    }
                }
        }

    }
}