package com.tencent.proxyinner.plugin.loader;

import aifl;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.MultiLoaderPluginProcessService;
import com.tencent.shadow.dynamic.host.MultiLoaderPpsController;

public class PluginToolProcessService
  extends MultiLoaderPluginProcessService
{
  private MultiLoaderPpsController a;
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
    aifl.dsq();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Process.killProcess(Process.myPid());
    if (this.a != null) {}
    try
    {
      this.a.exit();
      label24:
      this.a = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label24;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (SystemClock.elapsedRealtime() - this.anZ < 1000L)
    {
      QLog.i("QTProxyService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
      return;
    }
    QLog.i("QTProxyService", 2, "onTaskRemoved");
    if (this.a != null) {
      try
      {
        this.a.exit();
        return;
      }
      catch (RemoteException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
    }
    QLog.i("QTProxyService", 2, "ppsController null System.exit");
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.loader.PluginToolProcessService
 * JD-Core Version:    0.7.0.1
 */