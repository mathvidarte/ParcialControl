package com.example.moverpersonajeparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.moverpersonajeparcial.model.Generic;
import com.example.moverpersonajeparcial.model.Posicion;
import com.google.gson.Gson;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements OnMessageListener{
    private EditText name;
    private Button btnOK;
    private Posicion pos;
    private TCPSingleton tcp;

    /*private Socket socket;
    private BufferedReader read;
    private BufferedWriter write;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        btnOK = findViewById(R.id.btnOK);

        tcp = TCPSingleton.getInstance();

        //initCliente();

        btnOK.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson ();

                    String id = UUID.randomUUID().toString();
                    String msn = name.getText().toString();


                    Posicion pos = new Posicion (msn, id);
                    String json = gson.toJson(pos);

                    tcp.sendMessage(json);

                    Intent i = new Intent(this, Control.class);
                    startActivity(i);
                }
        );
    }


}


