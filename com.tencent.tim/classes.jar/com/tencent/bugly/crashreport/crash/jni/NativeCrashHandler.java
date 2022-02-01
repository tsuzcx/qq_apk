package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

public class NativeCrashHandler
  implements com.tencent.bugly.crashreport.a
{
  private static NativeCrashHandler a;
  private static int b = 1;
  private static boolean m = false;
  private static boolean n = false;
  private static boolean p = true;
  private final Context c;
  private final com.tencent.bugly.crashreport.common.info.a d;
  private final w e;
  private NativeExceptionHandler f;
  private String g;
  private final boolean h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private com.tencent.bugly.crashreport.crash.b o;
  
  @SuppressLint({"SdCardPath"})
  private NativeCrashHandler(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, w paramw, boolean paramBoolean, String paramString)
  {
    this.c = z.a(paramContext);
    for (;;)
    {
      try
      {
        boolean bool = z.a(paramString);
        if (bool) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        paramString = com.tencent.bugly.crashreport.common.info.a.a(paramContext).c;
        paramString = "/data/data/" + paramString + "/app_bugly";
        continue;
      }
      this.o = paramb;
      this.g = paramString;
      this.d = parama;
      this.e = paramw;
      this.h = paramBoolean;
      this.f = new a(paramContext, parama, paramb, com.tencent.bugly.crashreport.common.strategy.a.a());
      return;
      paramString = paramContext.getDir("bugly", 0).getAbsolutePath();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool;
    String str2;
    String str3;
    Object localObject3;
    for (;;)
    {
      try
      {
        if (this.k)
        {
          x.d("[Native] Native crash report has already registered.", new Object[0]);
          return;
        }
        bool = this.j;
        if (bool) {
          try
          {
            str2 = regist(this.g, paramBoolean, b);
            if (str2 != null)
            {
              x.a("[Native] Native Crash Report enable.", new Object[0]);
              x.c("[Native] Check extra jni for Bugly NDK v%s", new Object[] { str2 });
              str3 = "2.1.1".replace(".", "");
              str4 = "2.3.0".replace(".", "");
              localObject3 = str2.replace(".", "");
              if (((String)localObject3).length() != 2) {
                break label361;
              }
              str1 = (String)localObject3 + "0";
            }
          }
          catch (Throwable localThrowable1)
          {
            String str4;
            String str1;
            label139:
            label189:
            label205:
            x.c("[Native] Failed to load Bugly SO file.", new Object[0]);
          }
        }
      }
      finally {}
      try
      {
        if (Integer.parseInt(str1) >= Integer.parseInt(str3)) {
          m = true;
        }
        if (Integer.parseInt(str1) >= Integer.parseInt(str4)) {
          n = true;
        }
      }
      catch (Throwable localThrowable3)
      {
        Object localObject2;
        continue;
      }
      if (!n) {
        break label399;
      }
      x.a("[Native] Info setting jni can be accessed.", new Object[0]);
      if (!m) {
        break label412;
      }
      x.a("[Native] Extra jni can be accessed.", new Object[0]);
      this.d.p = str2;
      str1 = "-".concat(this.d.p);
      if ((!c.b) && (!this.d.g.contains(str1))) {
        this.d.g = this.d.g.concat("-").concat(this.d.p);
      }
      x.a("comInfo.sdkVersion %s", new Object[] { this.d.g });
      this.k = true;
      str1 = getRunningCpuAbi();
      if (!TextUtils.isEmpty(str1)) {
        this.d.g(str1);
      }
    }
    label341:
    label361:
    do
    {
      this.j = false;
      this.i = false;
      break;
      localObject2 = localObject3;
      if (((String)localObject3).length() != 1) {
        break label139;
      }
      localObject2 = (String)localObject3 + "00";
      break label139;
      x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
      break label189;
      x.d("[Native] Extra jni can not be accessed.", new Object[0]);
      break label205;
      bool = this.i;
    } while (!bool);
    for (;;)
    {
      try
      {
        label399:
        label412:
        localObject2 = Integer.TYPE;
        localObject3 = Integer.TYPE;
        str2 = this.g;
        str3 = com.tencent.bugly.crashreport.common.info.b.a(this.c, false);
        if (!paramBoolean) {
          break label784;
        }
        i1 = 1;
        localObject3 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[] { String.class, String.class, localObject2, localObject3 }, new Object[] { str2, str3, Integer.valueOf(i1), Integer.valueOf(1) });
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = Integer.TYPE;
          localObject3 = this.g;
          str2 = com.tencent.bugly.crashreport.common.info.b.a(this.c, false);
          com.tencent.bugly.crashreport.common.info.a.b();
          i1 = com.tencent.bugly.crashreport.common.info.a.C();
          localObject2 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[] { String.class, String.class, localObject2 }, new Object[] { localObject3, str2, Integer.valueOf(i1) });
        }
        if (localObject2 == null) {
          break label341;
        }
        this.k = true;
        this.d.p = ((String)localObject2);
        localObject2 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[] { String.class }, new Object[] { localObject2 });
        if (localObject2 != null) {
          m = ((Boolean)localObject2).booleanValue();
        }
        z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(true) });
        if (!paramBoolean) {
          break label789;
        }
        i1 = 1;
        z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(i1) });
        localObject2 = getRunningCpuAbi();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        this.d.g((String)localObject2);
      }
      catch (Throwable localThrowable2) {}
      break label341;
      label784:
      int i1 = 5;
      continue;
      label789:
      i1 = 5;
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if ((!this.j) || (!n)) {}
    do
    {
      return false;
      try
      {
        setNativeInfo(paramInt, paramString);
        return true;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        n = false;
        return false;
      }
      catch (Throwable paramString) {}
    } while (x.a(paramString));
    paramString.printStackTrace();
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        x.a("[Native] Trying to load so: %s", new Object[] { paramString });
        if (paramBoolean) {
          System.load(paramString);
        }
      }
      catch (Throwable localThrowable1)
      {
        paramBoolean = false;
      }
      try
      {
        x.a("[Native] Successfully loaded SO: %s", new Object[] { paramString });
        return true;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramBoolean = true;
        }
      }
      System.loadLibrary(paramString);
    }
    x.d(localThrowable1.getMessage(), new Object[0]);
    x.d("[Native] Failed to load so: %s", new Object[] { paramString });
    return paramBoolean;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        startNativeMonitor();
        return;
      }
      finally {}
      c();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 307
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 138	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: invokevirtual 310	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:unregist	()Ljava/lang/String;
    //   27: ifnull +34 -> 61
    //   30: ldc_w 312
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 146	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 57	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: ldc_w 314
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 150	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc 229
    //   63: ldc_w 258
    //   66: aconst_null
    //   67: iconst_1
    //   68: anewarray 233	java/lang/Class
    //   71: dup
    //   72: iconst_0
    //   73: getstatic 259	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   76: aastore
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iconst_0
    //   84: invokestatic 262	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   87: aastore
    //   88: invokestatic 240	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 57	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   97: ldc_w 312
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokestatic 146	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   107: pop
    //   108: goto -88 -> 20
    //   111: astore_1
    //   112: ldc_w 314
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 150	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 55	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 53	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:i	Z
    //   133: goto -113 -> 20
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	NativeCrashHandler
    //   49	1	1	localThrowable1	Throwable
    //   111	1	1	localThrowable2	Throwable
    //   136	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	49	java/lang/Throwable
    //   61	108	111	java/lang/Throwable
    //   2	20	136	finally
    //   23	46	136	finally
    //   50	61	136	finally
    //   61	108	136	finally
    //   112	133	136	finally
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.l != paramBoolean)
      {
        x.a("user change native %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.l = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static NativeCrashHandler getInstance()
  {
    try
    {
      NativeCrashHandler localNativeCrashHandler = a;
      return localNativeCrashHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static NativeCrashHandler getInstance(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1, w paramw, boolean paramBoolean, String paramString)
  {
    try
    {
      if (a == null) {
        a = new NativeCrashHandler(paramContext, parama, paramb, paramw, paramBoolean, paramString);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private native String getSoCpuAbi();
  
  public static boolean isShouldHandleInJava()
  {
    return p;
  }
  
  public static void setShouldHandleInJava(boolean paramBoolean)
  {
    p = paramBoolean;
    if (a != null) {
      a.a(999, paramBoolean);
    }
  }
  
  protected final void a()
  {
    int i2 = 0;
    long l1 = z.b();
    long l2 = c.g;
    long l3 = z.b();
    Object localObject1 = new File(this.g);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {}
    for (;;)
    {
      int i1;
      int i4;
      int i5;
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return;
          }
          int i6 = localObject1.length;
          i1 = 0;
          i3 = 0;
          if (i1 < i6)
          {
            Object localObject2 = localObject1[i1];
            long l4 = localObject2.lastModified();
            if (l4 >= l1 - l2)
            {
              i4 = i2;
              i5 = i3;
              if (l4 < 86400000L + l3) {
                break label205;
              }
            }
            x.a("[Native] Delete record file: %s", new Object[] { localObject2.getAbsolutePath() });
            i3 += 1;
            i4 = i2;
            i5 = i3;
            if (!localObject2.delete()) {
              break label205;
            }
            i4 = i2 + 1;
            i5 = i3;
            break label205;
          }
          x.c("[Native] Number of record files overdue: %d, has deleted: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2) });
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        x.a(localThrowable);
      }
      return;
      label205:
      i1 += 1;
      i2 = i4;
      int i3 = i5;
    }
  }
  
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3)
  {
    if ((!this.i) && (!this.j)) {
      return false;
    }
    if (!m) {
      return false;
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return false;
    }
    try
    {
      if (this.j) {
        return appendNativeLog(paramString1, paramString2, paramString3);
      }
      paramString1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      if (paramString1 != null)
      {
        boolean bool = paramString1.booleanValue();
        return bool;
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      m = false;
      return false;
    }
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public void checkUploadRecordCrash()
  {
    this.e.a(new NativeCrashHandler.1(this));
  }
  
  public void dumpAnrNativeStack()
  {
    a(19, "1");
  }
  
  public void enableCatchAnrTrace()
  {
    if ((Build.VERSION.SDK_INT <= 30) && (Build.VERSION.SDK_INT >= 23)) {
      b |= 0x2;
    }
  }
  
  public boolean filterSigabrtSysLog()
  {
    return a(998, "true");
  }
  
  public String getDumpFilePath()
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
  
  public String getLogFromNative()
  {
    if ((!this.i) && (!this.j)) {
      return null;
    }
    if (!m) {
      return null;
    }
    try
    {
      if (this.j) {
        return getNativeLog();
      }
      String str = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      m = false;
      return null;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  public NativeExceptionHandler getNativeExceptionHandler()
  {
    return this.f;
  }
  
  protected native String getNativeKeyValueList();
  
  protected native String getNativeLog();
  
  public String getRunningCpuAbi()
  {
    try
    {
      String str = getSoCpuAbi();
      return str;
    }
    catch (Throwable localThrowable)
    {
      x.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
    }
    return "";
  }
  
  public boolean isEnableCatchAnrTrace()
  {
    return (b & 0x2) == 2;
  }
  
  public boolean isUserOpened()
  {
    try
    {
      boolean bool = this.l;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void onStrategyChanged(StrategyBean paramStrategyBean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +35 -> 40
    //   8: aload_1
    //   9: getfield 410	com/tencent/bugly/crashreport/common/strategy/StrategyBean:e	Z
    //   12: aload_0
    //   13: getfield 57	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   16: if_icmpeq +24 -> 40
    //   19: ldc_w 412
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: getfield 410	com/tencent/bugly/crashreport/common/strategy/StrategyBean:e	Z
    //   32: invokestatic 262	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: aastore
    //   36: invokestatic 138	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   39: pop
    //   40: invokestatic 86	com/tencent/bugly/crashreport/common/strategy/a:a	()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   43: invokevirtual 415	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   46: getfield 410	com/tencent/bugly/crashreport/common/strategy/StrategyBean:e	Z
    //   49: ifeq +44 -> 93
    //   52: aload_0
    //   53: getfield 59	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:l	Z
    //   56: ifeq +37 -> 93
    //   59: iload_2
    //   60: aload_0
    //   61: getfield 57	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   64: if_icmpeq +26 -> 90
    //   67: ldc_w 417
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: iload_2
    //   77: invokestatic 262	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: aastore
    //   81: invokestatic 146	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: iload_2
    //   87: invokespecial 419	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:b	(Z)V
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iconst_0
    //   94: istore_2
    //   95: goto -36 -> 59
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	NativeCrashHandler
    //   0	103	1	paramStrategyBean	StrategyBean
    //   1	94	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	40	98	finally
    //   40	59	98	finally
    //   59	90	98	finally
  }
  
  public boolean putKeyValueToNative(String paramString1, String paramString2)
  {
    if ((!this.i) && (!this.j)) {
      return false;
    }
    if (!m) {
      return false;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    try
    {
      if (this.j) {
        return putNativeKeyValue(paramString1, paramString2);
      }
      paramString1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
      if (paramString1 != null)
      {
        boolean bool = paramString1.booleanValue();
        return bool;
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      m = false;
      return false;
    }
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  public void removeEmptyNativeRecordFiles()
  {
    b.c(this.g);
  }
  
  protected native String removeNativeKeyValue(String paramString);
  
  public void setDumpFilePath(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean setNativeAppChannel(String paramString)
  {
    return a(12, paramString);
  }
  
  public boolean setNativeAppPackage(String paramString)
  {
    return a(13, paramString);
  }
  
  public boolean setNativeAppVersion(String paramString)
  {
    return a(10, paramString);
  }
  
  protected native void setNativeInfo(int paramInt, String paramString);
  
  public boolean setNativeIsAppForeground(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "true";; str = "false") {
      return a(14, str);
    }
  }
  
  public boolean setNativeLaunchTime(long paramLong)
  {
    try
    {
      boolean bool = a(15, String.valueOf(paramLong));
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (!x.a(localNumberFormatException)) {
        localNumberFormatException.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean setNativeUserId(String paramString)
  {
    return a(11, paramString);
  }
  
  public void setUserOpened(boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      c(paramBoolean);
      paramBoolean = isUserOpened();
      com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
      if (locala != null) {
        if ((paramBoolean) && (locala.c().e)) {
          paramBoolean = bool;
        }
      }
      for (;;)
      {
        if (paramBoolean != this.k)
        {
          x.a("native changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
          b(paramBoolean);
        }
        return;
        paramBoolean = false;
      }
    }
    finally {}
  }
  
  public void startNativeMonitor()
  {
    boolean bool;
    label208:
    Object localObject2;
    for (;;)
    {
      try
      {
        if ((this.j) || (this.i))
        {
          a(this.h);
          return;
        }
        String str1 = "Bugly";
        if (!z.a(this.d.o))
        {
          bool = true;
          if (!c.b) {
            break;
          }
          if (!bool) {
            break label208;
          }
          str1 = this.d.o;
          this.j = a(str1, bool);
          if ((!this.j) && (!bool)) {
            this.i = a("NativeRQD", false);
          }
          if ((!this.j) && (!this.i)) {
            continue;
          }
          a(this.h);
          if (!m) {
            continue;
          }
          setNativeAppVersion(this.d.l);
          setNativeAppChannel(this.d.n);
          setNativeAppPackage(this.d.c);
          setNativeUserId(this.d.f());
          setNativeIsAppForeground(this.d.a());
          setNativeLaunchTime(this.d.a);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      localObject2 = "Bugly" + "-rqd";
    }
    String str2 = this.d.o;
    if (!bool) {
      this.d.getClass();
    }
    for (;;)
    {
      this.j = a((String)localObject2, bool);
      break;
      localObject2 = str2;
    }
  }
  
  protected native void testCrash();
  
  public void testNativeCrash()
  {
    if (!this.j)
    {
      x.d("[Native] Bugly SO file has not been load.", new Object[0]);
      return;
    }
    testCrash();
  }
  
  public void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(16, paramBoolean1);
    a(17, paramBoolean2);
    a(18, paramBoolean3);
    testNativeCrash();
  }
  
  protected native String unregist();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler
 * JD-Core Version:    0.7.0.1
 */