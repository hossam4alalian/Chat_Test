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

public class login extends AppCompatActivity {
    EditText name;
    static Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginActivity();
    }

    public void loginActivity(){
        name= (EditText) findViewById(R.id.name);
        final Intent intent = new Intent(this, MainActivity.class);

        Button create=(Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    client = new Client();
                    client.getDs().writeUTF(name.getText().toString());

                } catch (IOException e){

                }
                 startActivity(intent);
            }
        });

    }




}
