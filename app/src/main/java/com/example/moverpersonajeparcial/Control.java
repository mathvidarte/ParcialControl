package com.example.moverpersonajeparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.moverpersonajeparcial.model.Color;
import com.example.moverpersonajeparcial.model.Move;
import com.google.gson.Gson;

public class Control extends AppCompatActivity implements View.OnTouchListener, OnMessageListener{

    private Button up;
    private Button down;
    private Button left;
    private Button right;
    private Button color;
    private TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contro);

        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        left = findViewById(R.id.left);
        right  = findViewById(R.id.right);
        color = findViewById(R.id.color);

        up.setOnTouchListener(this);
        down.setOnTouchListener(this);
        left.setOnTouchListener(this);
        right.setOnTouchListener(this);
        color.setOnTouchListener(this);

        tcp = TCPSingleton.getInstance();

        tcp.setObserver(this);



        color.setOnClickListener(
                (v)-> {

                }
        );


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

                    switch (view.getId()){
                        case R.id.up:
                            switch (motionEvent.getAction()){
                                case MotionEvent.ACTION_DOWN:
                                    Gson gson = new Gson();
                                    Move ups = new Move("up");
                                    String json = gson.toJson(ups);
                                    tcp.sendMessage(json);
                                    break;
                            }
                            break;

                        case R.id.down:
                            switch (motionEvent.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    Gson gson1 = new Gson();
                                    Move downs = new Move ("down");
                                    String json1 = gson1.toJson(downs);
                                    tcp.sendMessage(json1);
                                    break;
                            }
                            break;

                        case R.id.left:
                            switch (motionEvent.getAction()){
                                case MotionEvent.ACTION_DOWN:
                                    Gson gson2 = new Gson();
                                    Move lefts = new Move ("left");
                                    String json2 = gson2.toJson(lefts);
                                    tcp.sendMessage(json2);
                                    break;
                            }
                            break;

                        case R.id.right:
                            switch (motionEvent.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    Gson gson3 = new Gson();
                                    Move rights = new Move ("right");
                                    String json3 = gson3.toJson(rights);
                                    tcp.sendMessage(json3);
                                    break;
                            }
                            break;
                        case R.id.color:
                           switch (motionEvent.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    Gson gson4 = new Gson();
                                    Color color = new Color ("color");
                                    String json4 = gson4.toJson(color);
                                    tcp.sendMessage(json4);
                                   // Log.d("YAAAAA", ""+json4);
                                    break;
                            }
                            break;

                    }


        return true;
    }
}