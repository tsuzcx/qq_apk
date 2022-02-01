package com.tencent.mobileqq.msf.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class ah
  implements SensorEventListener2
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onFlushCompleted(Sensor paramSensor)
  {
    if ((paramSensor != null) && (paramSensor.getType() == 19))
    {
      QLog.i("health_manager", 1, "onFlushCompleted.");
      if ((ac.H > ac.X) && (ac.H - ac.X < ac.U)) {
        ac.X = ac.H;
      }
      ac.a(false, null, null);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length <= 0) || (paramSensorEvent.values[0] == 0.0F) || (paramSensorEvent.values[0] > ac.T)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!ac.Z.get())
          {
            ac.I = (int)paramSensorEvent.values[0];
            return;
          }
          if (paramSensorEvent.values[0] >= ac.X) {
            break;
          }
          ac.R += 1;
        } while (ac.R <= 2);
        if ((ac.ad != null) && (ac.ad.has("shut_down")) && (ac.ad.optLong("shut_down") == ac.f()) && (paramSensorEvent.values[0] < ac.U))
        {
          ac.ad.remove("shut_down");
          ac.X = (int)paramSensorEvent.values[0];
          ac.W = 1;
          QLog.i("health_manager", 1, "reset from shut down");
          ac.H = (int)paramSensorEvent.values[0];
          ac.ab = NetConnInfoCenter.getServerTimeMillis();
          QLog.i("health_manager", 1, "step counter exception reset: init = " + ac.W + ",total = " + ac.X + ",offset = " + ac.Y);
          ac.a(false, null, null);
          ac.R = 0;
          ac.J = System.currentTimeMillis();
          return;
        }
        ac.Y = ac.X - ac.W + ac.Y;
        ac.X = (int)paramSensorEvent.values[0];
        if (ac.X < 1000) {}
        for (i = 1;; i = ac.X - 3)
        {
          ac.W = i;
          break;
        }
        ac.R = 0;
        if ((ac.H == 0) || (paramSensorEvent.values[0] - ac.H <= ac.U)) {
          break;
        }
        ac.S += 1;
      } while (ac.S <= 4);
      if (ac.X - ac.W > 0) {}
      for (int i = ac.X - ac.W;; i = 0)
      {
        ac.Y = i + ac.Y;
        ac.W = (int)paramSensorEvent.values[0] - 5;
        ac.X = (int)paramSensorEvent.values[0];
        ac.H = (int)paramSensorEvent.values[0];
        ac.ab = NetConnInfoCenter.getServerTimeMillis();
        ac.ae.set(true);
        QLog.i("health_manager", 1, "Jump CallBack reset init = " + ac.W + ",total = " + ac.X + ",offset = " + ac.Y);
        ac.a(false, null, null);
        ac.S = 0;
        ac.J = System.currentTimeMillis();
        return;
      }
      ac.S = 0;
      if ((paramSensorEvent.values[0] - ac.H > ac.U) && (ac.H == 0) && (ac.W != 0))
      {
        QLog.i("health_manager", 1, "msf step counter restart!");
        if (ac.X == 0) {}
        for (i = ac.W;; i = ac.X)
        {
          ac.H = i;
          ac.ab = NetConnInfoCenter.getServerTimeMillis();
          return;
        }
      }
      ac.H = (int)paramSensorEvent.values[0];
      ac.ab = NetConnInfoCenter.getServerTimeMillis();
    } while (System.currentTimeMillis() - ac.J < 1200000L);
    ac.J = System.currentTimeMillis();
    ac.X = ac.H;
    ac.a(true, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ah
 * JD-Core Version:    0.7.0.1
 */