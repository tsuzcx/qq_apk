package com.tencent.mobileqq.bgprobe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class BackgroundService
  extends Service
{
  private long VI;
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.VI = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("BackgroundService", 2, "onCreate: invoked.  mCreateTimeMs: " + this.VI);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    long l = (System.currentTimeMillis() - this.VI) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.i("BackgroundService", 2, "onDestroy: invoked.  durationSecond: " + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bgprobe.BackgroundService
 * JD-Core Version:    0.7.0.1
 */