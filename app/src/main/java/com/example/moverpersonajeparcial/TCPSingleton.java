package com.example.moverpersonajeparcial;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPSingleton extends Thread {

    private static TCPSingleton unicainstancia;

    private Socket socket;
    private BufferedReader read;
    private BufferedWriter write;
    private OnMessageListener observer;

    private TCPSingleton() {

    }

    public static TCPSingleton getInstance() {
        if (unicainstancia == null) {
            unicainstancia = new TCPSingleton();
            unicainstancia.start();
        }
        return unicainstancia;
    }

    public void run () {
        try {
            socket = new Socket ("192.168.1.50", 5001);
            Log.d("CONECTOOOOO", "CONECTO");

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader (is);
            read = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter (os);
            write = new BufferedWriter (osw);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setObserver (OnMessageListener observer) {
        this.observer = observer;
    }

    public void sendMessage (String msn){
        new Thread (
                () -> {
                    try {
                        write.write(msn+"\n");
                        write.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }

}
