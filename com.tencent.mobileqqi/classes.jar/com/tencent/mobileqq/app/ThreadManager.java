package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import fhb;
import fhd;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ThreadManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static Timer jdField_a_of_type_JavaUtilTimer;
  public static final Executor a;
  public static final boolean a = false;
  private static Handler jdField_b_of_type_AndroidOsHandler;
  private static HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private static Handler c;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutor = b();
  }
  
  public static Handler a()
  {
    if (jdField_b_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_FILE_RW");
      jdField_b_of_type_AndroidOsHandlerThread.start();
      jdField_b_of_type_AndroidOsHandler = new Handler(jdField_b_of_type_AndroidOsHandlerThread.getLooper());
      return jdField_b_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static Looper a()
  {
    return a().getLooper();
  }
  
  public static Thread a()
  {
    if (jdField_a_of_type_AndroidOsHandlerThread == null) {
      b();
    }
    return jdField_a_of_type_AndroidOsHandlerThread;
  }
  
  public static Timer a()
  {
    if (jdField_a_of_type_JavaUtilTimer == null) {}
    try
    {
      jdField_a_of_type_JavaUtilTimer = new fhb("QQ_Timer");
      return jdField_a_of_type_JavaUtilTimer;
    }
    finally {}
  }
  
  public static Executor a()
  {
    return new fhd(null);
  }
  
  public static void a() {}
  
  public static void a(Runnable paramRunnable)
  {
    jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramRunnable);
  }
  
  public static Handler b()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_SUB");
      jdField_a_of_type_AndroidOsHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return jdField_a_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static Looper b()
  {
    return b().getLooper();
  }
  
  @TargetApi(11)
  private static Executor b()
  {
    Object localObject;
    if (VersionUtils.e()) {
      localObject = AsyncTask.THREAD_POOL_EXECUTOR;
    }
    for (;;)
    {
      if ((localObject instanceof ThreadPoolExecutor)) {
        ((ThreadPoolExecutor)localObject).setCorePoolSize(3);
      }
      return localObject;
      try
      {
        localObject = AsyncTask.class.getDeclaredField("sExecutor");
        ((Field)localObject).setAccessible(true);
        localObject = (Executor)((Field)localObject).get(null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ThreadManager", 1, localException.getMessage(), localException);
          ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
      }
    }
  }
  
  public static void b(Runnable paramRunnable)
  {
    b().post(paramRunnable);
  }
  
  public static Handler c()
  {
    if (c == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("Msg_Handler");
      localHandlerThread.start();
      c = new Handler(localHandlerThread.getLooper());
      return c;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager
 * JD-Core Version:    0.7.0.1
 */