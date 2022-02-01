package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class SensorManagerWorker
{
  private static final String TAG = "MicroMsg.LightSensor";
  private boolean mHasStarted = false;
  private LightSensorListener mLightSensorListener;
  private OnGetValue mOnGetValue;
  private SensorManager mSensorManager;
  
  public static SensorManagerWorker getInstance()
  {
    return Singleton.instance;
  }
  
  public float getLux()
  {
    if (this.mLightSensorListener != null)
    {
      Log.d("MicroMsg.LightSensor", "Light lux: " + this.mLightSensorListener.lux);
      return this.mLightSensorListener.lux;
    }
    return -1.0F;
  }
  
  public int start(Context paramContext, OnGetValue paramOnGetValue)
  {
    if (this.mHasStarted)
    {
      YTLogger.i("MicroMsg.LightSensor", "[SensorManagerWorker.start] light sensor has started");
      return 2;
    }
    this.mHasStarted = true;
    this.mSensorManager = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.mSensorManager.getDefaultSensor(5);
    if (paramContext != null)
    {
      this.mLightSensorListener = new LightSensorListener(null);
      this.mSensorManager.registerListener(this.mLightSensorListener, paramContext, 3);
      this.mOnGetValue = paramOnGetValue;
      return 0;
    }
    YTLogger.i("MicroMsg.LightSensor", "[SensorManagerWorker.start] System do not have lightSensor");
    return 1;
  }
  
  public void stop()
  {
    if ((!this.mHasStarted) || (this.mSensorManager == null)) {
      return;
    }
    this.mHasStarted = false;
    this.mSensorManager.unregisterListener(this.mLightSensorListener);
  }
  
  class LightSensorListener
    implements SensorEventListener
  {
    private float lux;
    
    private LightSensorListener() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() == 5)
      {
        this.lux = paramSensorEvent.values[0];
        if (SensorManagerWorker.this.mOnGetValue != null) {
          SensorManagerWorker.this.mOnGetValue.onGetValue(this.lux);
        }
      }
    }
  }
  
  public static abstract interface OnGetValue
  {
    public abstract void onGetValue(float paramFloat);
  }
  
  static class Singleton
  {
    private static SensorManagerWorker instance = new SensorManagerWorker(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker
 * JD-Core Version:    0.7.0.1
 */