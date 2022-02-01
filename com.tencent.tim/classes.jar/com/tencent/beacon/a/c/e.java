package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.base.net.b.e.a;
import com.tencent.beacon.base.util.b;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class e
  implements e.a
{
  private static volatile e a;
  private final Context b = c.d().c();
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  
  private e()
  {
    com.tencent.beacon.base.net.b.e.a(this.b, this);
    F();
  }
  
  private void F()
  {
    this.e = G();
  }
  
  private String G()
  {
    try
    {
      localObject = this.b;
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject == null) {
        return "unknown";
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        break label239;
      }
      int i = ((NetworkInfo)localObject).getType();
      if (i != 1) {
        break label72;
      }
      localObject = "wifi";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        label72:
        com.tencent.beacon.base.util.c.a(localException);
        str = "unknown";
      }
    }
    com.tencent.beacon.base.util.c.a("[DeviceInfo] NetWork Type:" + (String)localObject, new Object[0]);
    return localObject;
    if (((NetworkInfo)localObject).getType() == 0)
    {
      localObject = this.b;
      localObject = (TelephonyManager)((Context)localObject).getSystemService("phone");
      if (localObject != null) {
        switch (((TelephonyManager)localObject).getNetworkType())
        {
        }
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = "unknown_" + ((TelephonyManager)localObject).getNetworkType();
      break;
      localObject = "4G";
      break;
      localObject = "3G";
      break;
      localObject = "2G";
      break;
      localObject = "unknown";
      break;
      String str;
      label239:
      return "unknown";
    }
  }
  
  public static e l()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new e();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public String A()
  {
    // Byte code:
    //   0: ldc 129
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 98	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: ldc 131
    //   11: astore_2
    //   12: ldc 131
    //   14: astore_3
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/beacon/a/c/e:B	()Z
    //   19: ifeq +175 -> 194
    //   22: ldc 137
    //   24: astore 6
    //   26: getstatic 142	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   29: invokestatic 148	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   32: bipush 10
    //   34: if_icmplt +236 -> 270
    //   37: aload_2
    //   38: astore 5
    //   40: aload_3
    //   41: astore 4
    //   43: aload_0
    //   44: getfield 42	com/tencent/beacon/a/c/e:b	Landroid/content/Context;
    //   47: astore 7
    //   49: aload_2
    //   50: astore 5
    //   52: aload_3
    //   53: astore 4
    //   55: aload 7
    //   57: ldc 150
    //   59: invokevirtual 65	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 152	android/hardware/SensorManager
    //   65: astore 7
    //   67: aload_2
    //   68: astore 5
    //   70: aload_3
    //   71: astore 4
    //   73: aload 7
    //   75: iconst_1
    //   76: invokevirtual 156	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +120 -> 201
    //   84: ldc 137
    //   86: astore_2
    //   87: aload_2
    //   88: astore 5
    //   90: aload_3
    //   91: astore 4
    //   93: aload 7
    //   95: iconst_5
    //   96: invokevirtual 156	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   99: astore_3
    //   100: aload_3
    //   101: ifnull +106 -> 207
    //   104: ldc 137
    //   106: astore_3
    //   107: aload_2
    //   108: astore 5
    //   110: aload_3
    //   111: astore 4
    //   113: invokestatic 162	android/bluetooth/BluetoothAdapter:getDefaultAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   116: astore 7
    //   118: aload 7
    //   120: ifnonnull +93 -> 213
    //   123: ldc 164
    //   125: astore 4
    //   127: aload_0
    //   128: getfield 42	com/tencent/beacon/a/c/e:b	Landroid/content/Context;
    //   131: invokevirtual 168	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   134: astore 5
    //   136: aload 5
    //   138: ldc 170
    //   140: invokevirtual 176	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   143: istore_1
    //   144: iload_1
    //   145: ifeq +75 -> 220
    //   148: ldc 137
    //   150: astore 5
    //   152: aload_3
    //   153: astore 7
    //   155: aload_2
    //   156: astore_3
    //   157: aload 7
    //   159: astore_2
    //   160: new 83	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   167: aload 6
    //   169: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_3
    //   173: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_2
    //   177: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 4
    //   182: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 5
    //   187: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: areturn
    //   194: ldc 164
    //   196: astore 6
    //   198: goto -172 -> 26
    //   201: ldc 164
    //   203: astore_2
    //   204: goto -117 -> 87
    //   207: ldc 164
    //   209: astore_3
    //   210: goto -103 -> 107
    //   213: ldc 137
    //   215: astore 4
    //   217: goto -90 -> 127
    //   220: ldc 164
    //   222: astore 7
    //   224: aload_2
    //   225: astore 5
    //   227: aload_3
    //   228: astore_2
    //   229: aload 5
    //   231: astore_3
    //   232: aload 7
    //   234: astore 5
    //   236: goto -76 -> 160
    //   239: astore_2
    //   240: ldc 131
    //   242: astore 7
    //   244: aload 5
    //   246: astore_3
    //   247: aload 4
    //   249: astore_2
    //   250: aload 7
    //   252: astore 4
    //   254: ldc 178
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 180	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: ldc 131
    //   265: astore 5
    //   267: goto -107 -> 160
    //   270: ldc 131
    //   272: astore 4
    //   274: ldc 131
    //   276: astore_3
    //   277: ldc 131
    //   279: astore_2
    //   280: ldc 131
    //   282: astore 5
    //   284: goto -124 -> 160
    //   287: astore 5
    //   289: aload_2
    //   290: astore 5
    //   292: aload_3
    //   293: astore_2
    //   294: aload 5
    //   296: astore_3
    //   297: goto -43 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	e
    //   143	2	1	bool	boolean
    //   11	218	2	localObject1	Object
    //   239	1	2	localThrowable1	Throwable
    //   249	45	2	localObject2	Object
    //   14	283	3	localObject3	Object
    //   41	232	4	localObject4	Object
    //   38	245	5	localObject5	Object
    //   287	1	5	localThrowable2	Throwable
    //   290	5	5	localObject6	Object
    //   24	173	6	str	String
    //   47	204	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   43	49	239	java/lang/Throwable
    //   55	67	239	java/lang/Throwable
    //   73	80	239	java/lang/Throwable
    //   93	100	239	java/lang/Throwable
    //   113	118	239	java/lang/Throwable
    //   127	136	287	java/lang/Throwable
    //   136	144	287	java/lang/Throwable
  }
  
  public boolean B()
  {
    return (WifiManager)this.b.getSystemService("wifi") != null;
  }
  
  public void C()
  {
    this.f = a.a().getString("BEACON_ANDROID_ID_DENGTA", "");
    if (TextUtils.isEmpty(this.f))
    {
      this.f = b.a();
      a.a locala = a.a().edit();
      if (b.a(locala)) {
        locala.putString("BEACON_ANDROID_ID_DENGTA", this.f);
      }
    }
  }
  
  /* Error */
  public boolean D()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 220	java/io/BufferedReader
    //   9: dup
    //   10: new 222	java/io/InputStreamReader
    //   13: dup
    //   14: invokestatic 228	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: iconst_2
    //   18: anewarray 230	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 232
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 234
    //   30: aastore
    //   31: invokevirtual 238	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 244	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: invokestatic 250	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   40: invokespecial 253	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   43: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore_3
    //   47: aload_3
    //   48: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +96 -> 151
    //   58: aload 4
    //   60: invokevirtual 262	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   63: astore 4
    //   65: aload 4
    //   67: ldc_w 264
    //   70: invokevirtual 267	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   73: istore_1
    //   74: iconst_m1
    //   75: iload_1
    //   76: if_icmpeq -29 -> 47
    //   79: iconst_1
    //   80: istore_2
    //   81: iconst_1
    //   82: anewarray 269	java/io/Closeable
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: aastore
    //   89: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   92: iload_2
    //   93: ireturn
    //   94: astore 4
    //   96: aload 4
    //   98: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   101: iconst_1
    //   102: anewarray 269	java/io/Closeable
    //   105: dup
    //   106: iconst_0
    //   107: aload_3
    //   108: aastore
    //   109: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore 4
    //   116: iconst_1
    //   117: anewarray 269	java/io/Closeable
    //   120: dup
    //   121: iconst_0
    //   122: aload_3
    //   123: aastore
    //   124: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   127: aload 4
    //   129: athrow
    //   130: astore 4
    //   132: goto -16 -> 116
    //   135: astore 4
    //   137: aload 5
    //   139: astore_3
    //   140: goto -44 -> 96
    //   143: astore 4
    //   145: aload 6
    //   147: astore_3
    //   148: goto -32 -> 116
    //   151: iconst_0
    //   152: istore_2
    //   153: goto -72 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	e
    //   73	4	1	i	int
    //   80	73	2	bool	boolean
    //   46	102	3	localObject1	Object
    //   51	15	4	str	String
    //   94	3	4	localThrowable1	Throwable
    //   114	14	4	localObject2	Object
    //   130	1	4	localObject3	Object
    //   135	1	4	localThrowable2	Throwable
    //   143	1	4	localObject4	Object
    //   4	134	5	localObject5	Object
    //   1	145	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   47	53	94	java/lang/Throwable
    //   58	65	94	java/lang/Throwable
    //   65	74	94	java/lang/Throwable
    //   47	53	114	finally
    //   58	65	114	finally
    //   65	74	114	finally
    //   96	101	130	finally
    //   6	47	135	java/lang/Throwable
    //   6	47	143	finally
  }
  
  public String E()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    try
    {
      Class localClass = Class.forName("com.huawei.system.BuildEx");
      Method localMethod = localClass.getMethod("getOsBrand", new Class[0]);
      boolean bool = "harmony".equals(localMethod.invoke(localClass, new Object[0]));
      if (bool) {
        return "Y";
      }
      return "N";
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] isHarmonyOS occur a problem.", new Object[0]);
    }
    return "N";
  }
  
  public String a(Context paramContext)
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      if (i < 9)
      {
        com.tencent.beacon.base.util.c.b("[audit] Api level < 9;return null!", new Object[0]);
        return "";
      }
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.beacon.base.util.c.a("[audit] get app_last_updated_time:" + String.valueOf(paramContext.lastUpdateTime), new Object[0]);
      long l = paramContext.lastUpdateTime;
      return String.valueOf(l);
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.base.util.c.a(paramContext);
      com.tencent.beacon.base.util.c.b("[audit] get app_last_updated_time failed!", new Object[0]);
    }
    return "";
  }
  
  public void a()
  {
    F();
  }
  
  public void b()
  {
    F();
  }
  
  public boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public String d()
  {
    return this.f;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: invokestatic 228	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   9: iconst_2
    //   10: anewarray 230	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 232
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc_w 334
    //   23: aastore
    //   24: invokevirtual 238	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   27: invokevirtual 244	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   30: astore_2
    //   31: new 220	java/io/BufferedReader
    //   34: dup
    //   35: new 222	java/io/InputStreamReader
    //   38: dup
    //   39: aload_2
    //   40: ldc_w 336
    //   43: invokestatic 339	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   46: invokespecial 253	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   49: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull +28 -> 87
    //   62: aload_3
    //   63: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   66: invokestatic 148	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   69: sipush 1000
    //   72: idiv
    //   73: istore_1
    //   74: iconst_1
    //   75: anewarray 269	java/io/Closeable
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: aastore
    //   82: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   85: iload_1
    //   86: ireturn
    //   87: iconst_0
    //   88: istore_1
    //   89: goto -15 -> 74
    //   92: astore_3
    //   93: aload_3
    //   94: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   97: iconst_1
    //   98: anewarray 269	java/io/Closeable
    //   101: dup
    //   102: iconst_0
    //   103: aload_2
    //   104: aastore
    //   105: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_3
    //   111: iconst_1
    //   112: anewarray 269	java/io/Closeable
    //   115: dup
    //   116: iconst_0
    //   117: aload_2
    //   118: aastore
    //   119: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   122: aload_3
    //   123: athrow
    //   124: astore_3
    //   125: goto -14 -> 111
    //   128: astore_3
    //   129: aload 4
    //   131: astore_2
    //   132: goto -39 -> 93
    //   135: astore_3
    //   136: aload 5
    //   138: astore_2
    //   139: goto -28 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	e
    //   73	16	1	i	int
    //   30	109	2	localObject1	Object
    //   57	6	3	str	String
    //   92	2	3	localThrowable1	Throwable
    //   110	13	3	localObject2	Object
    //   124	1	3	localObject3	Object
    //   128	1	3	localThrowable2	Throwable
    //   135	1	3	localObject4	Object
    //   4	126	4	localObject5	Object
    //   1	136	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   53	58	92	java/lang/Throwable
    //   62	74	92	java/lang/Throwable
    //   53	58	110	finally
    //   62	74	110	finally
    //   93	97	124	finally
    //   6	31	128	java/lang/Throwable
    //   31	53	128	java/lang/Throwable
    //   6	31	135	finally
    //   31	53	135	finally
  }
  
  /* Error */
  public String f()
  {
    // Byte code:
    //   0: ldc 22
    //   2: astore 4
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore_3
    //   9: invokestatic 228	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: iconst_2
    //   13: anewarray 230	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 232
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 234
    //   25: aastore
    //   26: invokevirtual 238	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   29: invokevirtual 244	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   32: astore_2
    //   33: new 220	java/io/BufferedReader
    //   36: dup
    //   37: new 222	java/io/InputStreamReader
    //   40: dup
    //   41: aload_2
    //   42: ldc_w 336
    //   45: invokestatic 339	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   48: invokespecial 253	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   51: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: astore 5
    //   61: aload 4
    //   63: astore_3
    //   64: aload 5
    //   66: ifnull +35 -> 101
    //   69: aload 5
    //   71: ldc_w 344
    //   74: invokevirtual 347	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   77: istore_1
    //   78: iload_1
    //   79: ifeq -24 -> 55
    //   82: aload 5
    //   84: aload 5
    //   86: ldc_w 349
    //   89: invokevirtual 267	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   92: iconst_1
    //   93: iadd
    //   94: invokevirtual 353	java/lang/String:substring	(I)Ljava/lang/String;
    //   97: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   100: astore_3
    //   101: iconst_1
    //   102: anewarray 269	java/io/Closeable
    //   105: dup
    //   106: iconst_0
    //   107: aload_2
    //   108: aastore
    //   109: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   112: aload_3
    //   113: areturn
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   119: iconst_1
    //   120: anewarray 269	java/io/Closeable
    //   123: dup
    //   124: iconst_0
    //   125: aload_2
    //   126: aastore
    //   127: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   130: ldc 22
    //   132: areturn
    //   133: astore_3
    //   134: iconst_1
    //   135: anewarray 269	java/io/Closeable
    //   138: dup
    //   139: iconst_0
    //   140: aload_2
    //   141: aastore
    //   142: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   145: aload_3
    //   146: athrow
    //   147: astore_3
    //   148: goto -14 -> 134
    //   151: astore 4
    //   153: aload_3
    //   154: astore_2
    //   155: aload 4
    //   157: astore_3
    //   158: goto -43 -> 115
    //   161: astore_3
    //   162: aload 5
    //   164: astore_2
    //   165: goto -31 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	e
    //   77	2	1	bool	boolean
    //   32	133	2	localObject1	Object
    //   8	105	3	str1	String
    //   114	2	3	localThrowable1	Throwable
    //   133	13	3	localObject2	Object
    //   147	7	3	localObject3	Object
    //   157	1	3	localThrowable2	Throwable
    //   161	1	3	localObject4	Object
    //   2	60	4	str2	String
    //   151	5	4	localThrowable3	Throwable
    //   5	158	5	str3	String
    // Exception table:
    //   from	to	target	type
    //   55	61	114	java/lang/Throwable
    //   69	78	114	java/lang/Throwable
    //   82	101	114	java/lang/Throwable
    //   55	61	133	finally
    //   69	78	133	finally
    //   82	101	133	finally
    //   115	119	147	finally
    //   9	33	151	java/lang/Throwable
    //   33	55	151	java/lang/Throwable
    //   9	33	161	finally
    //   33	55	161	finally
  }
  
  public String g()
  {
    return Locale.getDefault().getCountry();
  }
  
  public String h()
  {
    return Build.HARDWARE;
  }
  
  public DisplayMetrics i()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics;
  }
  
  public long j()
  {
    ActivityManager localActivityManager = (ActivityManager)this.b.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (localActivityManager != null)
    {
      localActivityManager.getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.availMem;
    }
    return -1L;
  }
  
  public String k()
  {
    String str = "0";
    long l = j();
    if (l > 0L) {
      str = l / 1024L / 1024L + "";
    }
    return str;
  }
  
  public boolean m()
  {
    return com.tencent.beacon.base.util.d.d();
  }
  
  public String n()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public String o()
  {
    return Build.MANUFACTURER;
  }
  
  /* Error */
  public String p()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore 4
    //   10: new 83	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   17: astore 6
    //   19: new 220	java/io/BufferedReader
    //   22: dup
    //   23: new 431	java/io/FileReader
    //   26: dup
    //   27: new 433	java/io/File
    //   30: dup
    //   31: ldc_w 435
    //   34: invokespecial 438	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 441	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   40: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_2
    //   44: aload_2
    //   45: astore_1
    //   46: aload 6
    //   48: aload_2
    //   49: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: iconst_1
    //   57: anewarray 269	java/io/Closeable
    //   60: dup
    //   61: iconst_0
    //   62: aload_2
    //   63: aastore
    //   64: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   67: aload 6
    //   69: ldc_w 443
    //   72: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: new 220	java/io/BufferedReader
    //   79: dup
    //   80: new 431	java/io/FileReader
    //   83: dup
    //   84: new 433	java/io/File
    //   87: dup
    //   88: ldc_w 445
    //   91: invokespecial 438	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: invokespecial 441	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   97: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload 6
    //   105: aload_2
    //   106: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: iconst_1
    //   114: anewarray 269	java/io/Closeable
    //   117: dup
    //   118: iconst_0
    //   119: aload_2
    //   120: aastore
    //   121: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   124: aload 6
    //   126: ldc_w 443
    //   129: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: new 220	java/io/BufferedReader
    //   136: dup
    //   137: new 431	java/io/FileReader
    //   140: dup
    //   141: new 433	java/io/File
    //   144: dup
    //   145: ldc_w 447
    //   148: invokespecial 438	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: invokespecial 441	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   154: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   157: astore_1
    //   158: aload 6
    //   160: aload_1
    //   161: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   164: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: iconst_1
    //   169: anewarray 269	java/io/Closeable
    //   172: dup
    //   173: iconst_0
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   179: aload 6
    //   181: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: astore_1
    //   185: new 83	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 449
    //   195: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 98	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload_1
    //   213: areturn
    //   214: astore_1
    //   215: aconst_null
    //   216: astore_2
    //   217: aload_2
    //   218: astore_1
    //   219: ldc_w 451
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 98	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: iconst_1
    //   230: anewarray 269	java/io/Closeable
    //   233: dup
    //   234: iconst_0
    //   235: aload_2
    //   236: aastore
    //   237: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   240: goto -173 -> 67
    //   243: astore_1
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: astore_1
    //   248: ldc_w 451
    //   251: iconst_0
    //   252: anewarray 4	java/lang/Object
    //   255: invokestatic 98	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: iconst_1
    //   259: anewarray 269	java/io/Closeable
    //   262: dup
    //   263: iconst_0
    //   264: aload_2
    //   265: aastore
    //   266: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   269: goto -145 -> 124
    //   272: astore_2
    //   273: ldc_w 451
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 98	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: iconst_1
    //   284: anewarray 269	java/io/Closeable
    //   287: dup
    //   288: iconst_0
    //   289: aload_1
    //   290: aastore
    //   291: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   294: goto -115 -> 179
    //   297: astore_2
    //   298: iconst_1
    //   299: anewarray 269	java/io/Closeable
    //   302: dup
    //   303: iconst_0
    //   304: aload_1
    //   305: aastore
    //   306: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   309: aload_2
    //   310: athrow
    //   311: astore_2
    //   312: iconst_1
    //   313: anewarray 269	java/io/Closeable
    //   316: dup
    //   317: iconst_0
    //   318: aload_1
    //   319: aastore
    //   320: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   323: aload_2
    //   324: athrow
    //   325: astore_2
    //   326: iconst_1
    //   327: anewarray 269	java/io/Closeable
    //   330: dup
    //   331: iconst_0
    //   332: aload_1
    //   333: aastore
    //   334: invokestatic 272	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   337: aload_2
    //   338: athrow
    //   339: astore_2
    //   340: goto -42 -> 298
    //   343: astore_1
    //   344: aload 4
    //   346: astore_1
    //   347: goto -74 -> 273
    //   350: astore_2
    //   351: aload_3
    //   352: astore_1
    //   353: goto -55 -> 298
    //   356: astore_2
    //   357: aload 5
    //   359: astore_1
    //   360: goto -48 -> 312
    //   363: astore_1
    //   364: goto -118 -> 246
    //   367: astore_2
    //   368: goto -42 -> 326
    //   371: astore_1
    //   372: goto -155 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	e
    //   6	207	1	localObject1	Object
    //   214	1	1	localException1	Exception
    //   218	1	1	localObject2	Object
    //   243	1	1	localException2	Exception
    //   247	86	1	localObject3	Object
    //   343	1	1	localException3	Exception
    //   346	14	1	localObject4	Object
    //   363	1	1	localException4	Exception
    //   371	1	1	localException5	Exception
    //   43	222	2	localBufferedReader	java.io.BufferedReader
    //   272	1	2	localException6	Exception
    //   297	13	2	localObject5	Object
    //   311	13	2	localObject6	Object
    //   325	13	2	localObject7	Object
    //   339	1	2	localObject8	Object
    //   350	1	2	localObject9	Object
    //   356	1	2	localObject10	Object
    //   367	1	2	localObject11	Object
    //   1	351	3	localObject12	Object
    //   8	337	4	localObject13	Object
    //   3	355	5	localObject14	Object
    //   17	163	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	44	214	java/lang/Exception
    //   76	101	243	java/lang/Exception
    //   158	168	272	java/lang/Exception
    //   158	168	297	finally
    //   103	113	311	finally
    //   248	258	311	finally
    //   46	56	325	finally
    //   219	229	325	finally
    //   273	283	339	finally
    //   133	158	343	java/lang/Exception
    //   133	158	350	finally
    //   76	101	356	finally
    //   103	113	363	java/lang/Exception
    //   19	44	367	finally
    //   46	56	371	java/lang/Exception
  }
  
  public String q()
  {
    return this.e;
  }
  
  public int r()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new d(this));
      if (arrayOfFile == null) {
        return 1;
      }
      int i = arrayOfFile.length;
      return i;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.base.util.c.b("[model] CPU Count: Failed.", new Object[0]);
      com.tencent.beacon.base.util.c.a(localException);
    }
    return 1;
  }
  
  public String s()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return this.c;
    }
    this.c = ("Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK);
    com.tencent.beacon.base.util.c.a("[DeviceInfo] os version: %s", new Object[] { this.c });
    return this.c;
  }
  
  /* Error */
  public String t()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 431	java/io/FileReader
    //   6: dup
    //   7: ldc_w 479
    //   10: invokespecial 480	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 6
    //   15: new 220	java/io/BufferedReader
    //   18: dup
    //   19: aload 6
    //   21: sipush 8192
    //   24: invokespecial 483	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +97 -> 133
    //   39: aload 4
    //   41: ldc_w 485
    //   44: iconst_2
    //   45: invokevirtual 489	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   48: iconst_1
    //   49: aaload
    //   50: invokevirtual 262	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   53: astore 4
    //   55: aload 4
    //   57: ldc_w 491
    //   60: ldc 22
    //   62: invokevirtual 495	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   68: invokestatic 501	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   71: ldc2_w 411
    //   74: ldiv
    //   75: lstore_1
    //   76: new 83	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   83: lload_1
    //   84: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: astore 4
    //   89: aload 4
    //   91: ldc 22
    //   93: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload_3
    //   102: invokevirtual 504	java/io/BufferedReader:close	()V
    //   105: aload 6
    //   107: invokevirtual 505	java/io/FileReader:close	()V
    //   110: aload 4
    //   112: astore_3
    //   113: aload_3
    //   114: areturn
    //   115: astore_3
    //   116: ldc_w 507
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 180	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_3
    //   127: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   130: aload 4
    //   132: areturn
    //   133: aload_3
    //   134: invokevirtual 504	java/io/BufferedReader:close	()V
    //   137: aload 6
    //   139: invokevirtual 505	java/io/FileReader:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: ldc_w 507
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 180	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   159: aconst_null
    //   160: areturn
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_3
    //   165: aload 6
    //   167: astore 5
    //   169: aload_3
    //   170: ifnull +7 -> 177
    //   173: aload_3
    //   174: invokevirtual 504	java/io/BufferedReader:close	()V
    //   177: aload 5
    //   179: ifnull +8 -> 187
    //   182: aload 5
    //   184: invokevirtual 505	java/io/FileReader:close	()V
    //   187: aload 4
    //   189: athrow
    //   190: astore 5
    //   192: aconst_null
    //   193: astore_3
    //   194: aload 6
    //   196: astore 4
    //   198: ldc_w 509
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 180	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 5
    //   210: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 504	java/io/BufferedReader:close	()V
    //   221: aload 7
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull -113 -> 113
    //   229: aload 4
    //   231: invokevirtual 505	java/io/FileReader:close	()V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_3
    //   237: ldc_w 507
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 180	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload_3
    //   248: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   251: aconst_null
    //   252: areturn
    //   253: astore 4
    //   255: aconst_null
    //   256: astore_3
    //   257: aconst_null
    //   258: astore 5
    //   260: goto -91 -> 169
    //   263: astore 5
    //   265: aconst_null
    //   266: astore_3
    //   267: aconst_null
    //   268: astore 4
    //   270: goto -72 -> 198
    //   273: astore_3
    //   274: ldc_w 507
    //   277: iconst_0
    //   278: anewarray 4	java/lang/Object
    //   281: invokestatic 180	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: aload_3
    //   285: invokestatic 119	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   288: goto -101 -> 187
    //   291: astore 6
    //   293: aload 4
    //   295: astore 5
    //   297: aload 6
    //   299: astore 4
    //   301: goto -132 -> 169
    //   304: astore 5
    //   306: aload 6
    //   308: astore 4
    //   310: goto -112 -> 198
    //   313: astore 4
    //   315: aload 6
    //   317: astore 5
    //   319: goto -150 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	e
    //   75	9	1	l	long
    //   27	87	3	localObject1	Object
    //   115	19	3	localThrowable1	Throwable
    //   144	12	3	localThrowable2	Throwable
    //   164	60	3	localObject2	Object
    //   236	12	3	localThrowable3	Throwable
    //   256	11	3	localObject3	Object
    //   273	12	3	localThrowable4	Throwable
    //   32	99	4	localObject4	Object
    //   161	27	4	localObject5	Object
    //   196	34	4	localFileReader1	java.io.FileReader
    //   253	1	4	localObject6	Object
    //   268	41	4	localObject7	Object
    //   313	1	4	localObject8	Object
    //   167	16	5	localFileReader2	java.io.FileReader
    //   190	19	5	localThrowable5	Throwable
    //   258	1	5	localObject9	Object
    //   263	1	5	localThrowable6	Throwable
    //   295	1	5	localObject10	Object
    //   304	1	5	localThrowable7	Throwable
    //   317	1	5	localObject11	Object
    //   13	182	6	localFileReader3	java.io.FileReader
    //   291	25	6	localObject12	Object
    //   1	221	7	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   101	110	115	java/lang/Throwable
    //   133	142	144	java/lang/Throwable
    //   15	28	161	finally
    //   15	28	190	java/lang/Throwable
    //   217	221	236	java/lang/Throwable
    //   229	234	236	java/lang/Throwable
    //   3	15	253	finally
    //   3	15	263	java/lang/Throwable
    //   173	177	273	java/lang/Throwable
    //   182	187	273	java/lang/Throwable
    //   198	213	291	finally
    //   28	34	304	java/lang/Throwable
    //   39	55	304	java/lang/Throwable
    //   55	89	304	java/lang/Throwable
    //   89	101	304	java/lang/Throwable
    //   28	34	313	finally
    //   39	55	313	finally
    //   55	89	313	finally
    //   89	101	313	finally
  }
  
  public String u()
  {
    DisplayMetrics localDisplayMetrics = i();
    if (localDisplayMetrics == null) {
      return "";
    }
    return localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels;
  }
  
  public String v()
  {
    ArrayList localArrayList = b.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public String w()
  {
    if (!TextUtils.isEmpty(this.d)) {
      return this.d;
    }
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    long l2 = localStatFs.getBlockCount();
    this.d = (l2 * l1 / 1024L / 1024L + "");
    com.tencent.beacon.base.util.c.a("[DeviceInfo] Rom Size:" + this.d, new Object[0]);
    return this.d;
  }
  
  public long x()
  {
    if (!c()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      long l = localStatFs.getBlockCount();
      l = i * l / 1024L / 1024L;
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
    return 0L;
  }
  
  public int y()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    if (localWindowManager != null)
    {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
      float f1 = localDisplayMetrics.density;
      if (f1 - 0.75D <= 1.0E-006D) {
        return 120;
      }
      if (f1 - 1.5D <= 1.0E-006D) {
        return 240;
      }
      if (f1 - 2.0D <= 1.0E-006D) {
        return 320;
      }
      if (f1 - 3.0D <= 1.0E-006D) {
        return 480;
      }
    }
    return 160;
  }
  
  public String z()
  {
    com.tencent.beacon.base.util.c.a("[DeviceInfo] getSensor start", new Object[0]);
    Object localObject1 = "X";
    Object localObject3 = "X";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject4 = localObject3;
    Object localObject5 = localObject1;
    if (Integer.parseInt(Build.VERSION.SDK) >= 10)
    {
      localObject5 = localObject3;
      localObject4 = localObject1;
    }
    label655:
    label670:
    for (;;)
    {
      try
      {
        localObject7 = Class.forName("android.hardware.Camera");
        localObject5 = localObject3;
        localObject4 = localObject1;
        j = ((Integer)((Class)localObject7).getMethod("getNumberOfCameras", new Class[0]).invoke(localObject7, new Object[0])).intValue();
        if (j == 0)
        {
          localObject1 = "N";
          localObject3 = "N";
          localObject5 = localObject3;
          localObject4 = localObject1;
          localObject6 = this.b;
          localObject5 = localObject3;
          localObject4 = localObject1;
          localObject6 = (SensorManager)((Context)localObject6).getSystemService("sensor");
          localObject4 = localObject3;
          localObject5 = localObject1;
          if (localObject6 == null) {
            break label655;
          }
          localObject5 = localObject3;
          localObject4 = localObject1;
          localObject7 = ((SensorManager)localObject6).getDefaultSensor(9);
          if (localObject7 == null) {
            continue;
          }
          localObject4 = "Y";
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject7;
        int j;
        Object localObject11;
        Object localObject8;
        Object localObject9;
        int k;
        int i;
        Object localObject10;
        int m;
        int n;
        localObject6 = "X";
        localObject3 = localObject5;
        localObject5 = localThrowable1;
        localObject2 = localObject4;
        localObject4 = localObject6;
      }
      try
      {
        localObject5 = ((SensorManager)localObject6).getDefaultSensor(4);
        if (localObject5 != null)
        {
          localObject7 = "Y";
          localObject5 = localObject1;
          localObject6 = localObject4;
          localObject1 = localObject7;
          localStringBuilder.append((String)localObject5).append((String)localObject3).append((String)localObject6).append((String)localObject1);
          return localStringBuilder.toString();
          localObject5 = localObject3;
          localObject4 = localObject1;
          localObject11 = Class.forName("android.hardware.Camera$CameraInfo");
          localObject5 = localObject3;
          localObject4 = localObject1;
          localObject8 = ((Class)localObject11).newInstance();
          localObject5 = localObject3;
          localObject4 = localObject1;
          localObject9 = ((Class)localObject7).getMethods();
          localObject5 = localObject3;
          localObject4 = localObject1;
          k = localObject9.length;
          i = 0;
          if (i < k)
          {
            localObject6 = localObject9[i];
            localObject5 = localObject3;
            localObject4 = localObject1;
            localObject10 = ((Method)localObject6).getName();
            localObject5 = localObject3;
            localObject4 = localObject1;
            boolean bool = ((String)localObject10).equals("getCameraInfo");
            if (bool)
            {
              localObject5 = localObject3;
              localObject4 = localObject1;
              localObject9 = ((Class)localObject11).getField("facing");
              localObject5 = localObject3;
              localObject4 = localObject1;
              localObject10 = ((Class)localObject11).getField("CAMERA_FACING_BACK");
              localObject5 = localObject3;
              localObject4 = localObject1;
              localObject11 = ((Class)localObject11).getField("CAMERA_FACING_FRONT");
              if (localObject6 == null) {
                continue;
              }
              localObject3 = "X";
              localObject1 = "X";
              i = 0;
              if (i >= j) {
                break label670;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        break label611;
      }
      try
      {
        ((Method)localObject6).invoke(localObject7, new Object[] { Integer.valueOf(i), localObject8 });
        k = ((Field)localObject9).getInt(localObject8);
        m = ((Field)localObject10).getInt(localObject8);
        n = ((Field)localObject11).getInt(localObject8);
        if (k == m)
        {
          localObject1 = "Y";
          localObject4 = localObject1;
          if (j == 1)
          {
            localObject3 = "N";
            localObject4 = localObject1;
          }
          i += 1;
          localObject1 = localObject4;
          continue;
          i += 1;
          continue;
          localObject6 = null;
          continue;
        }
        localObject4 = localObject1;
        if (k != n) {
          continue;
        }
        localObject5 = "Y";
        localObject3 = localObject5;
        localObject4 = localObject1;
        if (j != 1) {
          continue;
        }
        localObject4 = "N";
        localObject3 = localObject5;
        continue;
        localObject4 = "N";
      }
      catch (Throwable localThrowable2)
      {
        localObject4 = "X";
        break label611;
      }
      Object localObject6 = "N";
      localObject5 = localObject1;
      localObject1 = localObject6;
      localObject6 = localObject4;
      continue;
      label611:
      com.tencent.beacon.base.util.c.b("[model] getSensor error!", new Object[0]);
      com.tencent.beacon.base.util.c.a((Throwable)localObject5);
      localObject5 = localObject2;
      Object localObject2 = "X";
      localObject6 = localObject4;
      continue;
      localObject2 = "X";
      localObject6 = "X";
      localObject3 = localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.c.e
 * JD-Core Version:    0.7.0.1
 */