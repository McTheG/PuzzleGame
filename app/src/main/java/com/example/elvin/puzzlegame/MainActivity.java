package com.example.elvin.puzzlegame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView textX, textY, textZ, numberHint;
    private Sensor mySensor;
    private SensorManager SensorManager;
    private ImageView lock1_imageView, lock2_imageView, lock3_imageView;
    private int selectedLock = 1, lock1Number, lock2Number, lock3Number, randomNumber1, randomNumber2, randomNumber3;
    private Button lock1_button, lock2_button, lock3_button, resetButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lock1_button=(Button) findViewById(R.id.lock1_button);
        lock2_button=(Button) findViewById(R.id.lock2_button);
        lock3_button=(Button) findViewById(R.id.lock3_button);
        resetButton=(Button) findViewById(R.id.resetButton);

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
        numberHint = (TextView) findViewById(R.id.numberHint);
        lock1_imageView = (ImageView) findViewById(R.id.lock1_imageView);
        lock2_imageView = (ImageView) findViewById(R.id.lock2_imageView);
        lock3_imageView = (ImageView) findViewById(R.id.lock3_imageView);

        randomizer();

        /* Debugging
        textView3 = (TextView) findViewById(R.id.textView3);

        String t= Integer.toString(randomNumber1);
        String tt= Integer.toString(randomNumber2);
        String ttt= Integer.toString(randomNumber3);
        textView3.setText(t + tt + ttt);
        */
    }

    public void randomizer(){
        Random r = new Random();
        randomNumber1 = r.nextInt(10) + 0;
        randomNumber2 = r.nextInt(10) + 0;
        randomNumber3 = r.nextInt(10) + 0;

        String a = Integer.toString(randomNumber1);
        String b= Integer.toString(randomNumber2);
        String c= Integer.toString(randomNumber3);

        lock1_imageView.setImageResource(R.drawable.number0);
        lock1Number = 0;

        lock2_imageView.setImageResource(R.drawable.number0);
        lock2Number = 0;

        lock3_imageView.setImageResource(R.drawable.number0);
        lock3Number = 0;
        selectedLock = 1;

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        Collections.shuffle(arrayList);

        numberHint.setText(arrayList.get(0) + arrayList.get(1) + arrayList.get(2));
    }

    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
        case R.id.lock1_button:
            Toast.makeText(MainActivity.this,"You clicked on Lock 1", Toast.LENGTH_SHORT).show();
            selectedLock = 1;
            break;
        case R.id.lock2_button:
            Toast.makeText(MainActivity.this,"You clicked on Lock 2", Toast.LENGTH_SHORT).show();
            selectedLock = 2;
            break;
        case R.id.lock3_button:
            Toast.makeText(MainActivity.this,"You clicked on Lock 3", Toast.LENGTH_SHORT).show();
            selectedLock = 3;
            break;
        case R.id.resetButton:
            Toast.makeText(MainActivity.this,"You clicked on reset", Toast.LENGTH_SHORT).show();
            randomizer();
            break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        /* Debugging
        textX.setText("X: " + event.values[0]);
        textY.setText("Y: " + event.values[1]);
        textZ.setText("Z: " + event.values[2]);
        */

        //Postive Numbers
        if(event.values[0] > 0 && event.values[0] < 1) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number0);
                lock1Number = 0;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number0);
                lock2Number = 0;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number0);
                lock3Number = 0;
            }
        }
        if(event.values[0] > 1 && event.values[0] < 2) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number1);
                lock1Number = 1;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number1);
                lock2Number = 1;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number1);
                lock3Number = 1;
            }
        }
        if(event.values[0] > 2 && event.values[0] < 3) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number2);
                lock1Number = 2;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number2);
                lock2Number = 2;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number2);
                lock3Number = 2;
            }
        }
        if(event.values[0] > 3 && event.values[0] < 4) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number3);
                lock1Number = 3;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number3);
                lock2Number = 3;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number3);
                lock3Number = 3;
            }
        }
        if(event.values[0] > 4 && event.values[0] < 5) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number4);
                lock1Number = 4;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number4);
                lock2Number = 4;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number4);
                lock3Number = 4;
            }
        }
        if(event.values[0] > 5 && event.values[0] < 6) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number5);
                lock1Number = 5;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number5);
                lock2Number = 5;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number5);
                lock3Number = 5;
            }
        }
        if(event.values[0] > 6 && event.values[0] < 7) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number6);
                lock1Number = 6;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number6);
                lock2Number = 6;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number6);
                lock3Number = 6;
            }
        }
        if(event.values[0] > 7 && event.values[0] < 8) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number7);
                lock1Number = 7;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number7);
                lock2Number = 7;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number7);
                lock3Number = 7;
            }
        }
        if(event.values[0] > 8 && event.values[0] < 9) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number8);
                lock1Number = 8;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number8);
                lock2Number = 8;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number8);
                lock3Number = 8;
            }
        }
        if(event.values[0] > 9 && event.values[0] < 10) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number9);
                lock1Number = 9;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number9);
                lock2Number = 9;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number9);
                lock3Number = 9;
            }
        }

        //Negative Numbers
        if(event.values[0] < -0 && event.values[0] > -1) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number0);
                lock1Number = 0;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number0);
                lock2Number = 0;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number0);
                lock3Number = 0;
            }
        }
        if(event.values[0] < -1 && event.values[0] > -2) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number1);
                lock1Number = 1;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number1);
                lock2Number = 1;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number1);
                lock3Number = 1;
            }
        }
        if(event.values[0] < -2 && event.values[0] > -3) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number2);
                lock1Number = 2;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number2);
                lock2Number = 2;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number2);
                lock3Number = 2;
            }
        }
        if(event.values[0] < -3 && event.values[0] > -4) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number3);
                lock1Number = 3;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number3);
                lock2Number = 3;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number3);
                lock3Number = 3;
            }
        }
        if(event.values[0] < -4 && event.values[0] > -5) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number4);
                lock1Number = 4;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number4);
                lock2Number = 4;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number4);
                lock3Number = 4;
            }
        }
        if(event.values[0] < -5 && event.values[0] > -6) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number5);
                lock1Number = 5;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number5);
                lock2Number = 5;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number5);
                lock3Number = 5;
            }
        }
        if(event.values[0] < -6 && event.values[0] > -7) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number6);
                lock1Number = 6;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number6);
                lock2Number = 6;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number6);
                lock3Number = 6;
            }
        }
        if(event.values[0] < -7 && event.values[0] > -8) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number7);
                lock1Number = 7;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number7);
                lock2Number = 7;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number7);
                lock3Number = 7;
            }
        }
        if(event.values[0] < -8 && event.values[0] > -9) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number8);
                lock1Number = 8;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number8);
                lock2Number = 8;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number8);
                lock3Number = 8;
            }
        }
        if(event.values[0] < -9 && event.values[0] > -10) {
            if(selectedLock == 1) {
                lock1_imageView.setImageResource(R.drawable.number9);
                lock1Number = 9;
            }
            if(selectedLock == 2) {
                lock2_imageView.setImageResource(R.drawable.number9);
                lock2Number = 9;
            }
            if(selectedLock == 3) {
                lock3_imageView.setImageResource(R.drawable.number9);
                lock3Number = 9;
            }
        }

        if(randomNumber1 == lock1Number && randomNumber2 == lock2Number && randomNumber3 == lock3Number)
        {
            Toast.makeText(MainActivity.this,"You solved the puzzle!!!", Toast.LENGTH_SHORT).show();
            numberHint.setTextColor(Color.RED);
            //sleep needed!!!
            randomizer();
            Continue();
        }
        else{
            numberHint.setTextColor(Color.BLACK);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void Continue() {
        // Do something in response to button

        Intent intent = new Intent(this, LightOut.class);
        startActivity(intent);
    }

}