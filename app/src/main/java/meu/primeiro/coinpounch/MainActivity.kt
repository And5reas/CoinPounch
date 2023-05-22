package meu.primeiro.coinpounch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buttons
        val plDown = findViewById<Button>(R.id.plDown)
        val poDown = findViewById<Button>(R.id.poDown)
        val peDown = findViewById<Button>(R.id.peDown)
        val ppDown = findViewById<Button>(R.id.ppDown)
        val pcDown = findViewById<Button>(R.id.pcDown)
        val plUp = findViewById<Button>(R.id.plUp)
        val poUp = findViewById<Button>(R.id.poUp)
        val peUp = findViewById<Button>(R.id.peUp)
        val ppUp = findViewById<Button>(R.id.ppUp)
        val pcUp = findViewById<Button>(R.id.pcUp)

        // Text
        val txtPlatina = findViewById<TextView>(R.id.txtVPL)
        val txtOuro = findViewById<TextView>(R.id.txtVPO)
        val txtElectro = findViewById<TextView>(R.id.txtVPE)
        val txtPrata = findViewById<TextView>(R.id.txtVPP)
        val txtCobre = findViewById<TextView>(R.id.txtVPC)

        // Set events onClick
        plDown.setOnClickListener{onClick(txtPlatina, "-")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        poDown.setOnClickListener{onClick(txtOuro, "-")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        peDown.setOnClickListener{onClick(txtElectro, "-")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        ppDown.setOnClickListener{onClick(txtPrata, "-")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        pcDown.setOnClickListener{onClick(txtCobre, "-")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        plUp.setOnClickListener{onClick(txtPlatina, "+")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        poUp.setOnClickListener{onClick(txtOuro, "+")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        peUp.setOnClickListener{onClick(txtElectro, "+")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        ppUp.setOnClickListener{onClick(txtPrata, "+")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
        pcUp.setOnClickListener{onClick(txtCobre, "+")
        arredandar(txtPlatina, txtOuro, txtElectro, txtPrata, txtCobre)}
    }

    fun onClick(text: TextView, somarOuSub: String){
        var moeda = text.text.toString().toInt()
        when(somarOuSub){
            "+" -> moeda += 1
            "-" -> moeda -= 1
        }
        text.text = moeda.toString()
    }

    fun arredandar(PL: TextView, PO: TextView, PE: TextView, PP: TextView, PC: TextView){
        var moedaPL = PL.text.toString().toInt()
        var moedaPO = PO.text.toString().toInt()
        var moedaPE = PE.text.toString().toInt()
        var moedaPP = PP.text.toString().toInt()
        var moedaPC = PC.text.toString().toInt()
        var dinheiros = (moedaPL * 1000) + (moedaPO * 100) + (moedaPE * 50) + (moedaPP * 10) + moedaPC
        if (moedaPC > 9){
            moedaPC = 0
            moedaPP += 1
        }
        if (moedaPP > 4){
            moedaPP = 0
            moedaPE += 1
        }
        if (moedaPE > 1){
            moedaPE = 0
            moedaPO += 1
        }
        if (moedaPO > 9){
            moedaPO = 0
            moedaPL += 1
        }
        if (moedaPC < 0){
            moedaPC = 9
            moedaPP -= 1
        }
        if (moedaPP < 0){
            moedaPP = 4
            moedaPE -= 1
        }
        if (moedaPE < 0){
            moedaPE = 1
            moedaPO -= 1
        }
        if (moedaPO < 0){
            moedaPO = 9
            moedaPL -= 1
        }


        PL.text = moedaPL.toString()
        PO.text = moedaPO.toString()
        PE.text = moedaPE.toString()
        PP.text = moedaPP.toString()
        PC.text = moedaPC.toString()
    }
}