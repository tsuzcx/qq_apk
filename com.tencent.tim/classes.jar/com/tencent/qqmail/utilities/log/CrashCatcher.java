package com.tencent.qqmail.utilities.log;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashCatcher
{
  private static final String TAG = "CrashCatcher";
  private static volatile AtomicBoolean isInitCrashCatcherLib = new AtomicBoolean(false);
  private static volatile AtomicBoolean isInitCrashGeneratorLib = new AtomicBoolean(false);
  
  private static String fetchProcessInfo(Context paramContext)
  {
    Object localObject2 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int i = Process.myPid();
    paramContext = "M";
    Object localObject1 = paramContext;
    int j;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      localObject1 = paramContext;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
        if (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i) {
          break label103;
        }
        paramContext = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
        j = paramContext.indexOf(":");
        if (j < 0) {
          paramContext = "M";
        }
      }
    }
    label103:
    for (;;)
    {
      break;
      paramContext = paramContext.substring(j + 1);
      continue;
      return localObject1;
    }
  }
  
  @Keep
  public static Thread getThreadByName(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Set localSet = Thread.getAllStackTraces().keySet();
    Thread[] arrayOfThread = (Thread[])localSet.toArray(new Thread[localSet.size()]);
    int j = arrayOfThread.length;
    int i = 0;
    if (i < j)
    {
      localSet = arrayOfThread[i];
      if (!localSet.getName().equals(paramString)) {
        break label118;
      }
      localObject = localSet;
    }
    label118:
    for (;;)
    {
      i += 1;
      break;
      Log.d("CrashCatcher", "threadName: " + paramString + ", thread: " + localObject);
      return localObject;
    }
  }
  
  @NonNull
  private static String getTombstoneFilePath(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("tombstoneDirPath cannot be null!");
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).isDirectory()) {
      throw new IllegalArgumentException("tombstoneDirPath is not directory!");
    }
    if (!((File)localObject).exists()) {
      throw new IllegalArgumentException("tombstoneDirPath does not exist!");
    }
    localObject = paramString;
    if (!paramString.endsWith("/")) {
      localObject = paramString + "/";
    }
    return (String)localObject + "tombstone[" + fetchProcessInfo(paramContext) + "].log";
  }
  
  public static void init(Context paramContext, String paramString, CrashHandleListener paramCrashHandleListener)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null!");
    }
    initCrashCatcherLib();
    paramString = getTombstoneFilePath(paramContext, paramString);
    nativeInit(paramContext.getPackageName(), paramString, paramCrashHandleListener);
  }
  
  /* Error */
  private static void initCrashCatcherLib()
  {
    // Byte code:
    //   0: getstatic 21	com/tencent/qqmail/utilities/log/CrashCatcher:isInitCrashCatcherLib	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3: invokevirtual 207	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   6: ifne +64 -> 70
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 21	com/tencent/qqmail/utilities/log/CrashCatcher:isInitCrashCatcherLib	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: invokevirtual 207	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   18: ifne +23 -> 41
    //   21: getstatic 212	android/os/Build$VERSION:SDK_INT	I
    //   24: bipush 21
    //   26: if_icmpge +19 -> 45
    //   29: ldc 214
    //   31: invokestatic 219	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   34: getstatic 21	com/tencent/qqmail/utilities/log/CrashCatcher:isInitCrashCatcherLib	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   37: iconst_1
    //   38: invokevirtual 222	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   41: ldc 2
    //   43: monitorexit
    //   44: return
    //   45: ldc 224
    //   47: invokestatic 219	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   50: goto -16 -> 34
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: bipush 6
    //   62: ldc 8
    //   64: ldc 225
    //   66: aload_0
    //   67: invokestatic 231	com/tencent/qqmail/utilities/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   53	5	0	localObject	Object
    //   59	8	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	34	53	finally
    //   34	41	53	finally
    //   41	44	53	finally
    //   45	50	53	finally
    //   54	57	53	finally
    //   0	12	59	java/lang/Throwable
    //   57	59	59	java/lang/Throwable
  }
  
  private static void initCrashGeneratorLib()
  {
    try
    {
      if (!isInitCrashGeneratorLib.get()) {
        try
        {
          if (!isInitCrashGeneratorLib.get()) {
            System.loadLibrary("QMCrashGenerator");
          }
          isInitCrashGeneratorLib.set(true);
          return;
        }
        finally {}
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.log(6, "CrashCatcher", "initCrashGeneratorLib", localThrowable);
    }
  }
  
  public static void invalidAddressCrash()
  {
    initCrashGeneratorLib();
    nativeInvalidAddressCrash();
  }
  
  private static native void nativeInit(String paramString1, String paramString2, CrashHandleListener paramCrashHandleListener);
  
  private static native void nativeInvalidAddressCrash();
  
  private static native void nativeSetup(int paramInt);
  
  private static native void nativeStackOverflowCrash();
  
  public static void setLogger(ILogger paramILogger)
  {
    Logger.setLogger(paramILogger);
  }
  
  public static void setup(int paramInt)
  {
    if (!isInitCrashCatcherLib.get()) {
      throw new IllegalStateException("Should init first!");
    }
    nativeSetup(paramInt);
  }
  
  public static void stackOverflowCrash()
  {
    initCrashGeneratorLib();
    nativeStackOverflowCrash();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.CrashCatcher
 * JD-Core Version:    0.7.0.1
 */