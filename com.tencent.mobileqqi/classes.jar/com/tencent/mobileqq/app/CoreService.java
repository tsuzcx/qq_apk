package com.tencent.mobileqq.app;

import android.app.Notification;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class CoreService
  extends AppService
{
  static final int jdField_a_of_type_Int = 4587;
  static CoreService jdField_a_of_type_ComTencentMobileqqAppCoreService = null;
  private static final String jdField_a_of_type_JavaLangString = "GuardManager";
  static boolean b;
  boolean jdField_a_of_type_Boolean;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/tencent/mobileqq/app/CoreService:b	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 25	com/tencent/mobileqq/app/CoreService:b	Z
    //   19: new 27	android/content/Intent
    //   22: dup
    //   23: invokestatic 33	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   26: ldc 2
    //   28: invokespecial 36	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   31: astore_1
    //   32: invokestatic 33	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   35: aload_1
    //   36: invokevirtual 42	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   39: pop
    //   40: goto -29 -> 11
    //   43: astore_1
    //   44: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq -36 -> 11
    //   50: ldc 11
    //   52: iconst_2
    //   53: ldc 50
    //   55: aload_1
    //   56: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: goto -48 -> 11
    //   62: astore_1
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   31	5	1	localIntent	Intent
    //   43	13	1	localThrowable	Throwable
    //   62	5	1	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	40	43	java/lang/Throwable
    //   3	7	62	finally
    //   15	32	62	finally
    //   32	40	62	finally
    //   44	59	62	finally
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/tencent/mobileqq/app/CoreService:b	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_0
    //   16: putstatic 25	com/tencent/mobileqq/app/CoreService:b	Z
    //   19: new 27	android/content/Intent
    //   22: dup
    //   23: invokestatic 33	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   26: ldc 2
    //   28: invokespecial 36	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   31: astore_1
    //   32: invokestatic 33	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   35: aload_1
    //   36: invokevirtual 58	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   39: pop
    //   40: getstatic 63	android/os/Build$VERSION:SDK_INT	I
    //   43: bipush 18
    //   45: if_icmplt -34 -> 11
    //   48: new 27	android/content/Intent
    //   51: dup
    //   52: invokestatic 33	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   55: ldc 65
    //   57: invokespecial 36	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   60: astore_1
    //   61: invokestatic 33	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   64: aload_1
    //   65: invokevirtual 58	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   68: pop
    //   69: goto -58 -> 11
    //   72: astore_1
    //   73: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq -65 -> 11
    //   79: ldc 11
    //   81: iconst_2
    //   82: ldc 50
    //   84: aload_1
    //   85: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: goto -77 -> 11
    //   91: astore_1
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq -61 -> 40
    //   104: ldc 11
    //   106: iconst_2
    //   107: ldc 50
    //   109: aload_1
    //   110: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: goto -73 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   31	34	1	localIntent	Intent
    //   72	13	1	localThrowable1	Throwable
    //   91	5	1	localObject	java.lang.Object
    //   97	13	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   61	69	72	java/lang/Throwable
    //   3	7	91	finally
    //   15	32	91	finally
    //   32	40	91	finally
    //   40	61	91	finally
    //   61	69	91	finally
    //   73	88	91	finally
    //   98	113	91	finally
    //   32	40	97	java/lang/Throwable
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "GCoreService.startForegroundCompat: " + Build.VERSION.SDK_INT);
        }
        if (Build.VERSION.SDK_INT < 18)
        {
          startForeground(4587, new Notification());
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        Intent localIntent = new Intent(BaseApplicationImpl.getContext(), CoreService.KernelService.class);
        localIntent.putExtra("NotificationID", 4587);
        try
        {
          BaseApplicationImpl.a().startService(localIntent);
          return;
        }
        catch (Throwable localThrowable) {}
        if (QLog.isColorLevel())
        {
          QLog.d("GuardManager", 2, "startForegroundCompat", localThrowable);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "CoreService.stopForegroundCompat: " + Build.VERSION.SDK_INT);
        }
        if (Build.VERSION.SDK_INT < 18)
        {
          this.jdField_a_of_type_Boolean = false;
          stopForeground(true);
          return;
        }
      }
      catch (Exception localException) {}
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
      QLog.d("GuardManager", 2, "CoreService.onCreate");
    }
    super.onCreate();
    this.app = null;
    c();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "CoreService.onDestroy");
    }
    d();
    super.onDestroy();
    jdField_a_of_type_ComTencentMobileqqAppCoreService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CoreService
 * JD-Core Version:    0.7.0.1
 */