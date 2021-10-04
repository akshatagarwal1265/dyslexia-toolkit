package com.example.dodlasaivarun12.t2ss2t11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view){
        Intent i=new Intent(this,Texttospeech.class);
        startActivity(i);
    }

    public void onClick5(View view){
        Intent i=new Intent(this,Speechtotext.class);
        startActivity(i);
    }

}

