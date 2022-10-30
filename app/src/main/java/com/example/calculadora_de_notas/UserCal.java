package com.example.calculadora_de_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class UserCal extends AppCompatActivity implements View.OnClickListener {
    EditText nota1, nota2, nota3;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cal);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        resultado = findViewById(R.id.text_resultado);
        findViewById(R.id.btn_calcular).setOnClickListener(this);
        findViewById(R.id.btn_limpiar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_calcular:
                Notas notas = new Notas();
                notas.setNota1(nota1.getText().toString());
                notas.setNota2(nota2.getText().toString());
                notas.setNota3(nota3.getText().toString());

                if(!notas.getNota1().isEmpty() && !notas.getNota2().isEmpty()){
                    if(!notas.getNota3().isEmpty()){
                        int int1 = Integer.parseInt(notas.getNota1());
                        int int2 = Integer.parseInt(notas.getNota2());
                        int int3 = Integer.parseInt(notas.getNota3());
                        Double result = int1 * 0.35 + int2 * 0.35 + int3 * 0.30;
                        resultado.setText(Double.toString(result));
                        if(result >= 30 || result >= 3.0){
                            Toast.makeText(this, "Felicitaciones", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(this, "Que bruto Pongale 0", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        int int1 = Integer.parseInt(notas.getNota1());
                        int int2 = Integer.parseInt(notas.getNota2());
                        Double result = int1 * 0.35 + int2 * 0.35 + 1.0 * 0.30;
                        resultado.setText(Double.toString(result));
                    }
                }else{
                    Toast.makeText(this, "Introduce las notas", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_limpiar:
                nota1.setText("");
                nota2.setText("");
                nota3.setText("");
                resultado.setText("Resultado");
                break;
        }
    }
}