package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class SensorJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ACCELEROMETER_STATE_CHANGE = "onAccelerometerChange";
  public static final String EVENT_COMPASS_STATE_CHANGE = "onCompassChange";
  public static final String EVENT_DEVICE_MOTION_STATE_CHANGE = "onDeviceMotionChange";
  public static final String EVENT_GYROSCOPE_STATE_CHANGE = "onGyroscopeChange";
  private static final String TAG = "SensorJsPlugin";
  private Sensor gyroscopeSensor;
  private GyroscopeSensorJsPlugin gyroscopeSensorJsPlugin;
  private boolean hasEnableDeviceMotionChangeListening = false;
  private boolean hasEnableGyroscope = false;
  private boolean mIsGetCompass = false;
  private Sensor magneticSensor;
  private MiniAppSensorJsPlugin miniAppSensorJsPlugin;
  private Sensor orientationSensor;
  private RotationSensorJsPlugin orientationSensorJsPlugin;
  private Sensor senAccelerometer;
  private SensorManager senSensorManager;
  private Vibrator vibrator;
  
  private void doVibrate(long paramLong)
  {
    try
    {
      if (this.vibrator != null) {
        this.vibrator.vibrate(paramLong);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("SensorJsPlugin", "exception when doVibrate.", localThrowable);
    }
  }
  
  private void initSensor()
  {
    if (this.senSensorManager == null)
    {
      this.senSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
      this.magneticSensor = this.senSensorManager.getDefaultSensor(2);
      this.gyroscopeSensor = this.senSensorManager.getDefaultSensor(4);
      this.orientationSensor = this.senSensorManager.getDefaultSensor(3);
    }
    if (this.vibrator == null) {
      this.vibrator = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    if (this.senAccelerometer == null)
    {
      List localList = this.senSensorManager.getSensorList(1);
      if (localList.size() > 0) {
        this.senAccelerometer = ((Sensor)localList.get(0));
      }
    }
  }
  
  @JsEvent({"enableAccelerometer"})
  public String enableAccelerometer(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.1(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"enableCompass"})
  public String enableCompass(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.2(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"enableDeviceMotionChangeListening"})
  public String enableDeviceMotionChangeListening(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.4(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"enableGyroscope"})
  public String enableGyroscope(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.3(this, paramRequestEvent));
    return "";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
  }
  
  public final boolean startAccelerometer(IJsService paramIJsService, int paramInt)
  {
    if (this.senSensorManager == null) {}
    while (this.senAccelerometer == null) {
      return false;
    }
    if (this.miniAppSensorJsPlugin != null) {
      stopAccelerometer();
    }
    this.miniAppSensorJsPlugin = new MiniAppSensorJsPlugin(null);
    this.senSensorManager.registerListener(this.miniAppSensorJsPlugin, this.senAccelerometer, paramInt);
    this.senSensorManager.registerListener(this.miniAppSensorJsPlugin, this.magneticSensor, paramInt);
    this.senSensorManager.registerListener(this.miniAppSensorJsPlugin, this.gyroscopeSensor, paramInt);
    return true;
  }
  
  public final boolean startGyroscope(IJsService paramIJsService, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.gyroscopeSensor == null)) {
      return false;
    }
    if (this.gyroscopeSensorJsPlugin != null) {
      stopGyroscope();
    }
    this.gyroscopeSensorJsPlugin = new GyroscopeSensorJsPlugin(null);
    this.senSensorManager.registerListener(this.gyroscopeSensorJsPlugin, this.gyroscopeSensor, paramInt);
    return true;
  }
  
  public final boolean startRotationListening(IJsService paramIJsService, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.orientationSensor == null)) {
      return false;
    }
    if (this.orientationSensorJsPlugin != null) {
      stopRotationListening();
    }
    this.orientationSensorJsPlugin = new RotationSensorJsPlugin(null);
    this.orientationSensorJsPlugin.setJsService(paramIJsService);
    this.senSensorManager.registerListener(this.orientationSensorJsPlugin, this.orientationSensor, paramInt);
    return true;
  }
  
  public final void stopAccelerometer()
  {
    if ((this.senSensorManager != null) && (this.miniAppSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.miniAppSensorJsPlugin);
      this.miniAppSensorJsPlugin = null;
    }
  }
  
  public final void stopGyroscope()
  {
    if ((this.senSensorManager != null) && (this.gyroscopeSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.gyroscopeSensorJsPlugin);
      this.gyroscopeSensorJsPlugin = null;
    }
  }
  
  public final void stopRotationListening()
  {
    if ((this.senSensorManager != null) && (this.orientationSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.orientationSensorJsPlugin);
      this.orientationSensorJsPlugin = null;
    }
  }
  
  @JsEvent({"vibrateLong"})
  public String vibrateLong(RequestEvent paramRequestEvent)
  {
    initSensor();
    ThreadManager.executeOnComputationThreadPool(new SensorJsPlugin.6(this));
    paramRequestEvent.ok();
    return "";
  }
  
  @JsEvent({"vibrateShort"})
  public String vibrateShort(RequestEvent paramRequestEvent)
  {
    initSensor();
    ThreadManager.executeOnComputationThreadPool(new SensorJsPlugin.5(this));
    paramRequestEvent.ok();
    return "";
  }
  
  class GyroscopeSensorJsPlugin
    implements SensorEventListener
  {
    private final float NS2S = 1.0E-009F;
    private float[] angle = new float[3];
    private float timestamp;
    
    private GyroscopeSensorJsPlugin() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      float f1;
      Object localObject;
      float f2;
      float f3;
      if (paramSensorEvent.sensor.getType() == 4) {
        if (this.timestamp != 0.0F)
        {
          f1 = ((float)paramSensorEvent.timestamp - this.timestamp) * 1.0E-009F;
          localObject = this.angle;
          localObject[0] += paramSensorEvent.values[0] * f1;
          localObject = this.angle;
          localObject[1] += paramSensorEvent.values[1] * f1;
          localObject = this.angle;
          f2 = localObject[2];
          localObject[2] = (f1 * paramSensorEvent.values[2] + f2);
          f1 = (float)Math.toDegrees(this.angle[0]);
          f2 = (float)Math.toDegrees(this.angle[1]);
          f3 = (float)Math.toDegrees(this.angle[2]);
        }
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("x", f1);
        ((JSONObject)localObject).put("y", f2);
        ((JSONObject)localObject).put("z", f3);
        SensorJsPlugin.this.sendSubscribeEvent("onGyroscopeChange", ((JSONObject)localObject).toString());
        this.timestamp = ((float)paramSensorEvent.timestamp);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  class MiniAppSensorJsPlugin
    implements SensorEventListener
  {
    final float COEFFICENT = 10.0F;
    int accuracy = -1;
    private float[] mAccelerometerValues = new float[3];
    private float[] mMagneticFieldValues = new float[3];
    private float[] mMatrix = new float[9];
    private float[] mValues = new float[3];
    
    private MiniAppSensorJsPlugin() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt)
    {
      this.accuracy = paramInt;
    }
    
    public void onCompass(SensorEvent paramSensorEvent)
    {
      if (!SensorJsPlugin.this.mIsGetCompass) {
        return;
      }
      if (paramSensorEvent.sensor.getType() == 1) {
        this.mAccelerometerValues = paramSensorEvent.values;
      }
      if (paramSensorEvent.sensor.getType() == 2) {
        this.mMagneticFieldValues = paramSensorEvent.values;
      }
      SensorManager.getRotationMatrix(this.mMatrix, null, this.mAccelerometerValues, this.mMagneticFieldValues);
      SensorManager.getOrientation(this.mMatrix, this.mValues);
      float f = (float)Math.toDegrees(this.mValues[0]);
      paramSensorEvent = "unknow ${" + this.accuracy + "}";
      switch (this.accuracy)
      {
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("direction", f);
          localJSONObject.put("accuracy", paramSensorEvent);
          SensorJsPlugin.this.sendSubscribeEvent("onCompassChange", localJSONObject.toString());
          return;
        }
        catch (JSONException paramSensorEvent)
        {
          paramSensorEvent.printStackTrace();
          return;
        }
        paramSensorEvent = "high";
        continue;
        paramSensorEvent = "low";
        continue;
        paramSensorEvent = "medium";
        continue;
        paramSensorEvent = "no-contact";
        continue;
        paramSensorEvent = "unreliable";
      }
    }
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      onCompass(paramSensorEvent);
      float[] arrayOfFloat = paramSensorEvent.values;
      switch (paramSensorEvent.sensor.getType())
      {
      case 9: 
      default: 
        return;
      }
      float f1 = -arrayOfFloat[0] / 10.0F;
      float f2 = -arrayOfFloat[1] / 10.0F;
      float f3 = -arrayOfFloat[2] / 10.0F;
      try
      {
        paramSensorEvent = new JSONObject();
        paramSensorEvent.put("x", f1);
        paramSensorEvent.put("y", f2);
        paramSensorEvent.put("z", f3);
        SensorJsPlugin.this.sendSubscribeEvent("onAccelerometerChange", paramSensorEvent.toString());
        return;
      }
      catch (JSONException paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
      }
    }
  }
  
  class RotationSensorJsPlugin
    implements SensorEventListener
  {
    private IJsService jsService;
    
    private RotationSensorJsPlugin() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() == 3) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("alpha", paramSensorEvent.values[0]);
        localJSONObject.put("beta", paramSensorEvent.values[1]);
        localJSONObject.put("gamma", paramSensorEvent.values[2]);
        if (this.jsService != null) {
          this.jsService.evaluateSubscribeJS("onDeviceMotionChange", localJSONObject.toString(), 0);
        }
        return;
      }
      catch (JSONException paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
      }
    }
    
    public void setJsService(IJsService paramIJsService)
    {
      this.jsService = paramIJsService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */