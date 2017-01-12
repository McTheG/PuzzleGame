package com.example.elvin.puzzlegame;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView textX, textY, textZ;
    private Sensor mySensor;
    private SensorManager SensorManager;
    private ImageView lock1_imageView, lock2_imageView, lock3_imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create sensor manager
        SensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer sensor
        mySensor = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register SensorListener
        SensorManager.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        //Assign textviews
        textX = (TextView) findViewById(R.id.textX);
        textY = (TextView) findViewById(R.id.textY);
        textZ = (TextView) findViewById(R.id.textZ);
        lock1_imageView = (ImageView) findViewById(R.id.lock1_imageView);
        lock2_imageView = (ImageView) findViewById(R.id.lock2_imageView);
        lock3_imageView = (ImageView) findViewById(R.id.lock3_imageView);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        textX.setText("X: " + event.values[0]);
        textY.setText("Y: " + event.values[1]);
        textZ.setText("Z: " + event.values[2]);

        //Postive Numbers
        if(event.values[0] > 0 && event.values[0] < 1) {
            lock1_imageView.setImageResource(R.drawable.number0);
        }
        if(event.values[0] > 1 && event.values[0] < 2) {
            lock1_imageView.setImageResource(R.drawable.number1);
        }
        if(event.values[0] > 2 && event.values[0] < 3) {
            lock1_imageView.setImageResource(R.drawable.number2);
        }
        if(event.values[0] > 3 && event.values[0] < 4) {
            lock1_imageView.setImageResource(R.drawable.number3);
        }
        if(event.values[0] > 4 && event.values[0] < 5) {
            lock1_imageView.setImageResource(R.drawable.number4);
        }
        if(event.values[0] > 5 && event.values[0] < 6) {
            lock1_imageView.setImageResource(R.drawable.number5);
        }
        if(event.values[0] > 6 && event.values[0] < 7) {
            lock1_imageView.setImageResource(R.drawable.number6);
        }
        if(event.values[0] > 7 && event.values[0] < 8) {
            lock1_imageView.setImageResource(R.drawable.number7);
        }
        if(event.values[0] > 8 && event.values[0] < 9) {
            lock1_imageView.setImageResource(R.drawable.number8);
        }
        if(event.values[0] > 9 && event.values[0] < 10) {
            lock1_imageView.setImageResource(R.drawable.number9);
        }

        //Negative Numbers
        if(event.values[0] < -0 && event.values[0] > -1) {
            lock1_imageView.setImageResource(R.drawable.number0);
        }
        if(event.values[0] < -1 && event.values[0] > -2) {
            lock1_imageView.setImageResource(R.drawable.number1);
        }
        if(event.values[0] < -2 && event.values[0] > -3) {
            lock1_imageView.setImageResource(R.drawable.number2);
        }
        if(event.values[0] < -3 && event.values[0] > -4) {
            lock1_imageView.setImageResource(R.drawable.number3);
        }
        if(event.values[0] < -4 && event.values[0] > -5) {
            lock1_imageView.setImageResource(R.drawable.number4);
        }
        if(event.values[0] < -5 && event.values[0] > -6) {
            lock1_imageView.setImageResource(R.drawable.number5);
        }
        if(event.values[0] < -6 && event.values[0] > -7) {
            lock1_imageView.setImageResource(R.drawable.number6);
        }
        if(event.values[0] < -7 && event.values[0] > -8) {
            lock1_imageView.setImageResource(R.drawable.number7);
        }
        if(event.values[0] < -8 && event.values[0] > -9) {
            lock1_imageView.setImageResource(R.drawable.number8);
        }
        if(event.values[0] < -9 && event.values[0] > -10) {
            lock1_imageView.setImageResource(R.drawable.number9);
        }
    }

    //gebruiken we niet, is voor error weg te halen als deze er niet is
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
