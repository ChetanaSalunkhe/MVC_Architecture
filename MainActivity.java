package com.example.mvc_designpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {

    Model model;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        //MVC design pattern
        model = new Model();
        model.addObserver(this);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                model.setValueAtIndex(0);
                break;

            case R.id.button2:
                model.setValueAtIndex(1);
                break;

            case R.id.button3:
                model.setValueAtIndex(2);
                break;
        }

    }

    @Override
    public void update(Observable o, Object arg) {

        btn1.setText("Count : "+model.getValueAtIndex(0));
        btn2.setText("Count : "+model.getValueAtIndex(1));
        btn3.setText("Count : "+model.getValueAtIndex(2));

    }
}
