package com.tencent.av.utils;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import jla;

public final class SensorReport$2
  implements Runnable
{
  public SensorReport$2(Context paramContext, IntentFilter paramIntentFilter) {}
  
  public void run()
  {
    try
    {
      this.val$context.registerReceiver(jla.a(), this.d);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SensorReport", 2, "registonUserActionReceiver e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.SensorReport.2
 * JD-Core Version:    0.7.0.1
 */