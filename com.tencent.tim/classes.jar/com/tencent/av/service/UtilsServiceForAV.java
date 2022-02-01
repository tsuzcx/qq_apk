package com.tencent.av.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class UtilsServiceForAV
  extends AppService
{
  VideoAppInterface c = null;
  final IBinder mBinder = new a();
  PowerManager.WakeLock mWakeLock = null;
  
  void ja(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "toggleProximityWakeLock turnOn = " + paramBoolean);
    }
    try
    {
      if (this.mWakeLock != null)
      {
        if ((paramBoolean) && (!this.mWakeLock.isHeld()))
        {
          this.mWakeLock.acquire();
          return;
        }
        this.mWakeLock.release();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("UtilsServiceForAV", 2, "Exception", localException);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.c = ((VideoAppInterface)this.app);
    }
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onCreate");
    }
    PowerManager localPowerManager = (PowerManager)getSystemService("power");
    try
    {
      this.mWakeLock = localPowerManager.newWakeLock(32, "mobileqq:serforav");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.mWakeLock != null) {
            this.mWakeLock.setReferenceCounted(false);
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("UtilsServiceForAV", 2, "Exception", localException1);
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("UtilsServiceForAV", 2, "Exception", localException2);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onDestroy");
    }
    if (this.mWakeLock != null) {
      ja(false);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onStartCommand");
    }
    if ((this.app instanceof VideoAppInterface)) {
      this.c = ((VideoAppInterface)this.app);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public class a
    extends Binder
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.UtilsServiceForAV
 * JD-Core Version:    0.7.0.1
 */