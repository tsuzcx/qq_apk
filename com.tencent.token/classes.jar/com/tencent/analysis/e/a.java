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
    try
    {
      if (!a("android.permission.ACCESS_WIFI_STATE")) {
        break label178;
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
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        boolean bool;
        continue;
        String str = "NOPERMISSION";
      }
    }
    if ((localObject1 != null) && (!((String)localObject1).equals("NOPERMISSION")))
    {
      bool = ((String)localObject1).equals("");
      if (!bool) {
        break label168;
      }
    }
    try
    {
      localObject1 = new StringBuffer(1000);
      localObject2 = new BufferedReader(new FileReader("/sys/class/net/eth0/address"));
      localObject3 = new char[1024];
      for (;;)
      {
        int i1 = ((BufferedReader)localObject2).read((char[])localObject3);
        if (i1 == -1) {
          break;
        }
        ((StringBuffer)localObject1).append(String.valueOf((char[])localObject3, 0, i1));
      }
      ((BufferedReader)localObject2).close();
      localObject1 = ((StringBuffer)localObject1).toString().toUpperCase().substring(0, 17);
      return localObject1;
    }
    catch (Exception localException2)
    {
      label157:
      label168:
      break label157;
    }
    return "UNKNOWN";
    localObject1 = "EXCEPTION";
    bool = com.tencent.analysis.b.c;
    return localObject1;
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
          bool = localObject[i1].equals(paramString);
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
      boolean bool;
      label89:
      break label89;
    }
    bool = com.tencent.analysis.b.c;
    return false;
  }
  
  private String b()
  {
    String str = "UNKNOWN";
    try
    {
      if (a("android.permission.READ_PHONE_STATE"))
      {
        if (this.C == null) {
          break label38;
        }
        return this.C.getDeviceId();
      }
      return "NOPERMISSION";
    }
    catch (Exception localException)
    {
      label30:
      boolean bool;
      break label30;
    }
    str = "EXCEPTION";
    bool = com.tencent.analysis.b.c;
    label38:
    return str;
  }
  
  private String c()
  {
    String str = "UNKNOWN";
    try
    {
      if (a("android.permission.READ_PHONE_STATE"))
      {
        if (this.C == null) {
          break label38;
        }
        return this.C.getSubscriberId();
      }
      return "NOPERMISSION";
    }
    catch (Exception localException)
    {
      label30:
      boolean bool;
      break label30;
    }
    str = "EXCEPTION";
    bool = com.tencent.analysis.b.c;
    label38:
    return str;
  }
  
  private static String d()
  {
    try
    {
      String str = Settings.Secure.getString(com.tencent.analysis.a.a.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException)
    {
      label15:
      boolean bool;
      break label15;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
  
  private static String e()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Exception localException)
    {
      label6:
      boolean bool;
      break label6;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
  
  private static String f()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Exception localException)
    {
      label6:
      boolean bool;
      break label6;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
  
  private void g()
  {
    String str = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("gpu_user", "UNKNOWN");
    if (str.equals("UNKNOWN"))
    {
      this.k = "UNKNOWN";
      return;
    }
    try
    {
      this.k = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str)), "UTF-8");
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("loadGpuInfo Error :").append(localException.toString());
      boolean bool = com.tencent.analysis.b.c;
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
      label65:
      boolean bool;
      break label65;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
  
  /* Error */
  private static String i()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: new 243	java/io/FileReader
    //   9: dup
    //   10: ldc_w 384
    //   13: invokespecial 248	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: aload_3
    //   18: astore 4
    //   20: new 241	java/io/BufferedReader
    //   23: dup
    //   24: aload_3
    //   25: sipush 8192
    //   28: invokespecial 387	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 6
    //   33: aload 6
    //   35: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: ldc_w 392
    //   41: iconst_2
    //   42: invokevirtual 396	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   45: iconst_1
    //   46: aaload
    //   47: invokevirtual 399	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   50: ldc_w 401
    //   53: ldc 42
    //   55: invokevirtual 405	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   58: invokevirtual 408	java/lang/String:trim	()Ljava/lang/String;
    //   61: invokestatic 414	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   64: ldc2_w 379
    //   67: ldiv
    //   68: lstore_0
    //   69: aload 6
    //   71: invokevirtual 265	java/io/BufferedReader:close	()V
    //   74: aload_3
    //   75: invokevirtual 415	java/io/FileReader:close	()V
    //   78: lload_0
    //   79: invokestatic 418	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: areturn
    //   83: getstatic 278	com/tencent/analysis/b:c	Z
    //   86: istore_2
    //   87: ldc_w 275
    //   90: areturn
    //   91: astore 4
    //   93: aload 6
    //   95: astore 5
    //   97: aload 4
    //   99: astore 6
    //   101: goto +55 -> 156
    //   104: goto +19 -> 123
    //   107: astore 6
    //   109: aconst_null
    //   110: astore_3
    //   111: aload_3
    //   112: astore 5
    //   114: goto +42 -> 156
    //   117: aconst_null
    //   118: astore_3
    //   119: aload 7
    //   121: astore 6
    //   123: aload 6
    //   125: astore 5
    //   127: aload_3
    //   128: astore 4
    //   130: getstatic 278	com/tencent/analysis/b:c	Z
    //   133: istore_2
    //   134: aload 6
    //   136: ifnull +8 -> 144
    //   139: aload 6
    //   141: invokevirtual 265	java/io/BufferedReader:close	()V
    //   144: aload_3
    //   145: ifnull +54 -> 199
    //   148: aload_3
    //   149: invokevirtual 415	java/io/FileReader:close	()V
    //   152: ldc_w 275
    //   155: areturn
    //   156: aload 5
    //   158: ifnull +8 -> 166
    //   161: aload 5
    //   163: invokevirtual 265	java/io/BufferedReader:close	()V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 415	java/io/FileReader:close	()V
    //   174: aload 6
    //   176: athrow
    //   177: astore_3
    //   178: goto -61 -> 117
    //   181: astore 4
    //   183: aload 7
    //   185: astore 6
    //   187: goto -64 -> 123
    //   190: astore 4
    //   192: goto -88 -> 104
    //   195: astore_3
    //   196: goto -113 -> 83
    //   199: ldc_w 275
    //   202: areturn
    //   203: astore 6
    //   205: aload 4
    //   207: astore_3
    //   208: goto -52 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   68	11	0	l1	long
    //   86	48	2	bool	boolean
    //   16	155	3	localFileReader1	FileReader
    //   177	1	3	localException1	Exception
    //   195	1	3	localIOException	java.io.IOException
    //   207	1	3	localObject1	Object
    //   18	1	4	localFileReader2	FileReader
    //   91	7	4	localObject2	Object
    //   128	1	4	localFileReader3	FileReader
    //   181	1	4	localException2	Exception
    //   190	16	4	localException3	Exception
    //   1	161	5	localObject3	Object
    //   31	69	6	localObject4	Object
    //   107	1	6	localObject5	Object
    //   121	65	6	localObject6	Object
    //   203	1	6	localObject7	Object
    //   4	180	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   33	69	91	finally
    //   6	17	107	finally
    //   6	17	177	java/lang/Exception
    //   20	33	181	java/lang/Exception
    //   33	69	190	java/lang/Exception
    //   69	78	195	java/io/IOException
    //   139	144	195	java/io/IOException
    //   148	152	195	java/io/IOException
    //   161	166	195	java/io/IOException
    //   170	174	195	java/io/IOException
    //   20	33	203	finally
    //   130	134	203	finally
  }
  
  private static String j()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Exception localException)
    {
      label9:
      boolean bool;
      break label9;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
  
  private static String k()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Exception localException)
    {
      label9:
      boolean bool;
      break label9;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
  
  private static String l()
  {
    boolean bool = com.tencent.analysis.b.c;
    Object localObject1 = "X";
    localObject3 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    try
    {
      localClass = Class.forName("android.hardware.Camera");
      i2 = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
      if (i2 == 0)
      {
        localObject1 = "N";
        localObject3 = "N";
        break label283;
      }
      localObject6 = Class.forName("android.hardware.Camera$CameraInfo");
      localObject7 = ((Class)localObject6).newInstance();
      localObject8 = localClass.getMethods();
      localObject4 = null;
      i3 = localObject8.length;
      i1 = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Class localClass;
        int i2;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        int i3;
        int i1;
        Field localField1;
        Field localField2;
        int i4;
        int i5;
        label283:
        label375:
        continue;
        i1 += 1;
        continue;
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
        i1 += 1;
        Object localObject4 = localObject2;
        continue;
        localObject2 = localObject4;
        continue;
        localObject4 = "N";
        continue;
        Object localObject5 = "N";
      }
    }
    localObject5 = localObject4;
    if (i1 < i3)
    {
      localObject5 = localObject8[i1];
      if (!((Method)localObject5).getName().equals("getCameraInfo")) {
        break label391;
      }
    }
    localObject8 = ((Class)localObject6).getField("facing");
    localField1 = ((Class)localObject6).getField("CAMERA_FACING_BACK");
    localField2 = ((Class)localObject6).getField("CAMERA_FACING_FRONT");
    if (localObject5 != null)
    {
      localObject3 = "X";
      localObject4 = "X";
      i1 = 0;
      if (i1 >= i2) {
        break label446;
      }
      ((Method)localObject5).invoke(localClass, new Object[] { Integer.valueOf(i1), localObject7 });
      i3 = ((Field)localObject8).getInt(localObject7);
      i4 = localField1.getInt(localObject7);
      i5 = localField2.getInt(localObject7);
      if (i3 == i4)
      {
        localObject4 = "Y";
        localObject1 = localObject4;
        if (i2 != 1) {
          break label435;
        }
        localObject3 = "N";
        localObject1 = localObject4;
        break label435;
      }
    }
    else
    {
      localObject5 = (SensorManager)com.tencent.analysis.a.a.getSystemService("sensor");
      if (((SensorManager)localObject5).getDefaultSensor(1) == null) {
        break label453;
      }
      localObject4 = "Y";
      if (((SensorManager)localObject5).getDefaultSensor(4) == null) {
        break label461;
      }
      localObject5 = "Y";
      localStringBuffer.append((String)localObject1);
      localStringBuffer.append((String)localObject3);
      localStringBuffer.append((String)localObject4);
      localStringBuffer.append((String)localObject5);
      break label375;
      bool = com.tencent.analysis.b.c;
      return "EXCEPTION";
      bool = com.tencent.analysis.b.c;
      return localStringBuffer.toString();
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
      label43:
      boolean bool;
      break label43;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
  
  private static String n()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Exception localException)
    {
      label6:
      boolean bool;
      break label6;
    }
    bool = com.tencent.analysis.b.c;
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
    String str2 = "UNKNOWN";
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
        str1 = str2;
        if (localNetworkInfo.getType() != 0) {
          break label139;
        }
        str1 = str2;
        if (this.C == null) {
          break label139;
        }
      }
      switch (this.C.getNetworkType())
      {
      default: 
        return "NOPERMISSION";
      }
    }
    catch (Exception localException)
    {
      String str1;
      label131:
      boolean bool;
      break label131;
      return "UNKNOWN";
    }
    str1 = "EXCEPTION";
    bool = com.tencent.analysis.b.c;
    label139:
    return str1;
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
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 243	java/io/FileReader
    //   8: dup
    //   9: ldc_w 564
    //   12: invokespecial 248	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_2
    //   18: new 241	java/io/BufferedReader
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 251	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: ldc_w 392
    //   36: iconst_2
    //   37: invokevirtual 396	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   40: iconst_1
    //   41: aaload
    //   42: astore_2
    //   43: aload 4
    //   45: invokevirtual 265	java/io/BufferedReader:close	()V
    //   48: aload_1
    //   49: invokevirtual 415	java/io/FileReader:close	()V
    //   52: aload_2
    //   53: areturn
    //   54: getstatic 278	com/tencent/analysis/b:c	Z
    //   57: istore_0
    //   58: ldc_w 275
    //   61: areturn
    //   62: astore_3
    //   63: aload 4
    //   65: astore_2
    //   66: goto +51 -> 117
    //   69: goto +17 -> 86
    //   72: astore_3
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: astore_1
    //   77: goto +40 -> 117
    //   80: aconst_null
    //   81: astore_1
    //   82: aload 5
    //   84: astore 4
    //   86: aload 4
    //   88: astore_3
    //   89: aload_1
    //   90: astore_2
    //   91: getstatic 278	com/tencent/analysis/b:c	Z
    //   94: istore_0
    //   95: aload 4
    //   97: ifnull +8 -> 105
    //   100: aload 4
    //   102: invokevirtual 265	java/io/BufferedReader:close	()V
    //   105: aload_1
    //   106: ifnull +49 -> 155
    //   109: aload_1
    //   110: invokevirtual 415	java/io/FileReader:close	()V
    //   113: ldc_w 275
    //   116: areturn
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 265	java/io/BufferedReader:close	()V
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 415	java/io/FileReader:close	()V
    //   133: aload_3
    //   134: athrow
    //   135: astore_1
    //   136: goto -56 -> 80
    //   139: astore_2
    //   140: aload 5
    //   142: astore 4
    //   144: goto -58 -> 86
    //   147: astore_2
    //   148: goto -79 -> 69
    //   151: astore_1
    //   152: goto -98 -> 54
    //   155: ldc_w 275
    //   158: areturn
    //   159: astore_1
    //   160: aload_3
    //   161: astore 4
    //   163: aload_1
    //   164: astore_3
    //   165: aload_2
    //   166: astore_1
    //   167: aload 4
    //   169: astore_2
    //   170: goto -53 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   57	38	0	bool	boolean
    //   15	115	1	localObject1	Object
    //   135	1	1	localException1	Exception
    //   151	1	1	localException2	Exception
    //   159	5	1	localObject2	Object
    //   166	1	1	localObject3	Object
    //   17	105	2	localObject4	Object
    //   139	1	2	localException3	Exception
    //   147	19	2	localException4	Exception
    //   169	1	2	localObject5	Object
    //   1	1	3	localObject6	Object
    //   62	1	3	localObject7	Object
    //   72	1	3	localObject8	Object
    //   88	77	3	localObject9	Object
    //   26	142	4	localObject10	Object
    //   3	138	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   28	43	62	finally
    //   5	16	72	finally
    //   5	16	135	java/lang/Exception
    //   18	28	139	java/lang/Exception
    //   28	43	147	java/lang/Exception
    //   43	52	151	java/lang/Exception
    //   100	105	151	java/lang/Exception
    //   109	113	151	java/lang/Exception
    //   121	125	151	java/lang/Exception
    //   129	133	151	java/lang/Exception
    //   18	28	159	finally
    //   91	95	159	finally
  }
  
  private void r()
  {
    String str = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_qimei", "UNKNOWN");
    if (str.equals("UNKNOWN"))
    {
      this.a = "UNKNOWN";
      return;
    }
    try
    {
      this.a = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str)), "UTF-8");
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("getQimei Error :").append(localException.toString());
      boolean bool = com.tencent.analysis.b.c;
    }
  }
  
  private void s()
  {
    Object localObject1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_mac", "UNKNOWN");
    Object localObject3;
    String str;
    boolean bool;
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
        str = this.c;
        localObject3 = ((d)localObject3).b.c(str.getBytes());
        ((Context)localObject1).getSharedPreferences("analysis_sdk", 0).edit().putString("key_mac", (String)localObject3).commit();
        return;
      }
      catch (Exception localException1)
      {
        new StringBuilder("getMac Error :").append(localException1.toString());
        bool = com.tencent.analysis.b.c;
        return;
      }
    }
    try
    {
      this.c = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(localException1)), "UTF-8");
      return;
    }
    catch (Exception localException2)
    {
      new StringBuilder("getQimei Error :").append(localException2.toString());
      bool = com.tencent.analysis.b.c;
      this.c = a();
      Object localObject2 = this.c;
      if ((localObject2 != null) && (!((String)localObject2).equals("")) && (!this.c.equals("EXCEPTION")) && (!this.c.equals("NOPERMISSION")) && (!this.c.equals("UNKNOWN"))) {
        try
        {
          localObject2 = com.tencent.analysis.a.a;
          localObject3 = c.b();
          str = this.c;
          localObject3 = ((d)localObject3).b.c(str.getBytes());
          ((Context)localObject2).getSharedPreferences("analysis_sdk", 0).edit().putString("key_mac", (String)localObject3).commit();
          return;
        }
        catch (Exception localException3)
        {
          new StringBuilder("getMac Error :").append(localException3.toString());
          bool = com.tencent.analysis.b.c;
        }
      }
    }
  }
  
  private void t()
  {
    Object localObject1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_imsi", "UNKNOWN");
    Object localObject3;
    String str;
    boolean bool;
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
        str = this.d;
        localObject3 = ((d)localObject3).b.c(str.getBytes());
        ((Context)localObject1).getSharedPreferences("analysis_sdk", 0).edit().putString("key_imsi", (String)localObject3).commit();
        return;
      }
      catch (Exception localException1)
      {
        new StringBuilder("getIMsi Error :").append(localException1.toString());
        bool = com.tencent.analysis.b.c;
        return;
      }
    }
    try
    {
      this.d = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(localException1)), "UTF-8");
      return;
    }
    catch (Exception localException2)
    {
      new StringBuilder("getQimei Error :").append(localException2.toString());
      bool = com.tencent.analysis.b.c;
      this.d = c();
      Object localObject2 = this.d;
      if ((localObject2 != null) && (!((String)localObject2).equals("")) && (!this.d.equals("EXCEPTION")) && (!this.d.equals("NOPERMISSION")) && (!this.d.equals("UNKNOWN"))) {
        try
        {
          localObject2 = com.tencent.analysis.a.a;
          localObject3 = c.b();
          str = this.d;
          localObject3 = ((d)localObject3).b.c(str.getBytes());
          ((Context)localObject2).getSharedPreferences("analysis_sdk", 0).edit().putString("key_imsi", (String)localObject3).commit();
          return;
        }
        catch (Exception localException3)
        {
          new StringBuilder("getIMsi Error :").append(localException3.toString());
          bool = com.tencent.analysis.b.c;
        }
      }
    }
  }
  
  private static String u()
  {
    String str = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_user", "");
    if (!str.equals("")) {
      try
      {
        str = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str)), "UTF-8");
        return str;
      }
      catch (Exception localException)
      {
        new StringBuilder("getUserId Error :").append(localException.toString());
        boolean bool = com.tencent.analysis.b.c;
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
      label24:
      boolean bool;
      break label24;
    }
    bool = com.tencent.analysis.b.c;
    return "EXCEPTION";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.e.a
 * JD-Core Version:    0.7.0.1
 */