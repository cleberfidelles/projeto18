package com.example.projeto18

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projeto18.databinding.ActivityResetBinding
import com.google.firebase.auth.FirebaseAuth

class Reset : AppCompatActivity() {
    private lateinit var tela : ActivityResetBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        tela = ActivityResetBinding.inflate(layoutInflater)
        setContentView(tela.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tela.btnreset.setOnClickListener {
            val email = tela.emailreset.text.toString()

            if(email.trim().isEmpty()){
                Toast.makeText(this , "Preencha o seu email", Toast.LENGTH_SHORT).show()
            }else{
                auth = FirebaseAuth.getInstance()

                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            Toast.makeText(this, "Link enviado para seu email", Toast.LENGTH_LONG).show()
                        }
                    }.addOnFailureListener{
                        Toast.makeText(this, "Erro ao resetar a senha", Toast.LENGTH_LONG).show()
                    }
            }
        }
    }
}