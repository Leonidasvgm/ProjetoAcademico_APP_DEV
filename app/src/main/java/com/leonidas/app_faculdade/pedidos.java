package com.leonidas.app_faculdade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class pedidos extends AppCompatActivity implements View.OnClickListener {
    TextView txtqtdSalada, txtqtdBacon, txtqtdBatata, txtqtdRefri, txtTotalPedido;
    Button btnMaisSalada, btnMenosSalada, btnMaisBacon, btnMenosBacon, btnMaisRefri, btnMenosRefri;
    Button btnMaisBatata, btnMenosBatata, btnGravarPedido;
    String nome = "";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        getSupportActionBar().hide();

        IniciarComponentes();
        btnGravarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pedidos.this,TelaPrincipal.class);
                startActivity(intent);
                finish();
            }
        });


        txtqtdSalada = (TextView) findViewById(R.id.txtqtdSalada);
        txtqtdBacon = (TextView) findViewById(R.id.txtqtdBacon);
        txtqtdBatata = (TextView) findViewById(R.id.txtqtdBatata);
        txtqtdRefri = (TextView) findViewById(R.id.txtqtdRefri);
        txtTotalPedido = (TextView) findViewById(R.id.txtTotalPedido);

        btnMaisSalada = (Button) findViewById(R.id.btnMaisSalada);
        btnMenosSalada = (Button) findViewById(R.id.btnMenosSalada);
        btnMaisBacon = (Button) findViewById(R.id.btnMaisBacon);
        btnMenosBacon = (Button) findViewById(R.id.btnMenosBacon);
        btnMaisBatata = (Button) findViewById(R.id.btnMaisBatata);
        btnMenosBatata = (Button) findViewById(R.id.btnMenosBatata);
        btnMaisRefri = (Button) findViewById(R.id.btnMaisRefri);
        btnMenosRefri = (Button) findViewById(R.id.btnMenosRefri);
        btnGravarPedido = (Button) findViewById(R.id.btnGravarPedido);

        btnMaisSalada.setOnClickListener(this);
        btnMenosSalada.setOnClickListener(this);
        btnMaisBacon.setOnClickListener(this);
        btnMenosBacon.setOnClickListener(this);
        btnMaisBatata.setOnClickListener(this);
        btnMenosBatata.setOnClickListener(this);
        btnMaisRefri.setOnClickListener(this);
        btnMenosRefri.setOnClickListener(this);;
    }

    public void onClick(View v) {
        int qtdSalada = 0, qtdBacon = 0, qtdBatata = 0, qtdRefri = 0;
        float valorSalada = (float) 18.00;
        float valorBacon = (float) 24.00;
        float valorBatata = (float) 27.00;
        float valorRefri = (float) 5.00;
        float subTotalSalada = 0;
        float subTotalBacon = 0;
        float subTotalBatata = 0;
        float subTotalRefri = 0;
        qtdSalada = Integer.parseInt(txtqtdSalada.getText().toString());
        qtdBacon = Integer.parseInt(txtqtdBacon.getText().toString());
        qtdBatata = Integer.parseInt(txtqtdBatata.getText().toString());
        qtdRefri = Integer.parseInt(txtqtdRefri.getText().toString());

        if (v.getId() == R.id.btnMaisSalada) {
            qtdSalada += 1;
            txtqtdSalada.setText("" + qtdSalada);
        }
        if (v.getId() == R.id.btnMenosSalada) {
            qtdSalada -= 1;
            if (qtdSalada <= 0) {
                qtdSalada = 0;
            }
            txtqtdSalada.setText("" + qtdSalada);
        }

        if (v.getId() == R.id.btnMaisBacon) {
            qtdBacon += 1;
            txtqtdBacon.setText("" + qtdBacon);
        }
        if (v.getId() == R.id.btnMenosBacon) {
            qtdBacon -= 1;
            if (qtdBacon <= 0) {
                qtdBacon = 0;
            }
            txtqtdBacon.setText("" + qtdBacon);
        }

        if (v.getId() == R.id.btnMaisBatata) {
            qtdBatata += 1;
            txtqtdBatata.setText("" + qtdBatata);
        }
        if (v.getId() == R.id.btnMenosBatata) {
            qtdBatata -= 1;
            if (qtdBatata <= 0) {
                qtdBatata = 0;
            }
            txtqtdBatata.setText("" + qtdBatata);
        }
        if (v.getId() == R.id.btnMaisRefri) {
            qtdRefri += 1;
            txtqtdRefri.setText("" + qtdRefri);
        }
        if (v.getId() == R.id.btnMenosRefri) {
            qtdRefri -= 1;
            if (qtdRefri <= 0) {
                qtdRefri = 0;
            }
            txtqtdRefri.setText("" + qtdRefri);
        }
        subTotalSalada = qtdSalada * valorSalada;
        subTotalBacon = qtdBacon * valorBacon;
        subTotalBatata = qtdBatata * valorBatata;
        subTotalRefri = qtdRefri * valorRefri;

        float total = subTotalSalada + subTotalBacon + subTotalBatata + subTotalRefri;
        txtTotalPedido.setText("" + total);

    }
    private void IniciarComponentes(){
        btnGravarPedido = findViewById(R.id.btnGravarPedido);
    }
}
