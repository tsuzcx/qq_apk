package com.tencent.tmassistantsdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.downloadservice.c;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  private static e b = null;
  private static int d = 0;
  public String a = "";
  private Context c;
  private HashMap e = null;
  
  protected e()
  {
    this.e.put(Integer.valueOf(1), "ReportLog");
    this.e.put(Integer.valueOf(2), "GetSettings");
    this.e.put(Integer.valueOf(3), "GetAppUpdate");
    this.e.put(Integer.valueOf(4), "GetAuthorized");
    this.e.put(Integer.valueOf(5), "GetAppSimpleDetail");
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 6: 
      return 1;
    case 2: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    }
    return 6;
  }
  
  public static e a()
  {
    try
    {
      if (b == null) {
        b = new e();
      }
      e locale = b;
      return locale;
    }
    finally {}
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -1000: 
    case -26: 
    case -24: 
    default: 
      return 604;
    case 0: 
      return 0;
    case -1: 
      return 709;
    case -11: 
      return 708;
    case -12: 
      return 730;
    case -13: 
      return 703;
    case -15: 
      return 1;
    case -16: 
      return 731;
    case -21: 
      return 700;
    case -22: 
      return 732;
    case -23: 
      return 601;
    case -25: 
      return 602;
    case -27: 
      return 606;
    }
    return 701;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
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
  
  public static String c(String paramString)
  {
    int i = 0;
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.getBytes();
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString, 0, paramString.length);
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      while (i < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static ArrayList d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      int i = 0;
      while (i < paramString.length)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void e(String paramString)
  {
    Object localObject = new File(paramString);
    String str2 = ((File)localObject).getParent();
    String str1 = new File(str2).getParent();
    paramString = new File(str1).getParent();
    try
    {
      localObject = "chmod 777 " + ((File)localObject).getAbsolutePath();
      Runtime.getRuntime().exec((String)localObject);
      str2 = "chmod 777 " + str2;
      Runtime.getRuntime().exec(str2);
      str1 = "chmod 777 " + str1;
      Runtime.getRuntime().exec(str1);
      paramString = "chmod 777" + paramString;
      Runtime.getRuntime().exec(paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean f(String paramString)
  {
    return (a().c != null) && (a().c.getDatabasePath(paramString).exists());
  }
  
  public static void g(String paramString)
  {
    if (a().c != null)
    {
      paramString = a().c.getDatabasePath(paramString);
      if (paramString.exists() != true) {}
    }
    try
    {
      paramString.delete();
      j.b("GlobalUtil", "deleteDB");
      return;
    }
    catch (Exception paramString)
    {
      j.b("GlobalUtil", "deleteDB failed");
    }
  }
  
  public static int k()
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
    if (paramString == null) {
      return 0;
    }
    if (this.e != null)
    {
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
          localObject = (String)((Map.Entry)localObject).getValue();
          if ((localObject != null) && (((String)localObject).equals(paramString))) {
            return localInteger.intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public final void a(byte paramByte)
  {
    if (this.c == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    } while ((localSharedPreferences == null) || (Byte.parseByte(localSharedPreferences.getString("TMAssistantSDKNetType", "0")) == paramByte));
    localSharedPreferences.edit().putString("TMAssistantSDKNetType", paramByte).commit();
  }
  
  public final void a(Context paramContext)
  {
    this.c = paramContext;
    this.a = new i(paramContext).a();
  }
  
  public final Context b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    if (this.c == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        return;
      } while (paramString == null);
      localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
  }
  
  public final void c()
  {
    this.c = null;
    b = null;
  }
  
  public final String d()
  {
    if (this.c == null) {
      return "";
    }
    return ((TelephonyManager)this.c.getSystemService("phone")).getNetworkOperator();
  }
  
  public final int e()
  {
    if (this.c == null) {
      return 0;
    }
    return ((TelephonyManager)this.c.getSystemService("phone")).getNetworkType();
  }
  
  public final String f()
  {
    if (this.c == null) {
      return null;
    }
    return Settings.Secure.getString(this.c.getContentResolver(), "android_id");
  }
  
  public final String g()
  {
    if (this.c == null) {
      return "";
    }
    SharedPreferences localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
  
  public final String h()
  {
    if (this.c == null) {
      return null;
    }
    return ((TelephonyManager)this.c.getSystemService("phone")).getDeviceId();
  }
  
  public final String i()
  {
    if (this.c == null) {
      return null;
    }
    return ((TelephonyManager)this.c.getSystemService("phone")).getSubscriberId();
  }
  
  public final String j()
  {
    if (this.c == null) {
      return null;
    }
    WifiInfo localWifiInfo = ((WifiManager)this.c.getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null) {
      return localWifiInfo.getMacAddress();
    }
    return "";
  }
  
  public final boolean l()
  {
    if ((!"wifi".equals(c.b())) || (this.c == null)) {}
    for (;;)
    {
      return false;
      SharedPreferences localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
      if (localSharedPreferences != null) {}
      for (int i = Byte.parseByte(localSharedPreferences.getString("TMAssistantSDKNetType", "0")); (i & 0x4) == 4; i = 0) {
        return true;
      }
    }
  }
  
  public final int m()
  {
    if (this.c == null) {}
    for (;;)
    {
      return 0;
      try
      {
        ApplicationInfo localApplicationInfo = this.c.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int i = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
          return i;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public final int n()
  {
    if (this.c == null) {}
    for (;;)
    {
      return 0;
      Object localObject = this.c.getPackageManager();
      if (localObject != null) {
        try
        {
          localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
          if (localObject != null)
          {
            int i = ((PackageInfo)localObject).versionCode;
            return i;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.e
 * JD-Core Version:    0.7.0.1
 */