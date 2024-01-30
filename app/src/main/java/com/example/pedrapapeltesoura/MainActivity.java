package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.OptionalInt;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int ptsUserValue = 0;
    int ptsAppValue = 0;

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
    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra","papel","tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imageApp = findViewById(R.id.image_App);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

    @SuppressLint("ResourceAsColor")
    private void verificarGanhador(String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textResult = findViewById(R.id.textResult);
        TextView ptsUser = findViewById(R.id.PtsUser);
        TextView ptsApp = findViewById(R.id.PtsApp);

        if((escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ) {
            textResult.setText("Você Perdeu :(");

            ptsUserValue = ptsUserValue + 1;
            ptsUser.setText(Integer.toString(ptsUserValue));
            ptsUser.setTextColor(Color.GREEN);
        }else if((escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ){
            textResult.setText("Você Ganhou ^^");

            ptsAppValue = ptsAppValue + 1;
            ptsApp.setText(Integer.toString(ptsAppValue));
            ptsApp.setTextColor(Color.RED);
        }else{
            textResult.setText("Empate");
        }

    }



}