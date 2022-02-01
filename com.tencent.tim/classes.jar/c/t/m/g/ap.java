package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class ap
{
  private static volatile ap m;
  public final Context a;
  public final al b;
  public final SharedPreferences c;
  public final ExecutorService d;
  final PackageManager e;
  public final TelephonyManager f;
  public final WifiManager g;
  public final LocationManager h;
  String i;
  private final HashMap<String, aq> j;
  private final bo k;
  private CountDownLatch l;
  private List<ch> n;
  
  private ap(Context paramContext)
  {
    this.a = paramContext;
    this.e = paramContext.getPackageManager();
    this.f = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.g = ((WifiManager)paramContext.getSystemService("wifi"));
    this.h = ((LocationManager)paramContext.getSystemService("location"));
    this.c = am.a("LocationSDK");
    new Bundle().putString("channelId", ai.d(paramContext.getPackageName()));
    new bp.1();
    this.k = new cf();
    Object localObject = new ap.1(this);
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.d = ((ExecutorService)localObject);
    this.j = new HashMap();
    this.j.put("cell", new ar("cell"));
    this.b = new al(this);
    try
    {
      this.b.g = c(paramContext);
      label207:
      a();
      return;
    }
    catch (Throwable paramContext)
    {
      break label207;
    }
  }
  
  public static ap a(Context paramContext)
  {
    if (m == null) {}
    try
    {
      if (m == null) {
        m = new ap(paramContext.getApplicationContext());
      }
      return m;
    }
    finally {}
  }
  
  static int b(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext != null)
        {
          paramContext = paramContext.getPackageInfo("com.txy.anywhere", 4);
          if (paramContext != null)
          {
            int i1 = paramContext.versionCode;
            return i1;
          }
        }
      }
      catch (Throwable paramContext)
      {
        return -1;
      }
    }
    return -2;
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentGeoLocationSDK")) {
          return paramContext.getString("TencentGeoLocationSDK");
        }
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          return paramContext;
        }
        return "";
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private String g()
  {
    Object localObject1 = this.b;
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("version", ((al)localObject1).d());
    ((HashMap)localObject2).put("app_name", b(((al)localObject1).h));
    ((HashMap)localObject2).put("app_label", b(((al)localObject1).j));
    if (!TextUtils.isEmpty(null)) {
      ((HashMap)localObject2).put("l", null);
    }
    try
    {
      localObject1 = new JSONObject((Map)localObject2);
      localObject2 = this.b;
      HashMap localHashMap = new HashMap();
      localHashMap.put("imei", b(((al)localObject2).a()));
      localHashMap.put("imsi", b(((al)localObject2).b()));
      localHashMap.put("mac", b(((al)localObject2).c().toLowerCase(Locale.ENGLISH)));
      localHashMap.put("model", b(Build.MANUFACTURER + "_" + Build.MODEL));
      localObject1 = ((JSONObject)localObject1).put("attribute", new JSONObject(localHashMap)).toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public final aq a(String paramString)
  {
    return (aq)this.j.get(paramString);
  }
  
  public final String a(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    System.currentTimeMillis();
    paramString = this.k.a(paramString, paramArrayOfByte);
    System.currentTimeMillis();
    paramArrayOfByte = ai.d((byte[])paramString.first);
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte, (String)paramString.second);
    }
    return "{}";
  }
  
  /* Error */
  public final String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 340	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: iload_1
    //   5: ifeq +150 -> 155
    //   8: invokestatic 371	c/t/m/g/n:a	()Lc/t/m/g/n;
    //   11: ldc_w 373
    //   14: invokevirtual 375	c/t/m/g/n:d	(Ljava/lang/String;)Z
    //   17: ifne +6 -> 23
    //   20: ldc 229
    //   22: areturn
    //   23: lload_2
    //   24: aload_0
    //   25: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   28: ldc_w 377
    //   31: lconst_0
    //   32: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: invokestatic 386	c/t/m/g/am:b	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 379	java/lang/Long
    //   41: invokevirtual 389	java/lang/Long:longValue	()J
    //   44: lsub
    //   45: ldc2_w 390
    //   48: lcmp
    //   49: ifle +70 -> 119
    //   52: aload_0
    //   53: invokespecial 393	c/t/m/g/ap:g	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   62: ldc_w 377
    //   65: lload_2
    //   66: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   72: aload_0
    //   73: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   76: ldc_w 398
    //   79: lload_2
    //   80: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   83: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload 4
    //   88: areturn
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   95: ldc_w 377
    //   98: lload_2
    //   99: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   105: aload_0
    //   106: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   109: ldc_w 398
    //   112: lload_2
    //   113: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   119: ldc 229
    //   121: areturn
    //   122: astore 4
    //   124: aload_0
    //   125: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   128: ldc_w 377
    //   131: lload_2
    //   132: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   138: aload_0
    //   139: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   142: ldc_w 398
    //   145: lload_2
    //   146: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   152: aload 4
    //   154: athrow
    //   155: lload_2
    //   156: ldc_w 398
    //   159: lconst_0
    //   160: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   163: invokestatic 401	c/t/m/g/am:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: checkcast 379	java/lang/Long
    //   169: invokevirtual 389	java/lang/Long:longValue	()J
    //   172: lsub
    //   173: ldc2_w 402
    //   176: lcmp
    //   177: ifle -58 -> 119
    //   180: aload_0
    //   181: invokespecial 393	c/t/m/g/ap:g	()Ljava/lang/String;
    //   184: astore 4
    //   186: aload_0
    //   187: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   190: ldc_w 398
    //   193: lload_2
    //   194: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   200: aload 4
    //   202: areturn
    //   203: astore 4
    //   205: aload_0
    //   206: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   209: ldc_w 398
    //   212: lload_2
    //   213: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   216: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   219: goto -100 -> 119
    //   222: astore 4
    //   224: aload_0
    //   225: getfield 82	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
    //   228: ldc_w 398
    //   231: lload_2
    //   232: invokestatic 383	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   235: invokestatic 396	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   238: aload 4
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	ap
    //   0	241	1	paramBoolean	boolean
    //   3	229	2	l1	long
    //   56	31	4	str1	String
    //   89	1	4	localException	Exception
    //   122	31	4	localObject1	Object
    //   184	17	4	str2	String
    //   203	1	4	localThrowable	Throwable
    //   222	17	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   52	58	89	java/lang/Exception
    //   52	58	122	finally
    //   180	186	203	java/lang/Throwable
    //   180	186	222	finally
  }
  
  public final void a()
  {
    this.l = new CountDownLatch(1);
    new Thread(new ap.2(this), "locationsdk_initStatus").start();
  }
  
  public final void a(Object paramObject)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (this.n == null) {
          this.n = new ArrayList();
        }
        Object localObject1 = this.n.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label191;
        }
        localObject2 = ((ch)((Iterator)localObject1).next()).c;
        if (paramObject != localObject2) {
          continue;
        }
        i1 = 1;
        if (i1 != 0) {
          return;
        }
        localObject1 = paramObject.getClass().getDeclaredMethods();
        int i2 = localObject1.length;
        i1 = 0;
        if (i1 >= i2) {
          continue;
        }
        localObject2 = localObject1[i1];
        localObject3 = ((Method)localObject2).getName();
        if ((!((String)localObject3).startsWith("on")) || (!((String)localObject3).endsWith("Event"))) {
          break label184;
        }
        localObject3 = ((Method)localObject2).getParameterTypes();
        if (localObject3.length != 1) {
          throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
        }
      }
      finally {}
      Object localObject2 = new ch(localObject3[0], (Method)localObject2, paramObject);
      this.n.add(localObject2);
      label184:
      i1 += 1;
      continue;
      label191:
      int i1 = 0;
    }
  }
  
  /* Error */
  public final void b(@androidx.annotation.Nullable Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 424	c/t/m/g/ap:n	Ljava/util/List;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -9 -> 6
    //   18: aload_3
    //   19: invokeinterface 433 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 439 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_3
    //   35: invokeinterface 443 1 0
    //   40: checkcast 445	c/t/m/g/ch
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 451	java/lang/Object:getClass	()Ljava/lang/Class;
    //   49: aload 4
    //   51: getfield 492	c/t/m/g/ch:a	Ljava/lang/Class;
    //   54: invokevirtual 495	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: getfield 498	c/t/m/g/ch:b	Ljava/lang/reflect/Method;
    //   67: aload 4
    //   69: getfield 447	c/t/m/g/ch:c	Ljava/lang/Object;
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokevirtual 502	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -59 -> 25
    //   87: astore 4
    //   89: goto -64 -> 25
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ap
    //   0	97	1	paramObject	Object
    //   57	2	2	bool	boolean
    //   13	22	3	localObject	Object
    //   43	25	4	localch	ch
    //   87	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	84	87	java/lang/Exception
    //   9	14	92	finally
    //   18	25	92	finally
    //   25	58	92	finally
    //   62	84	92	finally
  }
  
  public final boolean b()
  {
    return this.f != null;
  }
  
  public final boolean c()
  {
    return this.g != null;
  }
  
  public final boolean d()
  {
    return this.h != null;
  }
  
  public final al e()
  {
    if (-1L > 0L) {}
    try
    {
      if (!this.l.await(-1L, TimeUnit.MILLISECONDS))
      {
        return null;
        this.l.await();
      }
      return this.b;
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  final PackageInfo f()
  {
    try
    {
      PackageInfo localPackageInfo = this.e.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return new PackageInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ap
 * JD-Core Version:    0.7.0.1
 */