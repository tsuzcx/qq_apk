package com.tencent.mobileqq.activity.aio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import bsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;

public class AIOInputTypeHelper
{
  public static final int a = 3;
  public static final String a = "aio_input_helper";
  public static boolean a = false;
  public static int b = 0;
  public static final String b = "open_times";
  public static boolean b = false;
  public static final String c = "input_type_changed";
  private static boolean c = false;
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        boolean bool2 = c;
        if (bool2) {
          return;
        }
        paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("aio_input_helper" + paramQQAppInterface.getAccount(), 0);
        jdField_b_of_type_Int = paramQQAppInterface.getInt("open_times", 0);
        jdField_b_of_type_Boolean = paramQQAppInterface.getBoolean("input_type_changed", false);
        if (jdField_b_of_type_Int <= 3)
        {
          a = bool1;
          c = true;
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 22	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:c	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokestatic 71	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   13: aload_0
    //   14: ifnull +74 -> 88
    //   17: iload_1
    //   18: ifeq +70 -> 88
    //   21: getstatic 60	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:jdField_b_of_type_Int	I
    //   24: iconst_3
    //   25: if_icmplt +63 -> 88
    //   28: iconst_1
    //   29: putstatic 66	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:jdField_b_of_type_Boolean	Z
    //   32: aload_0
    //   33: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: new 34	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   43: ldc 10
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 43	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   52: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: iconst_0
    //   59: invokevirtual 52	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: astore_0
    //   63: invokestatic 76	com/tencent/util/VersionUtils:c	()Z
    //   66: ifeq +26 -> 92
    //   69: aload_0
    //   70: invokeinterface 80 1 0
    //   75: ldc 18
    //   77: iconst_1
    //   78: invokeinterface 86 3 0
    //   83: invokeinterface 89 1 0
    //   88: ldc 2
    //   90: monitorexit
    //   91: return
    //   92: invokestatic 94	com/tencent/mobileqq/app/ThreadManager:a	()Landroid/os/Handler;
    //   95: new 96	bsq
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 99	bsq:<init>	(Landroid/content/SharedPreferences;)V
    //   103: invokevirtual 105	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   106: pop
    //   107: goto -19 -> 88
    //   110: astore_0
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramQQAppInterface	QQAppInterface
    //   0	116	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	13	110	finally
    //   21	88	110	finally
    //   92	107	110	finally
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!c) {
          a(paramQQAppInterface);
        }
        jdField_b_of_type_Int += 1;
        if (jdField_b_of_type_Int <= 3) {
          bool = true;
        }
        a = bool;
        if (paramQQAppInterface != null)
        {
          int i = jdField_b_of_type_Int;
          if (i <= 4) {}
        }
        else
        {
          return;
        }
        paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("aio_input_helper" + paramQQAppInterface.getAccount(), 0);
        if (VersionUtils.c()) {
          paramQQAppInterface.edit().putInt("open_times", jdField_b_of_type_Int).apply();
        } else {
          ThreadManager.a().post(new bsp(paramQQAppInterface));
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOInputTypeHelper
 * JD-Core Version:    0.7.0.1
 */