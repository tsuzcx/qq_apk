package com.tencent.qqmail.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import com.tencent.qqmail.QMApplicationContext;

public class BrightnessDialog
  extends ReportDialogFragment
  implements SensorEventListener
{
  public static final String TAG = BrightnessDialog.class.getSimpleName();
  private TextView brightnessVal;
  private boolean hasSensor = true;
  private Sensor lightSensor;
  private SensorManager sensorManager;
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().getWindow().requestFeature(1);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    setCancelable(false);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559228, paramViewGroup, false);
    this.brightnessVal = ((TextView)paramLayoutInflater.findViewById(2131363724));
    ((Button)paramLayoutInflater.findViewById(2131372255)).setOnClickListener(new BrightnessDialog.1(this));
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.sensorManager == null) || (this.lightSensor == null)) {
      return;
    }
    this.sensorManager.unregisterListener(this, this.lightSensor);
    this.sensorManager = null;
    this.lightSensor = null;
    Log.i(TAG, "unregisterListener");
  }
  
  public void onResume()
  {
    super.onResume();
    this.sensorManager = ((SensorManager)QMApplicationContext.sharedInstance().getSystemService("sensor"));
    if (this.sensorManager == null) {
      this.hasSensor = false;
    }
    this.lightSensor = this.sensorManager.getDefaultSensor(5);
    if (this.lightSensor == null) {
      this.hasSensor = false;
    }
    if (!this.hasSensor) {
      this.brightnessVal.setText("当前设备不支持检测亮度");
    }
    this.sensorManager.registerListener(this, this.lightSensor, 3);
    Log.i(TAG, "registerListener");
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      float f = paramSensorEvent.values[0];
      Log.i(TAG, "brightnessNum = " + f + "");
      this.brightnessVal.setText("亮度： " + f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.BrightnessDialog
 * JD-Core Version:    0.7.0.1
 */