package com.example.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    String hostname = "se2-isys.aau.at";
    int port = 53212;
    Socket sock;
    Button btn;
    EditText nrInput;
    String mrNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* try {
            sock = new Socket(hostname,port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        nrInput = findViewById(R.id.editTextNumber);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mrNr = nrInput.getText().toString();
                Log.d("TAG",mrNr);

            }
        });
    }
}