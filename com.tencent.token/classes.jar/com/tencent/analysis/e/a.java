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
      this.w = SystemClock.uptimeMillis();
      this.x = SystemClock.elapsedRealtime();
      this.y = u();
      this.z = p();
      this.A = v();
    }
  }
  
  private String a()
  {
    Object localObject3 = "UNKNOWN";
    try
    {
      Object localObject1;
      if (a("android.permission.ACCESS_WIFI_STATE"))
      {
        localObject1 = localObject3;
        if (this.B != null)
        {
          localObject4 = this.B.getConnectionInfo();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((WifiInfo)localObject4).getMacAddress();
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!((String)localObject1).equals("NOPERMISSION")))
        {
          boolean bool = ((String)localObject1).equals("");
          if (!bool) {
            return localObject1;
          }
        }
        try
        {
          localObject1 = new StringBuffer(1000);
          localObject3 = new BufferedReader(new FileReader("/sys/class/net/eth0/address"));
          localObject4 = new char[1024];
          for (;;)
          {
            int i1 = ((BufferedReader)localObject3).read((char[])localObject4);
            if (i1 == -1) {
              break;
            }
            ((StringBuffer)localObject1).append(String.valueOf((char[])localObject4, 0, i1));
          }
          str = "NOPERMISSION";
        }
        catch (Exception localException1)
        {
          return "UNKNOWN";
        }
      }
      ((BufferedReader)localObject3).close();
      String str = str.toString().toUpperCase().substring(0, 17);
      return str;
    }
    catch (Exception localException2)
    {
      localObject3 = "EXCEPTION";
      Object localObject4 = localException2.toString();
      Object localObject2 = localObject3;
      if (com.tencent.analysis.b.c)
      {
        Log.i("BaseInfoUtil", (String)localObject4);
        localObject2 = localObject3;
      }
      return localObject2;
    }
  }
  
  private static boolean a(String paramString)
  {
    if (com.tencent.analysis.a.a == null) {}
    for (;;)
    {
      return false;
      Object localObject = com.tencent.analysis.a.a.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(com.tencent.analysis.a.a.getPackageName(), 4096);
        if ((localObject != null) && (((PackageInfo)localObject).requestedPermissions != null))
        {
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
          if (!com.tencent.analysis.b.c) {}
        }
      }
      catch (Exception paramString)
      {
        paramString = paramString.toString();
      }
    }
    Log.i("BaseInfoUtil", paramString);
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
      String str2 = "EXCEPTION";
      String str3 = localException.toString();
      Object localObject = str2;
      if (com.tencent.analysis.b.c)
      {
        Log.i("BaseInfoUtil", str3);
        localObject = str2;
      }
      return localObject;
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
      String str2 = "EXCEPTION";
      String str3 = localException.toString();
      Object localObject = str2;
      if (com.tencent.analysis.b.c)
      {
        Log.i("BaseInfoUtil", str3);
        localObject = str2;
      }
      return localObject;
    }
  }
  
  private static String d()
  {
    try
    {
      str1 = Settings.Secure.getString(com.tencent.analysis.a.a.getContentResolver(), "android_id");
      return str1;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        String str1 = "EXCEPTION";
        str2 = localException.toString();
      } while (!com.tencent.analysis.b.c);
      Log.i("BaseInfoUtil", str2);
    }
    return "EXCEPTION";
  }
  
  private static String e()
  {
    try
    {
      str1 = Build.MODEL;
      return str1;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        String str1 = "EXCEPTION";
        str2 = localException.toString();
      } while (!com.tencent.analysis.b.c);
      Log.i("BaseInfoUtil", str2);
    }
    return "EXCEPTION";
  }
  
  private static String f()
  {
    try
    {
      str1 = Build.VERSION.RELEASE;
      return str1;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        String str1 = "EXCEPTION";
        str2 = localException.toString();
      } while (!com.tencent.analysis.b.c);
      Log.i("BaseInfoUtil", str2);
    }
    return "EXCEPTION";
  }
  
  private void g()
  {
    String str1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("gpu_user", "UNKNOWN");
    if (str1.equals("UNKNOWN")) {
      this.k = "UNKNOWN";
    }
    String str2;
    do
    {
      return;
      try
      {
        this.k = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
        return;
      }
      catch (Exception localException)
      {
        str2 = "loadGpuInfo Error :" + localException.toString();
      }
    } while (!com.tencent.analysis.b.c);
    Log.i("BaseInfoUtil", str2);
  }
  
  private static String h()
  {
    try
    {
      localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = l2 * l1 / 1024L / 1024L;
      return localObject;
    }
    catch (Exception localException)
    {
      String str;
      do
      {
        Object localObject = "EXCEPTION";
        str = localException.toString();
      } while (!com.tencent.analysis.b.c);
      Log.i("BaseInfoUtil", str);
    }
    return "EXCEPTION";
  }
  
  /* Error */
  private static String i()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 243	java/io/FileReader
    //   5: dup
    //   6: ldc_w 391
    //   9: invokespecial 248	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 241	java/io/BufferedReader
    //   17: dup
    //   18: aload 4
    //   20: sipush 8192
    //   23: invokespecial 394	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 397	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: ldc_w 399
    //   34: iconst_2
    //   35: invokevirtual 403	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   38: iconst_1
    //   39: aaload
    //   40: invokevirtual 406	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   43: ldc_w 408
    //   46: ldc 42
    //   48: invokevirtual 412	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   51: invokevirtual 415	java/lang/String:trim	()Ljava/lang/String;
    //   54: invokestatic 421	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   57: ldc2_w 386
    //   60: ldiv
    //   61: lstore_0
    //   62: new 186	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   69: lload_0
    //   70: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_3
    //   77: aload_2
    //   78: invokevirtual 265	java/io/BufferedReader:close	()V
    //   81: aload 4
    //   83: invokevirtual 422	java/io/FileReader:close	()V
    //   86: aload_3
    //   87: astore_2
    //   88: aload_2
    //   89: areturn
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   95: astore_2
    //   96: getstatic 279	com/tencent/analysis/b:c	Z
    //   99: ifeq +11 -> 110
    //   102: ldc_w 281
    //   105: aload_2
    //   106: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   109: pop
    //   110: ldc_w 275
    //   113: areturn
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_2
    //   118: aload 4
    //   120: invokevirtual 276	java/lang/Exception:toString	()Ljava/lang/String;
    //   123: astore 4
    //   125: getstatic 279	com/tencent/analysis/b:c	Z
    //   128: ifeq +12 -> 140
    //   131: ldc_w 281
    //   134: aload 4
    //   136: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   139: pop
    //   140: ldc_w 275
    //   143: astore 4
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 265	java/io/BufferedReader:close	()V
    //   153: aload 4
    //   155: astore_2
    //   156: aload_3
    //   157: ifnull -69 -> 88
    //   160: aload_3
    //   161: invokevirtual 422	java/io/FileReader:close	()V
    //   164: ldc_w 275
    //   167: areturn
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   173: astore_2
    //   174: getstatic 279	com/tencent/analysis/b:c	Z
    //   177: ifeq +11 -> 188
    //   180: ldc_w 281
    //   183: aload_2
    //   184: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: ldc_w 275
    //   191: areturn
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: aconst_null
    //   196: astore 4
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 265	java/io/BufferedReader:close	()V
    //   206: aload 4
    //   208: ifnull +8 -> 216
    //   211: aload 4
    //   213: invokevirtual 422	java/io/FileReader:close	()V
    //   216: aload_3
    //   217: athrow
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   223: astore_2
    //   224: getstatic 279	com/tencent/analysis/b:c	Z
    //   227: ifeq +11 -> 238
    //   230: ldc_w 281
    //   233: aload_2
    //   234: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   237: pop
    //   238: ldc_w 275
    //   241: areturn
    //   242: astore_3
    //   243: aconst_null
    //   244: astore_2
    //   245: goto -47 -> 198
    //   248: astore_3
    //   249: goto -51 -> 198
    //   252: astore 5
    //   254: aload_3
    //   255: astore 4
    //   257: aload 5
    //   259: astore_3
    //   260: goto -62 -> 198
    //   263: astore 5
    //   265: aconst_null
    //   266: astore_2
    //   267: aload 4
    //   269: astore_3
    //   270: aload 5
    //   272: astore 4
    //   274: goto -156 -> 118
    //   277: astore 5
    //   279: aload 4
    //   281: astore_3
    //   282: aload 5
    //   284: astore 4
    //   286: goto -168 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   61	9	0	l1	long
    //   26	63	2	localObject1	Object
    //   90	2	2	localIOException1	java.io.IOException
    //   95	61	2	localObject2	Object
    //   168	2	2	localIOException2	java.io.IOException
    //   173	30	2	str1	String
    //   218	2	2	localIOException3	java.io.IOException
    //   223	44	2	str2	String
    //   1	160	3	str3	String
    //   192	25	3	localObject3	Object
    //   242	1	3	localObject4	Object
    //   248	7	3	localObject5	Object
    //   259	23	3	localObject6	Object
    //   12	70	4	localFileReader	FileReader
    //   114	5	4	localException1	Exception
    //   123	162	4	localObject7	Object
    //   252	6	5	localObject8	Object
    //   263	8	5	localException2	Exception
    //   277	6	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   77	86	90	java/io/IOException
    //   2	14	114	java/lang/Exception
    //   149	153	168	java/io/IOException
    //   160	164	168	java/io/IOException
    //   2	14	192	finally
    //   202	206	218	java/io/IOException
    //   211	216	218	java/io/IOException
    //   14	27	242	finally
    //   27	77	248	finally
    //   118	140	252	finally
    //   14	27	263	java/lang/Exception
    //   27	77	277	java/lang/Exception
  }
  
  private static String j()
  {
    try
    {
      str1 = Locale.getDefault().getCountry();
      return str1;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        String str1 = "EXCEPTION";
        str2 = localException.toString();
      } while (!com.tencent.analysis.b.c);
      Log.i("BaseInfoUtil", str2);
    }
    return "EXCEPTION";
  }
  
  private static String k()
  {
    try
    {
      str1 = Locale.getDefault().getLanguage();
      return str1;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        String str1 = "EXCEPTION";
        str2 = localException.toString();
      } while (!com.tencent.analysis.b.c);
      Log.i("BaseInfoUtil", str2);
    }
    return "EXCEPTION";
  }
  
  private static String l()
  {
    if (com.tencent.analysis.b.c) {
      Log.i("BaseInfoUtil", "getSensor start");
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    for (;;)
    {
      int i2;
      int i3;
      int i1;
      label280:
      int i5;
      try
      {
        Class localClass = Class.forName("android.hardware.Camera");
        i2 = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        String str1;
        if (i2 == 0)
        {
          str1 = "N";
          localObject2 = "N";
          localObject4 = (SensorManager)com.tencent.analysis.a.a.getSystemService("sensor");
          if (((SensorManager)localObject4).getDefaultSensor(1) == null) {
            break label487;
          }
          localObject3 = "Y";
          if (((SensorManager)localObject4).getDefaultSensor(4) != null)
          {
            localObject4 = "Y";
            localStringBuffer.append((String)localObject2).append(str1).append((String)localObject3).append((String)localObject4);
            if (com.tencent.analysis.b.c) {
              Log.i("BaseInfoUtil", "getSensor End");
            }
            return localStringBuffer.toString();
          }
        }
        else
        {
          localObject2 = Class.forName("android.hardware.Camera$CameraInfo");
          Object localObject5 = ((Class)localObject2).newInstance();
          localObject3 = localClass.getMethods();
          str1 = null;
          i3 = localObject3.length;
          i1 = 0;
          localObject4 = str1;
          if (i1 < i3)
          {
            localObject4 = localObject3[i1];
            if (!((Method)localObject4).getName().equals("getCameraInfo")) {
              break label440;
            }
          }
          Field localField1 = ((Class)localObject2).getField("facing");
          Field localField2 = ((Class)localObject2).getField("CAMERA_FACING_BACK");
          Field localField3 = ((Class)localObject2).getField("CAMERA_FACING_FRONT");
          if (localObject4 == null) {
            break label416;
          }
          localObject2 = "X";
          str1 = "X";
          i1 = 0;
          if (i1 >= i2) {
            break label401;
          }
          ((Method)localObject4).invoke(localClass, new Object[] { Integer.valueOf(i1), localObject5 });
          i3 = localField1.getInt(localObject5);
          int i4 = localField2.getInt(localObject5);
          i5 = localField3.getInt(localObject5);
          if (i3 != i4) {
            break label447;
          }
          str1 = "Y";
          localObject3 = str1;
          if (i2 != 1) {
            break label429;
          }
          localObject2 = "N";
          localObject3 = str1;
          break label429;
        }
        Object localObject4 = "N";
        continue;
        localObject3 = localObject1;
      }
      catch (Exception localException)
      {
        localObject1 = localException.toString();
        if (com.tencent.analysis.b.c) {
          Log.i("BaseInfoUtil", (String)localObject1);
        }
        return "EXCEPTION";
      }
      label401:
      Object localObject1 = localObject2;
      Object localObject2 = localObject3;
      continue;
      label416:
      localObject2 = "X";
      localObject1 = "X";
      continue;
      for (;;)
      {
        label429:
        i1 += 1;
        localObject1 = localObject3;
        break label280;
        label440:
        i1 += 1;
        break;
        label447:
        localObject3 = localObject1;
        if (i3 == i5)
        {
          String str2 = "Y";
          localObject2 = str2;
          localObject3 = localObject1;
          if (i2 == 1)
          {
            localObject3 = "N";
            localObject2 = str2;
          }
        }
      }
      label487:
      Object localObject3 = "N";
    }
  }
  
  private static String m()
  {
    Object localObject = com.tencent.analysis.a.a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(com.tencent.analysis.a.a.getPackageName(), 0);
      localObject = ((PackageInfo)localObject).versionCode;
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
      str1 = Build.BRAND;
      return str1;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        String str1 = "EXCEPTION";
        str2 = localException.toString();
      } while (!com.tencent.analysis.b.c);
      Log.i("BaseInfoUtil", str2);
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
    Object localObject2;
    try
    {
      Object localObject1;
      if (a("android.permission.ACCESS_NETWORK_STATE"))
      {
        localObject1 = ((ConnectivityManager)com.tencent.analysis.a.a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject1 == null) {
          return "UNKNOWN";
        }
        if (((NetworkInfo)localObject1).getType() == 1)
        {
          localObject1 = "wifi";
          break label163;
        }
        if ((((NetworkInfo)localObject1).getType() != 0) || (this.C == null)) {}
      }
      else
      {
        switch (this.C.getNetworkType())
        {
        default: 
          localObject1 = "NOPERMISSION";
        }
      }
    }
    catch (Exception localException)
    {
      String str1 = "EXCEPTION";
      String str2 = localException.toString();
      localObject2 = str1;
      if (com.tencent.analysis.b.c)
      {
        Log.i("BaseInfoUtil", str2);
        localObject2 = str1;
        break label163;
        localObject2 = "UNKNOWN";
      }
    }
    for (;;)
    {
      label163:
      return localObject2;
      localObject2 = "UNKNOWN";
      continue;
      localObject2 = "GPRS";
      continue;
      localObject2 = "EDGE";
      continue;
      localObject2 = "UMTS";
      continue;
      localObject2 = "HSDPA";
      continue;
      localObject2 = "HSUPA";
      continue;
      localObject2 = "HSPA";
      continue;
      localObject2 = "CDMA";
      continue;
      localObject2 = "CDMA - EvDo rev. 0";
      continue;
      localObject2 = "CDMA - EvDo rev. A";
      continue;
      localObject2 = "CDMA - 1xRTT";
    }
  }
  
  /* Error */
  private static String q()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 5
    //   7: new 243	java/io/FileReader
    //   10: dup
    //   11: ldc_w 573
    //   14: invokespecial 248	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: astore_1
    //   20: aload_3
    //   21: astore_2
    //   22: new 241	java/io/BufferedReader
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 251	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 397	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: ldc_w 399
    //   38: iconst_2
    //   39: invokevirtual 403	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   42: iconst_1
    //   43: aaload
    //   44: astore_1
    //   45: aload_3
    //   46: invokevirtual 265	java/io/BufferedReader:close	()V
    //   49: aload_0
    //   50: invokevirtual 422	java/io/FileReader:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 276	java/lang/Exception:toString	()Ljava/lang/String;
    //   60: astore_0
    //   61: getstatic 279	com/tencent/analysis/b:c	Z
    //   64: ifeq +11 -> 75
    //   67: ldc_w 281
    //   70: aload_0
    //   71: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: ldc_w 275
    //   78: areturn
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_0
    //   83: aload 5
    //   85: astore_3
    //   86: aload_0
    //   87: astore_1
    //   88: aload_3
    //   89: astore_2
    //   90: aload 4
    //   92: invokevirtual 276	java/lang/Exception:toString	()Ljava/lang/String;
    //   95: astore 4
    //   97: aload_0
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: getstatic 279	com/tencent/analysis/b:c	Z
    //   104: ifeq +16 -> 120
    //   107: aload_0
    //   108: astore_1
    //   109: aload_3
    //   110: astore_2
    //   111: ldc_w 281
    //   114: aload 4
    //   116: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: ldc_w 275
    //   123: astore_1
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 265	java/io/BufferedReader:close	()V
    //   132: aload_0
    //   133: ifnull -80 -> 53
    //   136: aload_0
    //   137: invokevirtual 422	java/io/FileReader:close	()V
    //   140: ldc_w 275
    //   143: areturn
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 276	java/lang/Exception:toString	()Ljava/lang/String;
    //   149: astore_0
    //   150: getstatic 279	com/tencent/analysis/b:c	Z
    //   153: ifeq +11 -> 164
    //   156: ldc_w 281
    //   159: aload_0
    //   160: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: ldc_w 275
    //   167: areturn
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 265	java/io/BufferedReader:close	()V
    //   179: aload_0
    //   180: ifnull +7 -> 187
    //   183: aload_0
    //   184: invokevirtual 422	java/io/FileReader:close	()V
    //   187: aload_3
    //   188: athrow
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 276	java/lang/Exception:toString	()Ljava/lang/String;
    //   194: astore_0
    //   195: getstatic 279	com/tencent/analysis/b:c	Z
    //   198: ifeq +11 -> 209
    //   201: ldc_w 281
    //   204: aload_0
    //   205: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   208: pop
    //   209: ldc_w 275
    //   212: areturn
    //   213: astore_3
    //   214: aload_1
    //   215: astore_0
    //   216: goto -45 -> 171
    //   219: astore_1
    //   220: aload_3
    //   221: astore_2
    //   222: aload_1
    //   223: astore_3
    //   224: goto -53 -> 171
    //   227: astore 4
    //   229: aload 5
    //   231: astore_3
    //   232: goto -146 -> 86
    //   235: astore 4
    //   237: goto -151 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	33	0	localFileReader	FileReader
    //   55	2	0	localException1	Exception
    //   60	77	0	str1	String
    //   144	2	0	localException2	Exception
    //   149	35	0	str2	String
    //   189	2	0	localException3	Exception
    //   194	22	0	localObject1	Object
    //   19	196	1	localObject2	Object
    //   219	4	1	localObject3	Object
    //   1	221	2	localObject4	Object
    //   3	126	3	localObject5	Object
    //   168	20	3	localObject6	Object
    //   213	8	3	localObject7	Object
    //   223	9	3	localObject8	Object
    //   79	12	4	localException4	Exception
    //   95	20	4	str3	String
    //   227	1	4	localException5	Exception
    //   235	1	4	localException6	Exception
    //   5	225	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   45	53	55	java/lang/Exception
    //   7	18	79	java/lang/Exception
    //   128	132	144	java/lang/Exception
    //   136	140	144	java/lang/Exception
    //   7	18	168	finally
    //   175	179	189	java/lang/Exception
    //   183	187	189	java/lang/Exception
    //   22	31	213	finally
    //   90	97	213	finally
    //   101	107	213	finally
    //   111	120	213	finally
    //   31	45	219	finally
    //   22	31	227	java/lang/Exception
    //   31	45	235	java/lang/Exception
  }
  
  private void r()
  {
    String str1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_qimei", "UNKNOWN");
    if (str1.equals("UNKNOWN")) {
      this.a = "UNKNOWN";
    }
    String str2;
    do
    {
      return;
      try
      {
        this.a = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
        return;
      }
      catch (Exception localException)
      {
        str2 = "getQimei Error :" + localException.toString();
      }
    } while (!com.tencent.analysis.b.c);
    Log.i("BaseInfoUtil", str2);
  }
  
  private void s()
  {
    Object localObject1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_mac", "UNKNOWN");
    if (((String)localObject1).equals("UNKNOWN"))
    {
      this.c = a();
      if ((this.c == null) || (this.c.equals("")) || (this.c.equals("EXCEPTION")) || (this.c.equals("NOPERMISSION")) || (this.c.equals("UNKNOWN"))) {}
    }
    String str2;
    do
    {
      Object localObject3;
      String str3;
      Object localObject2;
      do
      {
        String str1;
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
          do
          {
            str1 = "getMac Error :" + localException1.toString();
          } while (!com.tencent.analysis.b.c);
          Log.i("BaseInfoUtil", str1);
          return;
        }
        try
        {
          this.c = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
          return;
        }
        catch (Exception localException2)
        {
          localObject2 = "getQimei Error :" + localException2.toString();
          if (com.tencent.analysis.b.c) {
            Log.i("BaseInfoUtil", (String)localObject2);
          }
          this.c = a();
        }
      } while ((this.c == null) || (this.c.equals("")) || (this.c.equals("EXCEPTION")) || (this.c.equals("NOPERMISSION")) || (this.c.equals("UNKNOWN")));
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
        str2 = "getMac Error :" + localException3.toString();
      }
    } while (!com.tencent.analysis.b.c);
    Log.i("BaseInfoUtil", str2);
  }
  
  private void t()
  {
    Object localObject1 = com.tencent.analysis.a.a.getSharedPreferences("analysis_sdk", 0).getString("key_imsi", "UNKNOWN");
    if (((String)localObject1).equals("UNKNOWN"))
    {
      this.d = c();
      if ((this.d == null) || (this.d.equals("")) || (this.d.equals("EXCEPTION")) || (this.d.equals("NOPERMISSION")) || (this.d.equals("UNKNOWN"))) {}
    }
    String str2;
    do
    {
      Object localObject3;
      String str3;
      Object localObject2;
      do
      {
        String str1;
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
          do
          {
            str1 = "getIMsi Error :" + localException1.toString();
          } while (!com.tencent.analysis.b.c);
          Log.i("BaseInfoUtil", str1);
          return;
        }
        try
        {
          this.d = new String(c.b().b.a(com.tencent.analysis.d.a.b.a(str1)), "UTF-8");
          return;
        }
        catch (Exception localException2)
        {
          localObject2 = "getQimei Error :" + localException2.toString();
          if (com.tencent.analysis.b.c) {
            Log.i("BaseInfoUtil", (String)localObject2);
          }
          this.d = c();
        }
      } while ((this.d == null) || (this.d.equals("")) || (this.d.equals("EXCEPTION")) || (this.d.equals("NOPERMISSION")) || (this.d.equals("UNKNOWN")));
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
        str2 = "getIMsi Error :" + localException3.toString();
      }
    } while (!com.tencent.analysis.b.c);
    Log.i("BaseInfoUtil", str2);
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
        String str2 = "getUserId Error :" + localException.toString();
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