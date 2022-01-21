package dev.bc4.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoAlcool, precoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool     = findViewById(R.id.editPrecoAlcool);
        precoGasolina   = findViewById(R.id.editPrecoGasolina);
        resultado       = findViewById(R.id.resultTxt);
    }

    public void calcularPreco(View view){
        String alcool   = precoAlcool.getText().toString();
        String gasolina = precoGasolina.getText().toString();

        boolean camposValidados =  validarCampos(alcool,gasolina);

        if (camposValidados){
            alcool = alcool.replaceAll(",",".");
            gasolina = gasolina.replaceAll(",",".");

            double valorAlcool      = Double.parseDouble(alcool);
            double valorGasolina    = Double.parseDouble(gasolina);

            double x = valorAlcool/valorGasolina;

            if(x >= 0.7){
                resultado.setText("Melhor ultilizar gasolina!");
            }else{
                resultado.setText("Melhor ultilizar Álcool");
            }

        }else{
            resultado.setText("Preencha os campos primeiro");
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina){
        boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }
        if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }


        return camposValidados;
    }
}
