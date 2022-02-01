package com.tencent.mobileqq.studyroom;

import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;

public class QTProxyService
  extends PluginProcessService
{
  private PpsController a;
  private long anZ;
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = super.onBind(paramIntent);
    this.a = wrapBinder(paramIntent);
    return paramIntent;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.anZ = SystemClock.elapsedRealtime();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {}
    try
    {
      this.a.exit();
      label18:
      this.a = null;
      Process.killProcess(Process.myPid());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label18;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (SystemClock.elapsedRealtime() - this.anZ < 1000L)
    {
      QLog.i("studyroom.QTProxyService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
      return;
    }
    QLog.i("studyroom.QTProxyService", 2, "onTaskRemoved");
    if (this.a != null) {
      try
      {
        this.a.exit();
        return;
      }
      catch (RemoteException paramIntent)
      {
        return;
      }
    }
    QLog.i("studyroom.QTProxyService", 2, "ppsController null System.exit");
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.QTProxyService
 * JD-Core Version:    0.7.0.1
 */