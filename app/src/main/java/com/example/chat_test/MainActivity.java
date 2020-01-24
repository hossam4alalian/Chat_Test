package com.example.chat_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText text;

    TextView recieved;
    LinearLayout lin;
    String str;
    boolean reading=false;

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

                                    recieved.setText(str);

                                }

                            } catch (Exception e) {
                                System.out.println("what");
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

                    recieved=new TextView(MainActivity.this);

                    lin.addView(recieved);

                    text = (EditText) findViewById(R.id.text);


                    if(!text.getText().equals("")){
                        login.client.getDs().writeUTF(text.getText().toString());
                    }
                    reading=true;

                } catch (IOException e){

                }

    }

}
