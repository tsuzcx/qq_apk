package com.tencent.mobileqq.app;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

public class CoreService
  extends Service
{
  static final int jdField_a_of_type_Int = AppSetting.jdField_a_of_type_Int;
  static CoreService jdField_a_of_type_ComTencentMobileqqAppCoreService = null;
  private static final String jdField_a_of_type_JavaLangString = "GuardManager";
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: astore_0
    //   7: new 32	android/content/Intent
    //   10: dup
    //   11: aload_0
    //   12: ldc 2
    //   14: invokespecial 35	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 41	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   23: pop
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -8 -> 24
    //   35: ldc 10
    //   37: iconst_2
    //   38: ldc 49
    //   40: aload_0
    //   41: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   44: goto -20 -> 24
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	13	0	localBaseApplicationImpl	BaseApplicationImpl
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
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 32	android/content/Intent
    //   6: dup
    //   7: getstatic 30	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: ldc 2
    //   12: invokespecial 35	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   15: astore_0
    //   16: invokestatic 58	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   19: aload_0
    //   20: invokevirtual 62	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   23: pop
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -8 -> 24
    //   35: ldc 10
    //   37: iconst_2
    //   38: ldc 49
    //   40: aload_0
    //   41: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   44: goto -20 -> 24
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	5	0	localIntent	Intent
    //   28	13	0	localThrowable	Throwable
    //   47	5	0	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   16	24	28	java/lang/Throwable
    //   3	16	47	finally
    //   16	24	47	finally
    //   29	44	47	finally
  }
  
  public static void c()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.a, CoreService.KernelService.class);
    try
    {
      BaseApplicationImpl.getContext().startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GuardManager", 2, "", localThrowable);
    }
  }
  
  public static void d()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.a, CoreService.KernelService.class);
    try
    {
      BaseApplicationImpl.getContext().stopService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GuardManager", 2, "", localThrowable);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    jdField_a_of_type_ComTencentMobileqqAppCoreService = this;
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "CoreService.onCreate " + Build.VERSION.SDK_INT);
    }
    super.onCreate();
    BaseApplicationImpl.a.onActivityCreate(this, null);
    d();
    if (Build.VERSION.SDK_INT < 18) {
      super.startForeground(jdField_a_of_type_Int, new Notification());
    }
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), CoreService.KernelService.class);
      try
      {
        BaseApplicationImpl.a().startService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("GuardManager", 2, "", localThrowable);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "CoreService.onDestroy");
    }
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    }
    for (;;)
    {
      super.onDestroy();
      jdField_a_of_type_ComTencentMobileqqAppCoreService = null;
      return;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CoreService
 * JD-Core Version:    0.7.0.1
 */