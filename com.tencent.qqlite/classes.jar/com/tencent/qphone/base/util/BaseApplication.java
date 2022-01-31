package com.tencent.qphone.base.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.util.ArrayList;

public abstract class BaseApplication
  extends Application
{
  public static int appnewavmsgicon;
  public static int appnewmsgicon = 0;
  static Context context;
  public static int defaultNotifSoundResourceId = 0;
  public static int devlockQuickloginIcon = 0;
  public static ArrayList exclusiveStreamList = new ArrayList();
  public static MonitorSocketStat monitor;
  public static int qqlaunchicon;
  
  static
  {
    appnewavmsgicon = 0;
    qqlaunchicon = 0;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public void onCreate()
  {
    super.onCreate();
    context = this;
    monitor = new MonitorSocketStat();
    Object localObject = Build.MODEL;
    if ((localObject != null) && (((String)localObject).toLowerCase().contains("coolpad")) && (((String)localObject).toLowerCase().contains("7295")))
    {
      QLog.d("MSF.D.MonitorSocket", 1, "Coolpad 7295 Donot Monitor Socket Netflow");
      return;
    }
    localObject = new MonitorSocketImplFactory();
    if (((MonitorSocketImplFactory)localObject).getMsfSocketImpl(getContext()) == true) {
      try
      {
        Socket.setSocketImplFactory((SocketImplFactory)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "set socketimpl factory failed.");
        localException.printStackTrace();
        return;
      }
    }
    QLog.d("MSF.D.MonitorSocket", 1, "get socketimpl failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.BaseApplication
 * JD-Core Version:    0.7.0.1
 */