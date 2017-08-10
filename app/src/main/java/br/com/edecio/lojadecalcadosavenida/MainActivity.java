package br.com.edecio.lojadecalcadosavenida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox chkOlimpikus;
    private CheckBox chkAdidas;
    private CheckBox chkNike;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btnEnviar;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkOlimpikus = (CheckBox) findViewById(R.id.chkOlimpikus);
        chkAdidas = (CheckBox) findViewById(R.id.chkAdidas);
        chkNike = (CheckBox) findViewById(R.id.chkNike);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnEnviar.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String marcas = "";
        String sexo = "";

        // se clicou no enviar
        if (v.getId() == R.id.btnEnviar) {
            if (chkOlimpikus.isChecked()) {
                marcas = "Olimpikus";
            }
            if (chkAdidas.isChecked()) {
                marcas = (marcas=="" ? "Adidas" : marcas + ", Adidas");
            }
            if (chkNike.isChecked()) {
                marcas = (marcas=="" ? "Nike" : marcas + ", Nike");
            }
            sexo = (rbMasculino.isChecked() ? "Masculino" : "Feminino");

            Toast.makeText(this, "Você gosta das marcas "+marcas+" e é do sexo "+sexo, Toast.LENGTH_LONG).show();
        } else {
            chkOlimpikus.setChecked(false);
            chkAdidas.setChecked(false);
            chkNike.setChecked(false);
            rbMasculino.setChecked(false);
            rbFeminino.setChecked(false);
            chkOlimpikus.requestFocus();
        }
    }
}
