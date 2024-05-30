package com.example.projeto18

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projeto18.databinding.ActivityTelaHomeBinding
import com.google.firebase.auth.FirebaseAuth

class TelaHome : AppCompatActivity() {
    private lateinit var tela : ActivityTelaHomeBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        tela = ActivityTelaHomeBinding.inflate(layoutInflater)
        setContentView(tela.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tela.signout.setOnClickListener {
            auth = FirebaseAuth.getInstance()

            auth.signOut()
            telaMain()

        }
    }
    private fun telaMain(){
        val telaMain = Intent(this , MainActivity::class.java)
        startActivity(telaMain)
        finish()
    }
}