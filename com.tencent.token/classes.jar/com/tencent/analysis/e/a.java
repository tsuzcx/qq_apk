package com.tencent.analysis.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.analysis.d.a.c;
import com.tencent.analysis.d.a.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class a
{
  public String A = "";
  private WifiManager B;
  private TelephonyManager C;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "android";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  public a()
  {
    if (com.tencent.analysis.a.a != null)
    {
      this.B = ((WifiManager)com.tencent.analysis.a.a.getSystemService("wifi"));
      this.C = ((TelephonyManager)com.tencent.analysis.a.a.getSystemService("phone"));
    }
    if (com.tencent.analysis.a.a != null)
    {
      r();
      s();
      t();
      this.b = b();
      this.e = d();
      this.f = e();
      this.h = f();
      this.i = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_resolution", "UNKNOWN");
      this.j = q();
      g();
      this.l = h();
      this.m = i();
      this.n = j();
      this.o = k();
      this.p = l();
      this.q = com.tencent.analysis.a.a.getPackageName();
      this.r = m();
      com.tencent.analysis.a.a();
      this.t = com.tencent.analysis.a.a(com.tencent.analysis.a.a);
      this.s = com.tencent.analysis.b.d;
      this.u = n();
      this.v = o();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(SystemClock.uptimeMillis());
      this.w = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(SystemClock.elapsedRealtime());
      this.x = localStringBuilder.toString();
      this.y = u();
      this.z = p();
      this.A = v();
    }
  }
  
  private String a()
  {
    Object localObject2 = "UNKNOWN";
    for (;;)
    {
      try
      {
        if (!a("android.permission.ACCESS_WIFI_STATE")) {
          break label190;
        }
        localObject1 = localObject2;
        if (this.B != null)
        {
          localObject3 = this.B.getConnectionInfo();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((WifiInfo)localObject3).getMacAddress();
          }
        }
        if ((localObject1 != null) && (!((String)localObject1).equals("NOPERMISSION")))
        {
          boolean bool = ((String)localObject1).equals("");
          if (!bool) {
            continue;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject3;
        int i1;
        String str1 = localException1.toString();
        if (com.tencent.analysis.b.c) {
          Log.i("BaseInfoUtil", str1);
        }
        str1 = "EXCEPTION";
        return str1;
      }
      try
      {
        localObject1 = new StringBuffer(1000);
        localObject2 = new BufferedReader(new FileReader("/sys/class/net/eth0/address"));
        localObject3 = new char[1024];
        i1 = ((BufferedReader)localObject2).read((char[])localObject3);
        if (i1 != -1)
        {
          ((StringBuffer)localObject1).append(String.valueOf((char[])localObject3, 0, i1));
          continue;
        }
        ((BufferedReader)localObject2).close();
        localObject1 = ((StringBuffer)localObject1).toString().toUpperCase().substring(0, 17);
        return localObject1;
      }
      catch (Exception localException2)
      {
        continue;
      }
      return "UNKNOWN";
      label190:
      String str2 = "NOPERMISSION";
    }
  }
  
  private static boolean a(String paramString)
  {
    if (com.tencent.analysis.a.a == null) {
      return false;
    }
    Object localObject = com.tencent.analysis.a.a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(com.tencent.analysis.a.a.getPackageName(), 4096);
      if (localObject != null)
      {
        if (((PackageInfo)localObject).requestedPermissions == null) {
          return false;
        }
        localObject = ((PackageInfo)localObject).requestedPermissions;
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          boolean bool = localObject[i1].equals(paramString);
          if (bool) {
            return true;
          }
          i1 += 1;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString = paramString.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", paramString);
      }
    }
    return false;
  }
  
  private String b()
  {
    String str1 = "UNKNOWN";
    try
    {
      if (a("android.permission.READ_PHONE_STATE"))
      {
        if (this.C != null) {
          return this.C.getDeviceId();
        }
      }
      else {
        return "NOPERMISSION";
      }
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
      str2 = "EXCEPTION";
      return str2;
    }
  }
  
  private String c()
  {
    String str1 = "UNKNOWN";
    try
    {
      if (a("android.permission.READ_PHONE_STATE"))
      {
        if (this.C != null) {
          return this.C.getSubscriberId();
        }
      }
      else {
        return "NOPERMISSION";
      }
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
      str2 = "EXCEPTION";
      return str2;
    }
  }
  
  private static String d()
  {
    try
    {
      String str1 = Settings.Secure.getString(com.tencent.analysis.a.a.getContentResolver(), "android_id");
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
    return "EXCEPTION";
  }
  
  private static String e()
  {
    try
    {
      String str1 = Build.MODEL;
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
    return "EXCEPTION";
  }
  
  private static String f()
  {
    try
    {
      String str1 = Build.VERSION.RELEASE;
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
    return "EXCEPTION";
  }
  
  private void g()
  {
    String str1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("gpu_user", "UNKNOWN");
    if (str1.equals("UNKNOWN"))
    {
      this.k = "UNKNOWN";
      return;
    }
    try
    {
      this.k = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("loadGpuInfo Error :");
      localStringBuilder.append(localException.toString());
      String str2 = localStringBuilder.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
  }
  
  private static String h()
  {
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l2 * l1 / 1024L / 1024L);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      String str = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str);
      }
    }
    return "EXCEPTION";
  }
  
  /* Error */
  private static String i()
  {
    // Byte code:
    //   0: new 243	java/io/FileReader
    //   3: dup
    //   4: ldc_w 391
    //   7: invokespecial 248	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 241	java/io/BufferedReader
    //   14: dup
    //   15: aload_3
    //   16: sipush 8192
    //   19: invokespecial 394	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore 4
    //   26: aload_3
    //   27: astore 5
    //   29: aload_2
    //   30: invokevirtual 397	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: ldc_w 399
    //   36: iconst_2
    //   37: invokevirtual 403	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   40: iconst_1
    //   41: aaload
    //   42: invokevirtual 406	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   45: ldc_w 408
    //   48: ldc 42
    //   50: invokevirtual 412	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   53: invokevirtual 415	java/lang/String:trim	()Ljava/lang/String;
    //   56: invokestatic 421	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   59: ldc2_w 386
    //   62: ldiv
    //   63: lstore_0
    //   64: aload_2
    //   65: astore 4
    //   67: aload_3
    //   68: astore 5
    //   70: new 186	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   77: astore 6
    //   79: aload_2
    //   80: astore 4
    //   82: aload_3
    //   83: astore 5
    //   85: aload 6
    //   87: lload_0
    //   88: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: astore 4
    //   95: aload_3
    //   96: astore 5
    //   98: aload 6
    //   100: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 6
    //   105: aload_2
    //   106: invokevirtual 265	java/io/BufferedReader:close	()V
    //   109: aload_3
    //   110: invokevirtual 422	java/io/FileReader:close	()V
    //   113: aload 6
    //   115: areturn
    //   116: astore_2
    //   117: aload_2
    //   118: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   121: astore_2
    //   122: getstatic 277	com/tencent/analysis/b:c	Z
    //   125: ifeq +11 -> 136
    //   128: ldc_w 279
    //   131: aload_2
    //   132: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: ldc_w 286
    //   139: areturn
    //   140: astore 6
    //   142: goto +32 -> 174
    //   145: astore_2
    //   146: aconst_null
    //   147: astore 4
    //   149: goto +119 -> 268
    //   152: astore 6
    //   154: aconst_null
    //   155: astore_2
    //   156: goto +18 -> 174
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_3
    //   162: aload_3
    //   163: astore 4
    //   165: goto +103 -> 268
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_3
    //   172: aload_3
    //   173: astore_2
    //   174: aload_2
    //   175: astore 4
    //   177: aload_3
    //   178: astore 5
    //   180: aload 6
    //   182: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   185: astore 6
    //   187: aload_2
    //   188: astore 4
    //   190: aload_3
    //   191: astore 5
    //   193: getstatic 277	com/tencent/analysis/b:c	Z
    //   196: ifeq +18 -> 214
    //   199: aload_2
    //   200: astore 4
    //   202: aload_3
    //   203: astore 5
    //   205: ldc_w 279
    //   208: aload 6
    //   210: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   213: pop
    //   214: aload_2
    //   215: ifnull +10 -> 225
    //   218: aload_2
    //   219: invokevirtual 265	java/io/BufferedReader:close	()V
    //   222: goto +3 -> 225
    //   225: aload_3
    //   226: ifnull +34 -> 260
    //   229: aload_3
    //   230: invokevirtual 422	java/io/FileReader:close	()V
    //   233: ldc_w 286
    //   236: areturn
    //   237: aload_2
    //   238: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   241: astore_2
    //   242: getstatic 277	com/tencent/analysis/b:c	Z
    //   245: ifeq +11 -> 256
    //   248: ldc_w 279
    //   251: aload_2
    //   252: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   255: pop
    //   256: ldc_w 286
    //   259: areturn
    //   260: ldc_w 286
    //   263: areturn
    //   264: astore_2
    //   265: aload 5
    //   267: astore_3
    //   268: aload 4
    //   270: ifnull +11 -> 281
    //   273: aload 4
    //   275: invokevirtual 265	java/io/BufferedReader:close	()V
    //   278: goto +3 -> 281
    //   281: aload_3
    //   282: ifnull +33 -> 315
    //   285: aload_3
    //   286: invokevirtual 422	java/io/FileReader:close	()V
    //   289: goto +26 -> 315
    //   292: aload_2
    //   293: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   296: astore_2
    //   297: getstatic 277	com/tencent/analysis/b:c	Z
    //   300: ifeq +11 -> 311
    //   303: ldc_w 279
    //   306: aload_2
    //   307: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   310: pop
    //   311: ldc_w 286
    //   314: areturn
    //   315: aload_2
    //   316: athrow
    //   317: astore_2
    //   318: goto -81 -> 237
    //   321: astore_2
    //   322: goto -30 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   63	25	0	l1	long
    //   22	84	2	localBufferedReader	BufferedReader
    //   116	2	2	localIOException1	java.io.IOException
    //   121	11	2	str1	String
    //   145	1	2	localObject1	Object
    //   155	1	2	localObject2	Object
    //   159	1	2	localObject3	Object
    //   173	79	2	localObject4	Object
    //   264	29	2	localObject5	Object
    //   296	20	2	str2	String
    //   317	1	2	localIOException2	java.io.IOException
    //   321	1	2	localIOException3	java.io.IOException
    //   10	276	3	localObject6	Object
    //   24	250	4	localObject7	Object
    //   27	239	5	localObject8	Object
    //   77	37	6	localObject9	Object
    //   140	1	6	localException1	Exception
    //   152	1	6	localException2	Exception
    //   168	13	6	localException3	Exception
    //   185	24	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   105	113	116	java/io/IOException
    //   29	64	140	java/lang/Exception
    //   70	79	140	java/lang/Exception
    //   85	92	140	java/lang/Exception
    //   98	105	140	java/lang/Exception
    //   11	23	145	finally
    //   11	23	152	java/lang/Exception
    //   0	11	159	finally
    //   0	11	168	java/lang/Exception
    //   29	64	264	finally
    //   70	79	264	finally
    //   85	92	264	finally
    //   98	105	264	finally
    //   180	187	264	finally
    //   193	199	264	finally
    //   205	214	264	finally
    //   218	222	317	java/io/IOException
    //   229	233	317	java/io/IOException
    //   273	278	321	java/io/IOException
    //   285	289	321	java/io/IOException
  }
  
  private static String j()
  {
    try
    {
      String str1 = Locale.getDefault().getCountry();
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
    return "EXCEPTION";
  }
  
  private static String k()
  {
    try
    {
      String str1 = Locale.getDefault().getLanguage();
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
    return "EXCEPTION";
  }
  
  private static String l()
  {
    if (com.tencent.analysis.b.c) {
      Log.i("BaseInfoUtil", "getSensor start");
    }
    Object localObject1 = "X";
    Object localObject3 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    for (;;)
    {
      int i2;
      Object localObject6;
      int i3;
      int i1;
      int i5;
      try
      {
        Class localClass = Class.forName("android.hardware.Camera");
        i2 = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (i2 == 0)
        {
          localObject1 = "N";
          localObject3 = "N";
        }
        else
        {
          localObject6 = Class.forName("android.hardware.Camera$CameraInfo");
          Object localObject7 = ((Class)localObject6).newInstance();
          Object localObject8 = localClass.getMethods();
          localObject4 = null;
          i3 = localObject8.length;
          i1 = 0;
          localObject5 = localObject4;
          if (i1 < i3)
          {
            localObject5 = localObject8[i1];
            if (!((Method)localObject5).getName().equals("getCameraInfo")) {
              break label427;
            }
          }
          localObject8 = ((Class)localObject6).getField("facing");
          Field localField1 = ((Class)localObject6).getField("CAMERA_FACING_BACK");
          Field localField2 = ((Class)localObject6).getField("CAMERA_FACING_FRONT");
          if (localObject5 != null)
          {
            localObject3 = "X";
            localObject4 = "X";
            i1 = 0;
            if (i1 >= i2) {
              break label482;
            }
            ((Method)localObject5).invoke(localClass, new Object[] { Integer.valueOf(i1), localObject7 });
            i3 = ((Field)localObject8).getInt(localObject7);
            int i4 = localField1.getInt(localObject7);
            i5 = localField2.getInt(localObject7);
            if (i3 != i4) {
              break label434;
            }
            localObject4 = "Y";
            localObject1 = localObject4;
            if (i2 != 1) {
              break label471;
            }
            localObject3 = "N";
            localObject1 = localObject4;
            break label471;
          }
        }
        localObject5 = (SensorManager)com.tencent.analysis.a.a.getSystemService("sensor");
        if (((SensorManager)localObject5).getDefaultSensor(1) == null) {
          break label489;
        }
        localObject4 = "Y";
        if (((SensorManager)localObject5).getDefaultSensor(4) == null) {
          break label497;
        }
        localObject5 = "Y";
        localStringBuffer.append((String)localObject1);
        localStringBuffer.append((String)localObject3);
        localStringBuffer.append((String)localObject4);
        localStringBuffer.append((String)localObject5);
      }
      catch (Exception localException)
      {
        localObject2 = localException.toString();
        if (com.tencent.analysis.b.c) {
          Log.i("BaseInfoUtil", (String)localObject2);
        }
        return "EXCEPTION";
      }
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", "getSensor End");
      }
      return localStringBuffer.toString();
      label427:
      i1 += 1;
      continue;
      label434:
      Object localObject2 = localObject4;
      if (i3 == i5)
      {
        localObject6 = "Y";
        localObject2 = localObject4;
        localObject3 = localObject6;
        if (i2 == 1)
        {
          localObject2 = "N";
          localObject3 = localObject6;
        }
      }
      label471:
      i1 += 1;
      Object localObject4 = localObject2;
      continue;
      label482:
      localObject2 = localObject4;
      continue;
      label489:
      localObject4 = "N";
      continue;
      label497:
      Object localObject5 = "N";
    }
  }
  
  private static String m()
  {
    Object localObject = com.tencent.analysis.a.a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(com.tencent.analysis.a.a.getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((PackageInfo)localObject).versionCode);
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      String str = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str);
      }
    }
    return "EXCEPTION";
  }
  
  private static String n()
  {
    try
    {
      String str1 = Build.BRAND;
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
    return "EXCEPTION";
  }
  
  private String o()
  {
    String str = "UNKNOWN";
    try
    {
      if (this.C != null) {
        str = this.C.getSimOperator();
      }
      return str;
    }
    catch (Exception localException) {}
    return "UNKNOWN";
  }
  
  private String p()
  {
    String str3 = "UNKNOWN";
    try
    {
      if (a("android.permission.ACCESS_NETWORK_STATE"))
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)com.tencent.analysis.a.a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return "UNKNOWN";
        }
        if (localNetworkInfo.getType() == 1) {
          return "wifi";
        }
        String str1 = str3;
        if (localNetworkInfo.getType() == 0)
        {
          str1 = str3;
          if (this.C == null) {}
        }
      }
      else
      {
        switch (this.C.getNetworkType())
        {
        default: 
          return "NOPERMISSION";
        }
      }
    }
    catch (Exception localException)
    {
      String str2 = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
      str2 = "EXCEPTION";
      return str2;
    }
    return "UNKNOWN";
    return "HSPA";
    return "HSUPA";
    return "HSDPA";
    return "CDMA - 1xRTT";
    return "CDMA - EvDo rev. A";
    return "CDMA - EvDo rev. 0";
    return "CDMA";
    return "UMTS";
    return "EDGE";
    return "GPRS";
  }
  
  /* Error */
  private static String q()
  {
    // Byte code:
    //   0: new 243	java/io/FileReader
    //   3: dup
    //   4: ldc_w 573
    //   7: invokespecial 248	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: new 241	java/io/BufferedReader
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 251	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   19: astore 5
    //   21: aload_0
    //   22: astore_1
    //   23: aload 5
    //   25: astore_2
    //   26: aload 5
    //   28: invokevirtual 397	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: ldc_w 399
    //   34: iconst_2
    //   35: invokevirtual 403	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   38: iconst_1
    //   39: aaload
    //   40: astore_3
    //   41: aload 5
    //   43: invokevirtual 265	java/io/BufferedReader:close	()V
    //   46: aload_0
    //   47: invokevirtual 422	java/io/FileReader:close	()V
    //   50: aload_3
    //   51: areturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   57: astore_0
    //   58: getstatic 277	com/tencent/analysis/b:c	Z
    //   61: ifeq +11 -> 72
    //   64: ldc_w 279
    //   67: aload_0
    //   68: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: ldc_w 286
    //   75: areturn
    //   76: astore 4
    //   78: aload_0
    //   79: astore_3
    //   80: aload 5
    //   82: astore_0
    //   83: goto +34 -> 117
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_2
    //   89: goto +113 -> 202
    //   92: astore 4
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_0
    //   97: astore_3
    //   98: aload_1
    //   99: astore_0
    //   100: goto +17 -> 117
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: astore_0
    //   108: goto +94 -> 202
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: astore_3
    //   117: aload_3
    //   118: astore_1
    //   119: aload_0
    //   120: astore_2
    //   121: aload 4
    //   123: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   126: astore 4
    //   128: aload_3
    //   129: astore_1
    //   130: aload_0
    //   131: astore_2
    //   132: getstatic 277	com/tencent/analysis/b:c	Z
    //   135: ifeq +16 -> 151
    //   138: aload_3
    //   139: astore_1
    //   140: aload_0
    //   141: astore_2
    //   142: ldc_w 279
    //   145: aload 4
    //   147: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   150: pop
    //   151: aload_0
    //   152: ifnull +10 -> 162
    //   155: aload_0
    //   156: invokevirtual 265	java/io/BufferedReader:close	()V
    //   159: goto +3 -> 162
    //   162: aload_3
    //   163: ifnull +30 -> 193
    //   166: aload_3
    //   167: invokevirtual 422	java/io/FileReader:close	()V
    //   170: ldc_w 286
    //   173: areturn
    //   174: aload_0
    //   175: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   178: astore_0
    //   179: getstatic 277	com/tencent/analysis/b:c	Z
    //   182: ifeq +11 -> 193
    //   185: ldc_w 279
    //   188: aload_0
    //   189: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: ldc_w 286
    //   196: areturn
    //   197: astore_3
    //   198: aload_1
    //   199: astore_0
    //   200: aload_3
    //   201: astore_1
    //   202: aload_2
    //   203: ifnull +10 -> 213
    //   206: aload_2
    //   207: invokevirtual 265	java/io/BufferedReader:close	()V
    //   210: goto +3 -> 213
    //   213: aload_0
    //   214: ifnull +33 -> 247
    //   217: aload_0
    //   218: invokevirtual 422	java/io/FileReader:close	()V
    //   221: goto +26 -> 247
    //   224: aload_0
    //   225: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   228: astore_0
    //   229: getstatic 277	com/tencent/analysis/b:c	Z
    //   232: ifeq +11 -> 243
    //   235: ldc_w 279
    //   238: aload_0
    //   239: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   242: pop
    //   243: ldc_w 286
    //   246: areturn
    //   247: aload_1
    //   248: athrow
    //   249: astore_0
    //   250: goto -76 -> 174
    //   253: astore_0
    //   254: goto -30 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	37	0	localFileReader1	FileReader
    //   52	2	0	localException1	Exception
    //   57	182	0	localObject1	Object
    //   249	1	0	localException2	Exception
    //   253	1	0	localException3	Exception
    //   22	1	1	localFileReader2	FileReader
    //   86	1	1	localObject2	Object
    //   95	4	1	localObject3	Object
    //   103	1	1	localObject4	Object
    //   118	130	1	localObject5	Object
    //   25	182	2	localObject6	Object
    //   40	127	3	localObject7	Object
    //   197	4	3	localObject8	Object
    //   76	1	4	localException4	Exception
    //   92	1	4	localException5	Exception
    //   111	11	4	localException6	Exception
    //   126	20	4	str	String
    //   19	62	5	localBufferedReader	BufferedReader
    // Exception table:
    //   from	to	target	type
    //   41	50	52	java/lang/Exception
    //   26	41	76	java/lang/Exception
    //   11	21	86	finally
    //   11	21	92	java/lang/Exception
    //   0	11	103	finally
    //   0	11	111	java/lang/Exception
    //   26	41	197	finally
    //   121	128	197	finally
    //   132	138	197	finally
    //   142	151	197	finally
    //   155	159	249	java/lang/Exception
    //   166	170	249	java/lang/Exception
    //   206	210	253	java/lang/Exception
    //   217	221	253	java/lang/Exception
  }
  
  private void r()
  {
    String str1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_qimei", "UNKNOWN");
    if (str1.equals("UNKNOWN"))
    {
      this.a = "UNKNOWN";
      return;
    }
    try
    {
      this.a = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("getQimei Error :");
      localStringBuilder.append(localException.toString());
      String str2 = localStringBuilder.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str2);
      }
    }
  }
  
  private void s()
  {
    Object localObject1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_mac", "UNKNOWN");
    Object localObject3;
    String str3;
    String str1;
    if (((String)localObject1).equals("UNKNOWN"))
    {
      this.c = a();
      localObject1 = this.c;
      if ((localObject1 == null) || (((String)localObject1).equals("")) || (this.c.equals("EXCEPTION")) || (this.c.equals("NOPERMISSION")) || (this.c.equals("UNKNOWN"))) {
        return;
      }
      try
      {
        localObject1 = com.tencent.analysis.a.a;
        localObject3 = c.b();
        str3 = this.c;
        localObject3 = ((d)localObject3).b.c(str3.getBytes());
        ((Context)localObject1).getSharedPreferences("analysis_sdk", 0).edit().putString("key_mac", (String)localObject3).commit();
        return;
      }
      catch (Exception localException1)
      {
        localObject3 = new StringBuilder("getMac Error :");
        ((StringBuilder)localObject3).append(localException1.toString());
        str1 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("BaseInfoUtil", str1);
        }
        return;
      }
    }
    try
    {
      this.c = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
      return;
    }
    catch (Exception localException2)
    {
      localObject3 = new StringBuilder("getQimei Error :");
      ((StringBuilder)localObject3).append(localException2.toString());
      Object localObject2 = ((StringBuilder)localObject3).toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", (String)localObject2);
      }
      this.c = a();
      localObject2 = this.c;
      if ((localObject2 != null) && (!((String)localObject2).equals("")) && (!this.c.equals("EXCEPTION")) && (!this.c.equals("NOPERMISSION")) && (!this.c.equals("UNKNOWN"))) {
        try
        {
          localObject2 = com.tencent.analysis.a.a;
          localObject3 = c.b();
          str3 = this.c;
          localObject3 = ((d)localObject3).b.c(str3.getBytes());
          ((Context)localObject2).getSharedPreferences("analysis_sdk", 0).edit().putString("key_mac", (String)localObject3).commit();
          return;
        }
        catch (Exception localException3)
        {
          localObject3 = new StringBuilder("getMac Error :");
          ((StringBuilder)localObject3).append(localException3.toString());
          String str2 = ((StringBuilder)localObject3).toString();
          if (com.tencent.analysis.b.c) {
            Log.i("BaseInfoUtil", str2);
          }
        }
      }
    }
  }
  
  private void t()
  {
    Object localObject1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_imsi", "UNKNOWN");
    Object localObject3;
    String str3;
    String str1;
    if (((String)localObject1).equals("UNKNOWN"))
    {
      this.d = c();
      localObject1 = this.d;
      if ((localObject1 == null) || (((String)localObject1).equals("")) || (this.d.equals("EXCEPTION")) || (this.d.equals("NOPERMISSION")) || (this.d.equals("UNKNOWN"))) {
        return;
      }
      try
      {
        localObject1 = com.tencent.analysis.a.a;
        localObject3 = c.b();
        str3 = this.d;
        localObject3 = ((d)localObject3).b.c(str3.getBytes());
        ((Context)localObject1).getSharedPreferences("analysis_sdk", 0).edit().putString("key_imsi", (String)localObject3).commit();
        return;
      }
      catch (Exception localException1)
      {
        localObject3 = new StringBuilder("getIMsi Error :");
        ((StringBuilder)localObject3).append(localException1.toString());
        str1 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("BaseInfoUtil", str1);
        }
        return;
      }
    }
    try
    {
      this.d = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
      return;
    }
    catch (Exception localException2)
    {
      localObject3 = new StringBuilder("getQimei Error :");
      ((StringBuilder)localObject3).append(localException2.toString());
      Object localObject2 = ((StringBuilder)localObject3).toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", (String)localObject2);
      }
      this.d = c();
      localObject2 = this.d;
      if ((localObject2 != null) && (!((String)localObject2).equals("")) && (!this.d.equals("EXCEPTION")) && (!this.d.equals("NOPERMISSION")) && (!this.d.equals("UNKNOWN"))) {
        try
        {
          localObject2 = com.tencent.analysis.a.a;
          localObject3 = c.b();
          str3 = this.d;
          localObject3 = ((d)localObject3).b.c(str3.getBytes());
          ((Context)localObject2).getSharedPreferences("analysis_sdk", 0).edit().putString("key_imsi", (String)localObject3).commit();
          return;
        }
        catch (Exception localException3)
        {
          localObject3 = new StringBuilder("getIMsi Error :");
          ((StringBuilder)localObject3).append(localException3.toString());
          String str2 = ((StringBuilder)localObject3).toString();
          if (com.tencent.analysis.b.c) {
            Log.i("BaseInfoUtil", str2);
          }
        }
      }
    }
  }
  
  private static String u()
  {
    String str1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_user", "");
    if (!str1.equals("")) {
      try
      {
        str1 = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
        return str1;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder("getUserId Error :");
        localStringBuilder.append(localException.toString());
        String str2 = localStringBuilder.toString();
        if (com.tencent.analysis.b.c) {
          Log.i("BaseInfoUtil", str2);
        }
      }
    }
    return "";
  }
  
  private static String v()
  {
    Object localObject = com.tencent.analysis.a.a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(com.tencent.analysis.a.a.getPackageName(), 0).versionName;
      return localObject;
    }
    catch (Exception localException)
    {
      String str = localException.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("BaseInfoUtil", str);
      }
    }
    return "EXCEPTION";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.e.a
 * JD-Core Version:    0.7.0.1
 */