package com.tencent.msf.boot.config;

import android.content.Context;
import com.tencent.mobileqq.msf.core.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeConfigStore
{
  private static final String NATIVE_LIB_NAME = "msfbootV2";
  private static AtomicBoolean isSoLoaded;
  private static String tag = "MSF.C.NativeConfigStore";
  Context context;
  public AtomicBoolean loadSaveRootSucc = new AtomicBoolean(true);
  
  static
  {
    isSoLoaded = new AtomicBoolean(false);
    loadSo();
  }
  
  public NativeConfigStore(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void loadSo()
  {
    if (!isSoLoaded.get()) {
      try
      {
        if (c.a("msfbootV2", BaseApplication.getContext()))
        {
          isSoLoaded.set(true);
          return;
        }
        String str = BaseApplication.getContext().getPackageName().replace(".", "_");
        isSoLoaded.set(c.a(str + "_" + "msfbootV2", BaseApplication.getContext()));
        return;
      }
      catch (Exception localException)
      {
        QLog.w(tag, 1, localException.toString(), localException);
      }
    }
  }
  
  public synchronized native String getConfig(String paramString);
  
  public synchronized native String[] getConfigList(String paramString);
  
  public synchronized native void loadConfig(Context paramContext, boolean paramBoolean);
  
  /* Error */
  public String[] n_getConfigList(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +21 -> 30
    //   12: getstatic 20	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   15: iconst_1
    //   16: ldc 102
    //   18: invokestatic 105	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: anewarray 72	java/lang/String
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 107	com/tencent/msf/boot/config/NativeConfigStore:getConfigList	(Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore_1
    //   36: goto -10 -> 26
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	NativeConfigStore
    //   0	44	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	39	finally
    //   30	36	39	finally
  }
  
  /* Error */
  public void n_removeConfig(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +15 -> 24
    //   12: getstatic 20	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   15: iconst_1
    //   16: ldc 102
    //   18: invokestatic 105	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 112	com/tencent/msf/boot/config/NativeConfigStore:removeConfig	(Ljava/lang/String;)V
    //   29: goto -8 -> 21
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	NativeConfigStore
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	21	32	finally
    //   24	29	32	finally
  }
  
  /* Error */
  public void n_setConfig(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +15 -> 24
    //   12: getstatic 20	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   15: iconst_1
    //   16: ldc 102
    //   18: invokestatic 105	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: invokevirtual 117	com/tencent/msf/boot/config/NativeConfigStore:setConfig	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: goto -9 -> 21
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	NativeConfigStore
    //   0	38	1	paramString1	String
    //   0	38	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	33	finally
    //   24	30	33	finally
  }
  
  public synchronized native void removeConfig(String paramString);
  
  public synchronized native void setConfig(String paramString1, String paramString2);
  
  public synchronized native void setSaveRootPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.boot.config.NativeConfigStore
 * JD-Core Version:    0.7.0.1
 */