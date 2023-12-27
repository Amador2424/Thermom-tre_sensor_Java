package com.example.thermo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor temp;
    private    Thermo t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            initUI();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        temp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorManager.registerListener(this,this.temp,SensorManager.SENSOR_DELAY_NORMAL);




    }
    private void initUI(){
         t = new Thermo(this, 50);
        setContentView(t);
       // t.setTemp(tmp);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float tmp =  sensorEvent.values[0];
        t.setTemp(tmp);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}