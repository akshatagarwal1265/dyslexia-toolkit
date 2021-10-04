package com.example.dodlasaivarun12.t2ss2t11;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class Texttospeech extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextToSpeech tts;
    EditText writetext,speed,pitch;
    Spinner spinner;
    Button paste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttospeech);
        writetext=(EditText)findViewById(R.id.writetext);
        speed=(EditText)findViewById(R.id.speed);
        pitch=(EditText)findViewById(R.id.pitch);
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter adpater=ArrayAdapter.createFromResource(this,R.array.lang,android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adpater);
        spinner.setOnItemSelectedListener(this);
        paste=(Button)findViewById(R.id.paste);


        tts=new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener(){

                    public void onInit(int status){
                        if(status!=TextToSpeech.ERROR){
                            tts.setLanguage(Locale.getDefault());
                            // tts.setVoice(Voice.LATENCY_HIGH);

                        }

                    }

                });

    }


    public void onPause(){
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

/*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String string = parent.getItemAtPosition(position).toString();
        switch (string) {
            case "UK": {
                //Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.UK);
                break;
            }
            case "CANADA": {
                //Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.CANADA);
                break;
            }
            case "FRENCH": {
                // Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Please switch to FRENCH keyboard", Toast.LENGTH_SHORT).show();
                tts.setLanguage(Locale.FRENCH);
                break;
            }

            case "CHINA":{
                Toast.makeText(this, "Please switch to CHINA keyboard", Toast.LENGTH_SHORT).show();
                tts.setLanguage(Locale.CHINESE);
                break;
            }

            case "JAPAN":{
                Toast.makeText(this, "Please switch to JAPAN keyboard", Toast.LENGTH_SHORT).show();
                tts.setLanguage(Locale.JAPANESE);
                break;
            }

            case "GERMAN":{
                Toast.makeText(this,"please switch to GERMAN keyboard",Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.GERMAN);
            }

            case "ITALY":{
                Toast.makeText(this,"please switch to ITALY keyboard",Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.ITALIAN);
            }

            default: {
                //Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.US);
                break;
            }

        }
    }



    public void onClick3(View view) {
        String toSpeak = writetext.getText().toString();
        if (writetext.length() == 0) {
            writetext.setError("Invalid");
        } else {
            String rate = pitch.getText().toString();
            if (pitch.length() == 0){
                pitch.setError("Enter the value between 0.1 to 10");
            } else {
                //tts.setPitch(1)
                Float Pitchrate = Float.valueOf(rate);
                tts.setPitch(Pitchrate);
                    String srate = speed.getText().toString();
                    if (speed.length() == 0) {
                        speed.setError("Enter the value between 0.1 to 10");
                    } else {
                        // tts.setSpeechRate(1);
                        Float Speedrate = Float.valueOf(srate);
                        tts.setSpeechRate(Speedrate);
                        Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_LONG).show();
                        tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    }
            }
        }
    }


*/







    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String string = parent.getItemAtPosition(position).toString();
        switch (string) {
            case "UK": {
                //Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.UK);
                break;
            }
            case "CANADA": {
                //Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.CANADA);
                break;
            }
            case "FRENCH": {
                // Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.FRENCH);
                Toast.makeText(getApplicationContext(),"Please switch to french keyboard",Toast.LENGTH_LONG).show();
                break;
            }

            case "ITALIAN":{

                tts.setLanguage(Locale.ITALIAN);
                Toast.makeText(getApplicationContext(),"Please switch to ITALIAN keyboard",Toast.LENGTH_LONG).show();
                break;
            }

            case "GERMAN":{
                tts.setLanguage(Locale.GERMAN);
                Toast.makeText(getApplicationContext(),"Please switch to GERMAN keyboard",Toast.LENGTH_LONG).show();
                break;
            }


            default: {
                //Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                tts.setLanguage(Locale.US);
                break;
            }

        }
    }



    public void pasteButton(View view){
        ClipboardManager cm=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        String text=cm.getText().toString();
        if(text.length()==0){
            Toast.makeText(getApplicationContext(),"cannot paste ",Toast.LENGTH_LONG).show();
            cm.setText("Hello");
        }
        else{
            writetext.setText(text);


        }
    }





    public void onClick3(View view) {
        String toSpeak = writetext.getText().toString();
        if (writetext.length() == 0)
        {
            writetext.setError("Invalid");
        } else
        {
            String rate = pitch.getText().toString();
            if (pitch.length() == 0)
            {
                pitch.setError("Enter the value between 0.1 to 10");
            }
            else
            {
                // tts.setPitch(Pitchrate);
                String srate = speed.getText().toString();
                //tts.setPitch(1)
                if (speed.length() == 0)
                {
                    speed.setError("Enter the value between 0.1 to 10");
                } else
                {
                    Float Pitchrate = Float.valueOf(rate);
                    // tts.setSpeechRate(1);
                    Float Speedrate = Float.valueOf(srate);
                    if(((Pitchrate==0)||(Pitchrate>10)))
                    {
                        pitch.setError("Enter a valid value");
                    }
                    else
                    {
                        if((Speedrate==0)||(Speedrate>10))
                        {
                            speed.setError("Enter a valid value");
                        }
                        else {
                            tts.setPitch(Pitchrate);
                            tts.setSpeechRate(Speedrate);
                            Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_LONG).show();
                            tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                }
            }
        }
    }














    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

   /* public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.maintts,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.help:
                help();
                break;
        }

        return true;
    }

    public void help(){
        Intent i=new Intent(this,T2SHelp.class);
        startActivity(i);
    }*/


}