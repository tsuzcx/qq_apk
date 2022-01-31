package com.tencent.feedback.eup.jni;

import com.tencent.feedback.common.e;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeExceptionUpload
{
  public static final int ANDROID_LOG_DEBUG = 3;
  public static final int ANDROID_LOG_ERROR = 6;
  public static final int ANDROID_LOG_INFO = 4;
  public static final int ANDROID_LOG_WARN = 5;
  public static final int JAR_JNI_VERSION = 1;
  private static AtomicBoolean a = new AtomicBoolean(false);
  private static NativeExceptionHandler b = null;
  
  protected static native void doNativeCrashForTest();
  
  protected static native void enableHandler(boolean paramBoolean);
  
  public static void enableNativeEUP(boolean paramBoolean)
  {
    if (!a.get()) {
      e.c("rqdp{  n enable disable!!}", new Object[0]);
    }
    do
    {
      return;
      try
      {
        enableHandler(paramBoolean);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (e.a(localThrowable));
    localThrowable.printStackTrace();
  }
  
  public static NativeExceptionHandler getmHandler()
  {
    try
    {
      NativeExceptionHandler localNativeExceptionHandler = b;
      return localNativeExceptionHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean loadRQDNativeLib()
  {
    boolean bool = true;
    try
    {
      System.loadLibrary("NativeRQD");
      a.set(true);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (!e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        e.d("rqdp{  load library fail! see detail ,will turn off native eup function!}", new Object[0]);
        bool = false;
      }
    }
    finally {}
  }
  
  /* Error */
  public static boolean loadRQDNativeLib(File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnull +82 -> 88
    //   9: aload_0
    //   10: invokevirtual 84	java/io/File:exists	()Z
    //   13: ifeq +75 -> 88
    //   16: aload_0
    //   17: invokevirtual 87	java/io/File:canRead	()Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq +66 -> 88
    //   25: ldc 89
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   41: pop
    //   42: aload_0
    //   43: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokestatic 98	java/lang/System:load	(Ljava/lang/String;)V
    //   49: getstatic 29	com/tencent/feedback/eup/jni/NativeExceptionUpload:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   52: iconst_1
    //   53: invokevirtual 73	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   56: ldc 2
    //   58: monitorexit
    //   59: iload_1
    //   60: ireturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic 56	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   66: ifne +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 59	java/lang/Throwable:printStackTrace	()V
    //   73: ldc 75
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 78	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   82: pop
    //   83: iconst_0
    //   84: istore_1
    //   85: goto -29 -> 56
    //   88: iconst_0
    //   89: istore_1
    //   90: goto -34 -> 56
    //   93: astore_0
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramFile	File
    //   1	89	1	bool1	boolean
    //   20	2	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   25	56	61	java/lang/Throwable
    //   9	21	93	finally
    //   25	56	93	finally
    //   62	73	93	finally
    //   73	83	93	finally
  }
  
  public static boolean loadRQDNativeLib(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (File)localIterator.next();
          if ((paramList.exists()) && (paramList.isFile()) && (paramList.getName().equals("libNativeRQD.so")))
          {
            if (paramList != null)
            {
              bool = loadRQDNativeLib(paramList);
              return bool;
            }
            boolean bool = false;
          }
        }
        else
        {
          paramList = null;
        }
      }
      finally {}
    }
  }
  
  public static boolean registEUP(String paramString1, String paramString2, int paramInt)
  {
    if (!a.get()) {
      e.c("rqdp{  nreg disable!}", new Object[0]);
    }
    do
    {
      return false;
      if ((paramString1 == null) || (paramString1.trim().length() <= 0))
      {
        e.c("rqdp{  nreg param!}", new Object[0]);
        return false;
      }
      try
      {
        e.a("jarV:%d nativeV:%s", new Object[] { Integer.valueOf(1), registNativeExceptionHandler2(paramString1, paramString2, paramInt, 1) });
        return true;
      }
      catch (Throwable localThrowable)
      {
        e.c("regist fail:%s , try old regist", new Object[] { localThrowable.getMessage() });
        try
        {
          boolean bool = registNativeExceptionHandler(paramString1, paramString2, paramInt);
          return bool;
        }
        catch (Throwable paramString1)
        {
          e.c("regist fail:%s , try old regist", new Object[] { paramString1.getMessage() });
          if (!e.a(localThrowable)) {
            localThrowable.printStackTrace();
          }
        }
      }
    } while (e.a(paramString1));
    paramString1.printStackTrace();
    return false;
  }
  
  protected static native boolean registNativeExceptionHandler(String paramString1, String paramString2, int paramInt);
  
  protected static native String registNativeExceptionHandler2(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  protected static native void setLogMode(int paramInt);
  
  public static void setNativeLogMode(int paramInt)
  {
    if (!a.get()) {
      e.c("rqdp{  n sNL disable!!}", new Object[0]);
    }
    do
    {
      return;
      try
      {
        setLogMode(paramInt);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (e.a(localThrowable));
    localThrowable.printStackTrace();
  }
  
  public static void setmHandler(NativeExceptionHandler paramNativeExceptionHandler)
  {
    try
    {
      b = paramNativeExceptionHandler;
      return;
    }
    finally
    {
      paramNativeExceptionHandler = finally;
      throw paramNativeExceptionHandler;
    }
  }
  
  public static void testNativeCrash()
  {
    if (!a.get())
    {
      e.c("rqdp{  n testNC disable!!}", new Object[0]);
      return;
    }
    doNativeCrashForTest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.NativeExceptionUpload
 * JD-Core Version:    0.7.0.1
 */