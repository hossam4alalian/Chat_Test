package com.example.chat_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText text;

    TextView recieved;
    TextView recievedMessage;

    LinearLayout lin;
    String str;

    login login = new login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        new Thread(){
            public void run(){
                try {


                        while(true) {

                            str= login.client.getDi().readUTF();

                            try {
                                if(!str.equals("")) {

                                    recieved=new TextView(MainActivity.this);

                                    Log.wtf("a",str);
                                    recievedMessage.setText(str);
                                    recieved.setText(recievedMessage.getText().toString());
                                    lin.addView(recieved);


                                }

                            } catch (Exception e) {
                                Log.wtf("a","whattttttt");
                            }

                        }



                } catch (Exception e){

                }
            }
        }.start();

        chat();


    }

    public void chat(){
        lin = (LinearLayout) findViewById(R.id.chatBox);
        lin.removeAllViews();

        recievedMessage = (TextView) findViewById(R.id.recievedMessage);

        Button send=(Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();

            }
        });
    }

    public void send(){

                try {

                    //TextView sentMessage = new TextView(MainActivity.this);
                    //sentMessage.setText(login.getName().getText()+" : "+text.getText());
                    //lin.addView(sentMessage);

                    text = (EditText) findViewById(R.id.text);

                    if(!text.getText().equals("")){


                        login.client.getDs().writeUTF(text.getText().toString());
                    }


                } catch (IOException e){

                }

    }


   



}
