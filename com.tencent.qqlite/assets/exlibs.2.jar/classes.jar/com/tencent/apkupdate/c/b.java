package com.tencent.apkupdate.c;

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
    //   2: getstatic 26	com/tencent/apkupdate/c/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   5: ifnonnull +148 -> 153
    //   8: aload_0
    //   9: getfield 81	com/tencent/apkupdate/c/b:b	Landroid/content/Context;
    //   12: invokevirtual 199	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   15: ldc 201
    //   17: invokestatic 207	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 81	com/tencent/apkupdate/c/b:b	Landroid/content/Context;
    //   25: ldc 110
    //   27: iconst_0
    //   28: invokevirtual 114	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +128 -> 161
    //   36: aload_1
    //   37: ldc 122
    //   39: ldc 20
    //   41: invokeinterface 210 3 0
    //   46: astore_1
    //   47: ldc 2
    //   49: monitorenter
    //   50: new 212	com/tencent/apkupdate/logic/protocol/jce/Terminal
    //   53: dup
    //   54: invokespecial 213	com/tencent/apkupdate/logic/protocol/jce/Terminal:<init>	()V
    //   57: astore_3
    //   58: aload_3
    //   59: putstatic 26	com/tencent/apkupdate/c/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   62: aload_3
    //   63: aload_2
    //   64: putfield 216	com/tencent/apkupdate/logic/protocol/jce/Terminal:androidId	Ljava/lang/String;
    //   67: getstatic 26	com/tencent/apkupdate/c/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   70: aload_1
    //   71: putfield 219	com/tencent/apkupdate/logic/protocol/jce/Terminal:androidIdSdCard	Ljava/lang/String;
    //   74: getstatic 26	com/tencent/apkupdate/c/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   77: aload_0
    //   78: getfield 81	com/tencent/apkupdate/c/b:b	Landroid/content/Context;
    //   81: ldc 134
    //   83: invokevirtual 138	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   86: checkcast 140	android/telephony/TelephonyManager
    //   89: invokevirtual 222	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   92: putfield 225	com/tencent/apkupdate/logic/protocol/jce/Terminal:imei	Ljava/lang/String;
    //   95: getstatic 26	com/tencent/apkupdate/c/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   98: aload_0
    //   99: getfield 81	com/tencent/apkupdate/c/b:b	Landroid/content/Context;
    //   102: ldc 134
    //   104: invokevirtual 138	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   107: checkcast 140	android/telephony/TelephonyManager
    //   110: invokevirtual 228	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   113: putfield 231	com/tencent/apkupdate/logic/protocol/jce/Terminal:imsi	Ljava/lang/String;
    //   116: getstatic 26	com/tencent/apkupdate/c/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   119: astore_2
    //   120: aload_0
    //   121: getfield 81	com/tencent/apkupdate/c/b:b	Landroid/content/Context;
    //   124: ldc 233
    //   126: invokevirtual 138	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   129: checkcast 235	android/net/wifi/WifiManager
    //   132: invokevirtual 239	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +30 -> 167
    //   140: aload_1
    //   141: invokevirtual 244	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   144: astore_1
    //   145: aload_2
    //   146: aload_1
    //   147: putfield 247	com/tencent/apkupdate/logic/protocol/jce/Terminal:macAdress	Ljava/lang/String;
    //   150: ldc 2
    //   152: monitorexit
    //   153: getstatic 26	com/tencent/apkupdate/c/b:e	Lcom/tencent/apkupdate/logic/protocol/jce/Terminal;
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: areturn
    //   161: ldc 20
    //   163: astore_1
    //   164: goto -117 -> 47
    //   167: ldc 20
    //   169: astore_1
    //   170: goto -25 -> 145
    //   173: astore_1
    //   174: ldc 2
    //   176: monitorexit
    //   177: aload_1
    //   178: athrow
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	b
    //   31	139	1	localObject1	Object
    //   173	5	1	localObject2	Object
    //   179	4	1	localObject3	Object
    //   20	126	2	localObject4	Object
    //   57	6	3	localTerminal	Terminal
    // Exception table:
    //   from	to	target	type
    //   50	136	173	finally
    //   140	145	173	finally
    //   145	153	173	finally
    //   2	32	179	finally
    //   36	47	179	finally
    //   47	50	179	finally
    //   153	157	179	finally
    //   174	179	179	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.c.b
 * JD-Core Version:    0.7.0.1
 */