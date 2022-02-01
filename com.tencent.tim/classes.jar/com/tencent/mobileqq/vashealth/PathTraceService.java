package com.tencent.mobileqq.vashealth;

import acfp;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;

public class PathTraceService
  extends Service
{
  public static String PARAM_STATUS = "status";
  static PathTraceService jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService;
  public static String cxc = "com.tencent.mobileqq.vashealth.PathTraceService.update";
  public static String cxd = "time";
  public static String cxe = "distance";
  private RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews;
  private UpdateRunDataBroadCastReceiver jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver;
  private QQNotificationManager e;
  private NotificationCompat.Builder mBuilder;
  private Notification mNotification;
  
  /* Error */
  public static void efA()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 69	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: astore_0
    //   7: new 71	android/content/Intent
    //   10: dup
    //   11: aload_0
    //   12: ldc 2
    //   14: invokespecial 74	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 80	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   23: pop
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -8 -> 24
    //   35: ldc 88
    //   37: iconst_2
    //   38: ldc 90
    //   40: aload_0
    //   41: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   44: goto -20 -> 24
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	13	0	localBaseApplicationImpl	com.tencent.common.app.BaseApplicationImpl
    //   28	13	0	localThrowable	Throwable
    //   47	5	0	localObject	java.lang.Object
    //   17	3	1	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   18	24	28	java/lang/Throwable
    //   3	18	47	finally
    //   18	24	47	finally
    //   29	44	47	finally
  }
  
  /* Error */
  public static void efB()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 71	android/content/Intent
    //   6: dup
    //   7: getstatic 69	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: ldc 2
    //   12: invokespecial 74	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   15: astore_0
    //   16: invokestatic 99	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: invokevirtual 105	com/tencent/qphone/base/util/BaseApplication:stopService	(Landroid/content/Intent;)Z
    //   23: pop
    //   24: ldc 88
    //   26: iconst_1
    //   27: ldc 107
    //   29: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq -16 -> 24
    //   43: ldc 88
    //   45: iconst_2
    //   46: ldc 90
    //   48: aload_0
    //   49: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   52: goto -28 -> 24
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	5	0	localIntent	Intent
    //   36	13	0	localThrowable	Throwable
    //   55	5	0	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   16	24	36	java/lang/Throwable
    //   3	16	55	finally
    //   16	24	55	finally
    //   24	32	55	finally
    //   37	52	55	finally
  }
  
  public Notification a(Context paramContext, PendingIntent paramPendingIntent)
  {
    this.mBuilder = new NotificationCompat.Builder(paramContext);
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(paramContext.getPackageName(), 2131559714);
    this.mBuilder.setContentIntent(paramPendingIntent);
    this.mBuilder.setContentTitle("QQ运动");
    this.mBuilder.setSmallIcon(2130838449);
    try
    {
      paramContext = BitmapFactory.decodeResource(getResources(), 2130838449);
      if (paramContext != null) {
        this.mBuilder.setLargeIcon(paramContext);
      }
      this.mBuilder.setOngoing(true);
      this.mBuilder.setContent(this.jdField_a_of_type_AndroidWidgetRemoteViews);
      this.mBuilder.setContentIntent(paramPendingIntent);
      this.mNotification = this.mBuilder.build();
      return this.mNotification;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PathTraceManager.Service", 2, "Exception:" + paramContext.toString());
        }
        paramContext = null;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService = this;
    QLog.d("PathTraceManager.Service", 1, "onCreate");
    stopTempService();
    if (Build.VERSION.SDK_INT < 18) {
      super.startForeground(237, new Notification());
    }
    while (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    Intent localIntent = new Intent(this, KernelService.class);
    try
    {
      startService(localIntent);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onDestroy()
  {
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    }
    for (;;)
    {
      super.onDestroy();
      jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService = null;
      return;
      stopTempService();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {
      super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (Build.VERSION.SDK_INT >= 25)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver = new UpdateRunDataBroadCastReceiver();
        paramIntent = new IntentFilter(cxc);
        registerReceiver(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver, paramIntent);
      }
      this.e = QQNotificationManager.getInstance();
      paramIntent = new Intent(this, SplashActivity.class);
      paramIntent.putExtra("param_notifyid", 237);
      super.startForeground(237, a(this, PendingIntent.getActivity(this, 1, paramIntent, 268435456)));
    }
    return 2;
  }
  
  void stopTempService()
  {
    Intent localIntent = new Intent(this, KernelService.class);
    try
    {
      stopService(localIntent);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static class KernelService
    extends Service
  {
    private Notification a()
    {
      Notification localNotification = new Notification();
      localNotification.icon = 2130840732;
      localNotification.contentView = new RemoteViews(PathTraceService.a.getApplication().getPackageName(), 2131559856);
      startForeground(1, localNotification);
      return localNotification;
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager.Service", 2, "KernelService.onCreate");
      }
    }
    
    public void onDestroy()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager.Service", 2, "KernelService.onDestroy");
      }
      try
      {
        super.stopForeground(true);
        super.onDestroy();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PathTraceManager.Service", 2, "destory failed");
          }
        }
      }
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      if ((paramIntent != null) && (PathTraceService.a != null)) {
        if (QLog.isColorLevel()) {
          QLog.d("PathTraceManager.Service", 2, "onStartCommand:");
        }
      }
      try
      {
        QLog.d("PathTraceManager.Service", 1, "PathTraceService startForeground");
        PathTraceService.a.startForeground(237, a());
        super.startForeground(237, a());
        super.stopForeground(true);
        return 2;
      }
      catch (Exception paramIntent)
      {
        QLog.d("PathTraceManager.Service", 1, "", paramIntent);
      }
      return 2;
    }
  }
  
  public class UpdateRunDataBroadCastReceiver
    extends BroadcastReceiver
  {
    public UpdateRunDataBroadCastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      QLog.i("PathTraceManager.Service", 1, "onReceive");
      int i = paramIntent.getIntExtra(PathTraceService.PARAM_STATUS, 0);
      long l = paramIntent.getLongExtra(PathTraceService.cxd, 0L);
      double d = paramIntent.getDoubleExtra(PathTraceService.cxe, 0.0D);
      if (i == 1) {
        PathTraceService.a(PathTraceService.this).setTextViewText(2131372536, acfp.m(2131709412));
      }
      PathTraceService.a(PathTraceService.this).setChronometer(2131372537, SystemClock.elapsedRealtime() - l * 1000L, null, false);
      paramContext = new DecimalFormat("######0.00");
      PathTraceService.a(PathTraceService.this).setTextViewText(2131372535, paramContext.format(d / 1000.0D) + "km");
      try
      {
        PathTraceService.a(PathTraceService.this, PathTraceService.a(PathTraceService.this).build());
        PathTraceService.a(PathTraceService.this).notify("PathTraceManager.Service", 237, PathTraceService.a(PathTraceService.this));
        return;
      }
      catch (Throwable paramContext)
      {
        QLog.e("PathTraceManager.Service", 1, "[update] err in notify");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceService
 * JD-Core Version:    0.7.0.1
 */