package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;

public final class an
{
  private static volatile boolean a = false;
  private static volatile String b = "0123456789ABCDEF";
  private static volatile String c = "0123456789ABCDEF";
  private static volatile String d = "0123456789ABCDEF";
  private static volatile String e = "0123456789ABCDEF";
  private static volatile String f = "0123456789ABCDEF";
  private static volatile String g = "0123456789ABCDEF";
  private static volatile String h = "0123456789ABCDEF";
  private static volatile String i = "";
  private static HashMap<String, Object> j = new HashMap();
  private static volatile long k = 0L;
  private static Runnable l = new an.1();
  
  public static Object a(String paramString)
  {
    try
    {
      Object localObject2 = j.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ad.a().getSystemService(paramString);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          j.put(paramString, localObject2);
          localObject1 = localObject2;
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  @Deprecated
  private static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "UNKNOWN";
  }
  
  public static void a()
  {
    a = true;
  }
  
  public static String b()
  {
    ad.a();
    l();
    if ((TextUtils.isEmpty(b)) || ("0123456789ABCDEF".equals(b))) {
      b = am.b(am.a(), "loc_id_imei", "0123456789ABCDEF");
    }
    return e(b);
  }
  
  public static String c()
  {
    ad.a();
    l();
    if ((TextUtils.isEmpty(d)) || ("0123456789ABCDEF".equals(d))) {
      d = am.b(am.a(), "loc_id_imsi", "0123456789ABCDEF");
    }
    return e(d);
  }
  
  public static String d()
  {
    ad.a();
    l();
    if ((TextUtils.isEmpty(g)) || ("0123456789ABCDEF".equals(g))) {
      g = am.b(am.a(), "loc_id_androidId", "0123456789ABCDEF");
    }
    return e(g);
  }
  
  @SuppressLint({"MissingPermission"})
  public static String e()
  {
    
    if ((TextUtils.isEmpty(f)) || ("0123456789ABCDEF".equals(f))) {
      f = am.b(am.a(), "loc_id_sn", "0123456789ABCDEF");
    }
    return e(f);
  }
  
  private static String e(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0123456789ABCDEF";
    }
    return str;
  }
  
  public static String f()
  {
    
    if ((TextUtils.isEmpty(e)) || ("0123456789ABCDEF".equals(e))) {
      e = am.b(am.a(), "loc_id_mac", "0123456789ABCDEF");
    }
    return e(e);
  }
  
  public static String g()
  {
    
    if (TextUtils.isEmpty(i))
    {
      String str = am.b(am.a(), "loc_build_model", "");
      i = str;
      if (TextUtils.isEmpty(str)) {
        i = Build.MODEL;
      }
    }
    return i;
  }
  
  public static String h()
  {
    return a(ad.a());
  }
  
  public static String i()
  {
    Object localObject = ad.a();
    localObject = ((Context)localObject).getApplicationInfo().loadLabel(((Context)localObject).getPackageManager());
    if (localObject == null) {
      return "UNKNOWN";
    }
    return ((CharSequence)localObject).toString();
  }
  
  public static String j()
  {
    Object localObject = ad.a();
    try
    {
      String str = ((Context)localObject).getPackageName();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(str, 16384).versionName;
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "unknown";
  }
  
  /* Error */
  private static void l()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 26	c/t/m/g/an:a	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   18: lstore_1
    //   19: getstatic 55	c/t/m/g/an:k	J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifne +24 -> 48
    //   27: invokestatic 111	c/t/m/g/am:a	()Landroid/content/SharedPreferences;
    //   30: ldc 188
    //   32: lconst_0
    //   33: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokestatic 197	c/t/m/g/am:b	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 190	java/lang/Long
    //   42: invokevirtual 200	java/lang/Long:longValue	()J
    //   45: putstatic 55	c/t/m/g/an:k	J
    //   48: lload_1
    //   49: getstatic 55	c/t/m/g/an:k	J
    //   52: lsub
    //   53: invokestatic 205	java/lang/Math:abs	(J)J
    //   56: ldc2_w 206
    //   59: lcmp
    //   60: ifle +39 -> 99
    //   63: iconst_3
    //   64: ldc 209
    //   66: ldc 211
    //   68: aconst_null
    //   69: invokestatic 216	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: new 218	android/os/Handler
    //   75: dup
    //   76: ldc 220
    //   78: invokestatic 225	c/t/m/g/ah:a	(Ljava/lang/String;)Landroid/os/HandlerThread;
    //   81: invokevirtual 231	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   84: invokespecial 234	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   87: getstatic 60	c/t/m/g/an:l	Ljava/lang/Runnable;
    //   90: invokestatic 237	c/t/m/g/ai:a	(Landroid/os/Handler;Ljava/lang/Runnable;)Z
    //   93: pop
    //   94: ldc 220
    //   96: invokestatic 240	c/t/m/g/ah:b	(Ljava/lang/String;)V
    //   99: getstatic 55	c/t/m/g/an:k	J
    //   102: lconst_0
    //   103: lcmp
    //   104: ifne -93 -> 11
    //   107: lload_1
    //   108: putstatic 55	c/t/m/g/an:k	J
    //   111: goto -100 -> 11
    //   114: astore_3
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_3
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   18	90	1	l1	long
    //   114	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	114	finally
    //   15	48	114	finally
    //   48	99	114	finally
    //   99	111	114	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.an
 * JD-Core Version:    0.7.0.1
 */