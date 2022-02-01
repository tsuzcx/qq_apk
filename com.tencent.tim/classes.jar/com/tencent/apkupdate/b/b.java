package com.tencent.apkupdate.b;

import alkz;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.protocol.jce.Terminal;

public class b
{
  private static b a = null;
  private static String c = "";
  private static int d = 0;
  private static Terminal e = null;
  private Context b;
  
  public static int a(Context paramContext, String paramString)
  {
    int j = 0;
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramString)) {
        paramContext = paramContext.getPackageManager();
      }
    }
    try
    {
      i = paramContext.getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static byte c()
  {
    if (!TextUtils.isEmpty(Proxy.getDefaultHost())) {}
    for (int i = 1;; i = 0) {
      return (byte)i;
    }
  }
  
  public static int c(Context paramContext)
  {
    int i = 0;
    PackageManager localPackageManager;
    if (paramContext != null) {
      localPackageManager = paramContext.getPackageManager();
    }
    try
    {
      i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String f()
  {
    return c;
  }
  
  public static int i()
  {
    try
    {
      int i = d;
      d = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String j()
  {
    try
    {
      String str = (String)f.a("com.tencent.open.appcommon.js.AppInterface").a("getImei", new Object[0]).a();
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  private static String k()
  {
    try
    {
      String str = (String)f.a("com.tencent.open.appcommon.js.AppInterface").a("getImsi", new Object[0]).a();
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  private String l()
  {
    try
    {
      Object localObject = alkz.a((WifiManager)this.b.getSystemService("wifi"));
      if (localObject != null)
      {
        localObject = alkz.c((WifiInfo)localObject);
        return localObject;
      }
      return "";
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public final int a(String paramString)
  {
    if (this.b == null) {}
    for (;;)
    {
      return 0;
      try
      {
        paramString = this.b.getPackageManager().getApplicationInfo(paramString, 128);
        if ((paramString != null) && (paramString.metaData != null))
        {
          int i = paramString.metaData.getInt("com.tencent.android.qqdownloader.GRAY_CODE");
          return i;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0;
  }
  
  public final void a(Context paramContext)
  {
    this.b = paramContext;
    c = new e(paramContext).a();
  }
  
  public final Context b()
  {
    return this.b;
  }
  
  public final void b(String paramString)
  {
    if (paramString != null)
    {
      SharedPreferences localSharedPreferences = this.b.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
      }
    }
  }
  
  public final String d()
  {
    if (this.b == null) {
      return "";
    }
    return ((TelephonyManager)this.b.getSystemService("phone")).getNetworkOperator();
  }
  
  public final int e()
  {
    Object localObject;
    if (this.b == null) {
      localObject = "";
    }
    while (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (((String)localObject).equals("WIFI"))
      {
        return 1;
        if (this.b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
          localObject = "";
        }
        else
        {
          localObject = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
          if (localObject == null)
          {
            localObject = "";
          }
          else if (((NetworkInfo)localObject).getType() == 1)
          {
            localObject = "WIFI";
          }
          else
          {
            localObject = ((NetworkInfo)localObject).getExtraInfo();
            if (localObject == null) {
              localObject = "";
            } else {
              localObject = ((String)localObject).toUpperCase();
            }
          }
        }
      }
      else
      {
        if (((String)localObject).equals("UN_DETECT")) {
          return 0;
        }
        if (((String)localObject).equals("CMWAP")) {
          return 2;
        }
        if (((String)localObject).equals("CMNET")) {
          return 3;
        }
        if (((String)localObject).equals("UNIWAP")) {
          return 4;
        }
        if (((String)localObject).equals("UNINET")) {
          return 5;
        }
        if (((String)localObject).equals("WAP3G")) {
          return 6;
        }
        if (((String)localObject).equals("NET3G")) {
          return 7;
        }
        if (((String)localObject).equals("CTWAP")) {
          return 8;
        }
        if (((String)localObject).equals("CTNET")) {
          return 9;
        }
      }
    }
    return 10;
  }
  
  /* Error */
  public final Terminal g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 26	com/tencent/apkupdate/b/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   5: ifnonnull +100 -> 105
    //   8: aload_0
    //   9: getfield 102	com/tencent/apkupdate/b/b:b	Landroid/content/Context;
    //   12: invokevirtual 233	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   15: ldc 235
    //   17: invokestatic 241	alla:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 102	com/tencent/apkupdate/b/b:b	Landroid/content/Context;
    //   25: ldc 150
    //   27: iconst_0
    //   28: invokevirtual 154	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +80 -> 113
    //   36: aload_1
    //   37: ldc 162
    //   39: ldc 20
    //   41: invokeinterface 244 3 0
    //   46: astore_1
    //   47: ldc 2
    //   49: monitorenter
    //   50: new 246	com/tencent/apkupdate/logic/protocol/jce/Terminal
    //   53: dup
    //   54: invokespecial 247	com/tencent/apkupdate/logic/protocol/jce/Terminal:<init>	()V
    //   57: astore_3
    //   58: aload_3
    //   59: putstatic 26	com/tencent/apkupdate/b/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   62: aload_3
    //   63: aload_2
    //   64: putfield 250	com/tencent/apkupdate/logic/protocol/jce/Terminal:androidId	Ljava/lang/String;
    //   67: getstatic 26	com/tencent/apkupdate/b/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   70: aload_1
    //   71: putfield 253	com/tencent/apkupdate/logic/protocol/jce/Terminal:androidIdSdCard	Ljava/lang/String;
    //   74: getstatic 26	com/tencent/apkupdate/b/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   77: invokestatic 255	com/tencent/apkupdate/b/b:j	()Ljava/lang/String;
    //   80: putfield 258	com/tencent/apkupdate/logic/protocol/jce/Terminal:imei	Ljava/lang/String;
    //   83: getstatic 26	com/tencent/apkupdate/b/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   86: invokestatic 260	com/tencent/apkupdate/b/b:k	()Ljava/lang/String;
    //   89: putfield 263	com/tencent/apkupdate/logic/protocol/jce/Terminal:imsi	Ljava/lang/String;
    //   92: getstatic 26	com/tencent/apkupdate/b/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   95: aload_0
    //   96: invokespecial 265	com/tencent/apkupdate/b/b:l	()Ljava/lang/String;
    //   99: putfield 268	com/tencent/apkupdate/logic/protocol/jce/Terminal:macAdress	Ljava/lang/String;
    //   102: ldc 2
    //   104: monitorexit
    //   105: getstatic 26	com/tencent/apkupdate/b/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: areturn
    //   113: ldc 20
    //   115: astore_1
    //   116: goto -69 -> 47
    //   119: astore_1
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	b
    //   31	85	1	localObject1	Object
    //   119	5	1	localObject2	Object
    //   125	4	1	localObject3	Object
    //   20	44	2	str	String
    //   57	6	3	localTerminal	Terminal
    // Exception table:
    //   from	to	target	type
    //   50	105	119	finally
    //   2	32	125	finally
    //   36	47	125	finally
    //   47	50	125	finally
    //   105	109	125	finally
    //   120	125	125	finally
  }
  
  public final String h()
  {
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.apkupdate.b.b
 * JD-Core Version:    0.7.0.1
 */