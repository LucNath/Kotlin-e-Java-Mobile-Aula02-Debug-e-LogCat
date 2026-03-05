package com.example.kotlin_e_java_mobile_aula02_debug_e_logcat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnFabricarPessoa;
    private Button btnSair;
    private Button btnCriarPessoa;
    private Button btnAlterarPessoa;
    private Button btnDeletarPessoa;
    private Button btnListarPessoa;
    private TextView txtPessoa, txtNome, txtIdade;
    Pessoa pessoa;
    int contador = 0;

    List<Pessoa> ListaDePessoas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        iniciarComponentesDeLayout();

        btnSair.setOnClickListener(v ->
        {
            sairDoAplicativo();
        });

        btnFabricarPessoa.setOnClickListener(v -> {
            metodoFabricarPessoa();
        });

        btnCriarPessoa.setOnClickListener(v -> {
            metodoParaCriarPessoa();
        });

        btnAlterarPessoa.setOnClickListener(v -> {
            metodoParaAlterarPessoa();
        });

        btnDeletarPessoa.setOnClickListener(v -> {
            metodoDeletarPessoa();
        });

        btnListarPessoa.setOnClickListener(v -> {
            metodoParaListarPessoa();
        });

    }

    private void metodoParaCriarPessoa() {
        pessoa = new Pessoa();

        pessoa.setNome("Lucas");
        pessoa.setIdade(getIdade());

        txtPessoa.setText(pessoa.toString());

        txtNome.setText(pessoa.getNome());
        txtIdade.setText(String.valueOf(pessoa.getIdade()));

        ListaDePessoas.add(pessoa);

        Toast.makeText(
                this,
                "Botão Criar Pessoa Clicado",
                Toast.LENGTH_SHORT).show();

        contador++;
        Log.d("eventos", "Botão Criar Pessoa Clicado " + contador);
    }

    private void metodoParaAlterarPessoa() {

        if(pessoa != null){
            contador++;
            Log.d("eventos", "Botão Alterar Pessoa Clicado " + contador);
            pessoa.setNome("Lucas");
            pessoa.setIdade(getIdade());
            txtPessoa.setText(pessoa.toString());
            txtNome.setText(pessoa.getNome());
            txtIdade.setText(String.valueOf(pessoa.getIdade()));

            Log.d("eventos", "Botão Alterar Pessoa Clicado " + contador);
        }else{
            Toast.makeText(
                    this,
                    "Botão Alterar Pessoa Clicado",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void metodoFabricarPessoa() {
        Toast.makeText(
                this,
                "Botão Fabricar Pessoa Clicado",
                Toast.LENGTH_SHORT).show();

        int idade = getIdade();
        pessoa = new Pessoa();
        txtPessoa.setText(pessoa.toString());
    }

    private void metodoDeletarPessoa() {
        if(pessoa != null){
            contador++;
            Log.d("eventos", "Pessoa Deletada " + contador);
            pessoa.setNome("Lucas");
            pessoa.setIdade(getIdade());
            txtPessoa.setText(pessoa.toString());
            txtNome.setText(pessoa.getNome());
            txtIdade.setText(String.valueOf(pessoa.getIdade()));

            Log.d("eventos", "Botão Deletar Pessoa Clicado " + contador);
        }else{
            Toast.makeText(
                    this,
                    "Botão Deletar Pessoa Clicado",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void metodoParaListarPessoa() {

        for(Pessoa p : ListaDePessoas){

            Log.i("eventos", "Pessoa Cadastrada" + p.toString());

        }
    }

    private void iniciarComponentesDeLayout() {
        btnFabricarPessoa = findViewById(R.id.btnFabricarPessoa);
        btnCriarPessoa = findViewById(R.id.btnCriarPessoa);
        btnAlterarPessoa = findViewById(R.id.btnAlterarPessoa);
        btnDeletarPessoa = findViewById(R.id.btnDeletarPessoa);
        btnListarPessoa = findViewById(R.id.btnListarPessoa);
        btnSair = findViewById(R.id.btnSair);

        txtPessoa = findViewById(R.id.txtPessoa);
        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);
    }

    private void sairDoAplicativo() {
        contador++;
        Log.d("eventos", "Botão Sair Clicado " + contador);
        finish();
    }

    private static int getIdade() {
        Random idadeAleatoria = new Random();
        int min = 18;
        int max = 60;
        int idade = idadeAleatoria.nextInt((max - min) + 1) + min;
        return idade;
    }
}
