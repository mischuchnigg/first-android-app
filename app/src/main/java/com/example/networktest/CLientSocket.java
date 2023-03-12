package com.example.networktest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CLientSocket extends Thread {
    private String hostname;
    private int port;
    private String sendMsg;
    Socket socket;
    DataOutputStream outToServer;
    BufferedReader r;

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }

    public String getRecieveMsg() {
        return recieveMsg;
    }

    public void setRecieveMsg(String recieveMsg) {
        this.recieveMsg = recieveMsg;
    }

    private String recieveMsg;
    public CLientSocket(String hostname, int port){
        this.port = port;
        this.hostname = hostname;

    }

    @Override
    public void run() {
        try {
                socket = new Socket(this.hostname, this.port);
                outToServer = new DataOutputStream(socket.getOutputStream());
                r = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            outToServer.writeBytes(sendMsg + '\n');
            this.recieveMsg = r.readLine();
            //MainActivity.setTextField(recieveMsg);


        }catch (IOException e){
            e.printStackTrace();
        }

    }




}
