package rita.gaieski.exemploactivityeintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // criando a var do button

    private lateinit var botaoScreen2 : Button
    private lateinit var btDiscar : Button
    private lateinit var etTelefone : EditText
    private lateinit var btNewUrl : Button
    private lateinit var etUrl : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buscarReferencias()

        botaoScreen2.setOnClickListener {
            // Criando a intent..intenções
            val intent = Intent(this@MainActivity, Screen2::class.java)
            startActivity(intent)
        }

        btDiscar.setOnClickListener {
            //intent da ligação
            var telefone = etTelefone.text.toString()
            var intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:${telefone}"))
            startActivity(intent)
        }
        btNewUrl.setOnClickListener {
            //intent da ligação
            var URL = etUrl.text.toString() // www.betrybe.com/
            var intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://${URL}"))
            startActivity(intent)
        }

    }// fecha o OnCreate()
        private fun buscarReferencias(){
            botaoScreen2 = findViewById(R.id.btScreen2)
            btDiscar = findViewById(R.id.btDiscar)
            etTelefone = findViewById(R.id.etTelefone)
            btNewUrl =  findViewById(R.id.btNewUrl)
            etUrl = findViewById(R.id.etUrl)
        }

}// fim
// segunda forma mais simples

// startActivity(Intent(this@MainActivity, Screen2::class.java))







