package com.example.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.*;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    String hostname = "se2-isys.aau.at";
    int port = 53212;
    CLientSocket sock;
    Button btn1;
    Button btCalc;
    EditText nrInput;

    static TextView outText;
    String mrNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nrInput = findViewById(R.id.editTextNumber);
        outText = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(view -> {
            mrNr = nrInput.getText().toString();
            sock = new CLientSocket(hostname,port);
            sock.setSendMsg(mrNr);
            sock.start();
            while(sock.getRecieveMsg()==null){
            }
            outText.setText(sock.getRecieveMsg());
        });
        btCalc = findViewById(R.id.button2);
        btCalc.setOnClickListener(view -> {
            mrNr = nrInput.getText().toString();
            int sum = 0;
            for(int i = 0;i<mrNr.length();i++){
                int number = Integer.parseInt(String.valueOf(mrNr.charAt(i)));
                if(i%2==1){
                    sum = sum - number;
                }else sum = sum + number;
            }
            if(sum%2==0)
            outText.setText("Die Alternierende Quersumme ist gerade");
            else outText.setText("Die Alternierende Quersumme ist ungerade");


        });


    }
    public static void setTextField(String msg){
        outText.setText(msg);

    }
}