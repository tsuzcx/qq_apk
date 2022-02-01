package com.tencent.mobileqq.webprocess;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class WebCoreService
  extends Service
{
  private static final int NOTIFICATION_ID = ;
  private static WebCoreService a;
  public static boolean isRunning;
  
  /* Error */
  public static void egq()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 40	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: astore_0
    //   7: new 42	android/content/Intent
    //   10: dup
    //   11: aload_0
    //   12: ldc 2
    //   14: invokespecial 45	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 51	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   23: pop
    //   24: iconst_1
    //   25: putstatic 53	com/tencent/mobileqq/webprocess/WebCoreService:isRunning	Z
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -8 -> 28
    //   39: ldc 61
    //   41: iconst_2
    //   42: ldc 63
    //   44: aload_0
    //   45: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto -20 -> 28
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	13	0	localBaseApplicationImpl	BaseApplicationImpl
    //   32	13	0	localThrowable	Throwable
    //   51	5	0	localObject	java.lang.Object
    //   17	3	1	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   18	28	32	java/lang/Throwable
    //   3	18	51	finally
    //   18	28	51	finally
    //   33	48	51	finally
  }
  
  /* Error */
  public static void egr()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 42	android/content/Intent
    //   6: dup
    //   7: getstatic 40	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: ldc 2
    //   12: invokespecial 45	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   15: astore_0
    //   16: invokestatic 72	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: invokevirtual 78	com/tencent/qphone/base/util/BaseApplication:stopService	(Landroid/content/Intent;)Z
    //   23: pop
    //   24: iconst_0
    //   25: putstatic 53	com/tencent/mobileqq/webprocess/WebCoreService:isRunning	Z
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -8 -> 28
    //   39: ldc 61
    //   41: iconst_2
    //   42: ldc 63
    //   44: aload_0
    //   45: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto -20 -> 28
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	5	0	localIntent	Intent
    //   32	13	0	localThrowable	Throwable
    //   51	5	0	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   16	28	32	java/lang/Throwable
    //   3	16	51	finally
    //   16	28	51	finally
    //   33	48	51	finally
  }
  
  public static void startTempService()
  {
    if (Build.VERSION.SDK_INT >= 25) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication, KernelService.class);
      try
      {
        BaseApplicationImpl.getContext().startService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("WebCoreService", 2, "", localThrowable);
  }
  
  public static void stopTempService()
  {
    if (Build.VERSION.SDK_INT >= 25) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication, KernelService.class);
      try
      {
        BaseApplicationImpl.getContext().stopService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("WebCoreService", 2, "", localThrowable);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    a = this;
    if (QLog.isColorLevel()) {
      QLog.d("WebCoreService", 2, "WebCoreService.onCreate " + Build.VERSION.SDK_INT);
    }
    super.onCreate();
    stopTempService();
    if (Build.VERSION.SDK_INT < 18) {
      super.startForeground(NOTIFICATION_ID, new Notification());
    }
    while (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    startTempService();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebCoreService", 2, "WebCoreService.onDestroy");
    }
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    }
    for (;;)
    {
      super.onDestroy();
      a = null;
      return;
      stopTempService();
    }
  }
  
  public static class KernelService
    extends Service
  {
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreService", 2, "KernelService.onCreate");
      }
    }
    
    public void onDestroy()
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreService", 2, "KernelService.onDestroy");
      }
      try
      {
        super.stopForeground(true);
        label19:
        super.onDestroy();
        return;
      }
      catch (Exception localException)
      {
        break label19;
      }
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      if ((paramIntent != null) && (WebCoreService.a() != null)) {
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreService", 2, "KernelService.onStartCommand");
        }
      }
      try
      {
        WebCoreService.a().startForeground(WebCoreService.NOTIFICATION_ID, CoreService.fakeNotification(true));
        super.startForeground(WebCoreService.NOTIFICATION_ID, CoreService.fakeNotification(false));
        WebCoreService.a().stopForeground(true);
        return 2;
      }
      catch (Exception paramIntent)
      {
        QLog.d("WebCoreService", 1, "", paramIntent);
      }
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebCoreService
 * JD-Core Version:    0.7.0.1
 */