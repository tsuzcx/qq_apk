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
  private String g;
  private boolean h = true;
  private boolean i = true;
  private boolean j = false;
  private boolean k = true;
  private Class<?> l = null;
  private boolean m = true;
  private boolean n = true;
  private boolean o = true;
  private boolean p = true;
  private boolean q = false;
  private a r;
  private int s = 31;
  private boolean t = false;
  private boolean u = true;
  
  /* Error */
  public String getAppChannel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/bugly/BuglyStrategy:b	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 72	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 74	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 67	com/tencent/bugly/BuglyStrategy:b	Ljava/lang/String;
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
    //   3: getfield 77	com/tencent/bugly/BuglyStrategy:c	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 72	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 78	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 77	com/tencent/bugly/BuglyStrategy:c	Ljava/lang/String;
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
    //   3: getfield 85	com/tencent/bugly/BuglyStrategy:a	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 72	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 87	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 85	com/tencent/bugly/BuglyStrategy:a	Ljava/lang/String;
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
  
  public int getCallBackType()
  {
    try
    {
      int i1 = this.s;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean getCloseErrorCallback()
  {
    try
    {
      boolean bool = this.t;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public a getCrashHandleCallback$49db9608()
  {
    try
    {
      a locala = this.r;
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
  
  public String getDeviceModel()
  {
    try
    {
      String str = this.g;
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
      Class localClass = this.l;
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
      boolean bool = this.m;
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
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableCatchAnrTrace()
  {
    try
    {
      boolean bool = this.j;
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
      boolean bool = this.h;
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
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isMerged()
  {
    return this.u;
  }
  
  public boolean isReplaceOldChannel()
  {
    return this.n;
  }
  
  public boolean isUploadProcess()
  {
    try
    {
      boolean bool = this.o;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isUploadSpotCrash()
  {
    try
    {
      boolean bool = this.p;
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
      boolean bool = this.q;
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
      this.m = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCallBackType(int paramInt)
  {
    try
    {
      this.s = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCloseErrorCallback(boolean paramBoolean)
  {
    try
    {
      this.t = paramBoolean;
      return;
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
      this.r = parama;
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
  
  public BuglyStrategy setDeviceModel(String paramString)
  {
    try
    {
      this.g = paramString;
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
      this.i = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setEnableCatchAnrTrace(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public BuglyStrategy setEnableNativeCrashMonitor(boolean paramBoolean)
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
  
  public BuglyStrategy setEnableUserInfo(boolean paramBoolean)
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
  
  public void setMerged(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public BuglyStrategy setRecordUserInfoOnceADay(boolean paramBoolean)
  {
    try
    {
      this.q = paramBoolean;
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
    this.n = paramBoolean;
  }
  
  public BuglyStrategy setUploadProcess(boolean paramBoolean)
  {
    try
    {
      this.o = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setUploadSpotCrash(boolean paramBoolean)
  {
    try
    {
      this.p = paramBoolean;
      return;
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
      this.l = paramClass;
      return this;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.BuglyStrategy
 * JD-Core Version:    0.7.0.1
 */