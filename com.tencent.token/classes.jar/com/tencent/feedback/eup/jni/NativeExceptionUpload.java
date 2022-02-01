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
    if (!a.get())
    {
      e.c("rqdp{  n enable disable!!}", new Object[0]);
      return;
    }
    try
    {
      enableHandler(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
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
  
  /* Error */
  public static boolean loadRQDNativeLib()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 64
    //   5: invokestatic 70	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   8: getstatic 29	com/tencent/feedback/eup/jni/NativeExceptionUpload:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   11: iconst_1
    //   12: invokevirtual 73	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   15: ldc 2
    //   17: monitorexit
    //   18: iconst_1
    //   19: ireturn
    //   20: astore_0
    //   21: goto +30 -> 51
    //   24: astore_0
    //   25: aload_0
    //   26: invokestatic 56	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   29: ifne +7 -> 36
    //   32: aload_0
    //   33: invokevirtual 59	java/lang/Throwable:printStackTrace	()V
    //   36: ldc 75
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 78	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: ldc 2
    //   48: monitorexit
    //   49: iconst_0
    //   50: ireturn
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	1	0	localObject	Object
    //   24	31	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	15	20	finally
    //   25	36	20	finally
    //   36	46	20	finally
    //   3	15	24	java/lang/Throwable
  }
  
  public static boolean loadRQDNativeLib(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          boolean bool = paramFile.canRead();
          if (bool) {
            try
            {
              e.b("load %s", new Object[] { paramFile.getAbsolutePath() });
              System.load(paramFile.getAbsolutePath());
              a.set(true);
              return true;
            }
            catch (Throwable paramFile)
            {
              if (!e.a(paramFile)) {
                paramFile.printStackTrace();
              }
              e.d("rqdp{  load library fail! see detail ,will turn off native eup function!}", new Object[0]);
              return false;
            }
          }
        }
      }
      finally {}
    }
    return false;
  }
  
  public static boolean loadRQDNativeLib(List<File> paramList)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramList != null) {}
    try
    {
      paramList = paramList.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (paramList.hasNext())
        {
          localObject1 = (File)paramList.next();
          if ((((File)localObject1).exists()) && (((File)localObject1).isFile()) && (((File)localObject1).getName().equals("libNativeRQD.so"))) {
            break;
          }
        }
      }
      if (localObject1 == null) {
        break label87;
      }
      boolean bool = loadRQDNativeLib((File)localObject1);
      return bool;
    }
    finally
    {
      label82:
      break label82;
    }
    throw paramList;
    label87:
    return false;
  }
  
  public static boolean registEUP(String paramString1, String paramString2, int paramInt)
  {
    if (!a.get())
    {
      e.c("rqdp{  nreg disable!}", new Object[0]);
      return false;
    }
    if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
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
          if (!e.a(paramString1)) {
            paramString1.printStackTrace();
          }
          return false;
        }
      }
    }
    e.c("rqdp{  nreg param!}", new Object[0]);
    return false;
  }
  
  protected static native boolean registNativeExceptionHandler(String paramString1, String paramString2, int paramInt);
  
  protected static native String registNativeExceptionHandler2(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  protected static native void setLogMode(int paramInt);
  
  public static void setNativeLogMode(int paramInt)
  {
    if (!a.get())
    {
      e.c("rqdp{  n sNL disable!!}", new Object[0]);
      return;
    }
    try
    {
      setLogMode(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
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