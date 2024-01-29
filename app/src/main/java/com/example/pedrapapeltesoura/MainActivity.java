package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");

    }public void selecionarPapel(View view){
        verificarGanhador("papel");

    }public void selecionarTesoura(View view){
        verificarGanhador("tesoura");

    }
    private void verificarGanhador(String escolhaUsuario){
        System.out.println("Item clicado: " + escolhaUsuario);

    }

}