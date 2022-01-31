package com.tencent.bugly;

import com.tencent.bugly.proguard.a;

public class BuglyStrategy
{
  private String a;
  private String b;
  private String c;
  private long d;
  private String e;
  private String f;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  private Class<?> j = null;
  private boolean k = true;
  private boolean l = true;
  private boolean m = true;
  private boolean n = false;
  private a o;
  
  /* Error */
  public String getAppChannel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/bugly/BuglyStrategy:b	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 55	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 57	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 50	com/tencent/bugly/BuglyStrategy:b	Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BuglyStrategy
    //   15	10	1	str	String
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public String getAppPackageName()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/tencent/bugly/BuglyStrategy:c	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 55	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 61	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 60	com/tencent/bugly/BuglyStrategy:c	Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BuglyStrategy
    //   15	10	1	str	String
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   20	25	28	finally
  }
  
  public long getAppReportDelay()
  {
    try
    {
      long l1 = this.d;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String getAppVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/tencent/bugly/BuglyStrategy:a	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 55	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 70	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 68	com/tencent/bugly/BuglyStrategy:a	Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BuglyStrategy
    //   15	10	1	str	String
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   20	25	28	finally
  }
  
  public a getCrashHandleCallback$49db9608()
  {
    try
    {
      a locala = this.o;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getDeviceID()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getLibBuglySOFilePath()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Class<?> getUserInfoActivity()
  {
    try
    {
      Class localClass = this.j;
      return localClass;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isBuglyLogUpload()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableANRCrashMonitor()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableNativeCrashMonitor()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableUserInfo()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isReplaceOldChannel()
  {
    return this.l;
  }
  
  public boolean isUploadProcess()
  {
    try
    {
      boolean bool = this.m;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean recordUserInfoOnceADay()
  {
    try
    {
      boolean bool = this.n;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setAppChannel(String paramString)
  {
    try
    {
      this.b = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppPackageName(String paramString)
  {
    try
    {
      this.c = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppReportDelay(long paramLong)
  {
    try
    {
      this.d = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setAppVersion(String paramString)
  {
    try
    {
      this.a = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setBuglyLogUpload(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setCrashHandleCallback$59ec52b1(a parama)
  {
    try
    {
      this.o = parama;
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public BuglyStrategy setDeviceID(String paramString)
  {
    try
    {
      this.f = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setEnableANRCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setEnableNativeCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setEnableUserInfo(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setLibBuglySOFilePath(String paramString)
  {
    try
    {
      this.e = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setRecordUserInfoOnceADay(boolean paramBoolean)
  {
    try
    {
      this.n = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setReplaceOldChannel(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public BuglyStrategy setUploadProcess(boolean paramBoolean)
  {
    try
    {
      this.m = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setUserInfoActivity(Class<?> paramClass)
  {
    try
    {
      this.j = paramClass;
      return this;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.BuglyStrategy
 * JD-Core Version:    0.7.0.1
 */