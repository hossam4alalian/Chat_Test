package com.example.chat_test;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {


    private Socket s;
    private DataOutputStream ds;
    private DataInputStream di;




        public Client() {


            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            try {

                s = new Socket("192.168.216.139", 6969);
                ds = new DataOutputStream(s.getOutputStream());
                di = new DataInputStream(s.getInputStream());


            } catch (IOException e) {

            }


        }


    public Socket getS() {
        return s;
    }


    public void setS(Socket s) {
        this.s = s;
    }

    public DataOutputStream getDs() {
        return ds;
    }


    public void setDs(DataOutputStream Ds) {
        this.ds = ds;
    }

    public DataInputStream getDi() {
        return di;
    }


    public void setDi(DataOutputStream Di) {
        this.di = di;
    }


    }
