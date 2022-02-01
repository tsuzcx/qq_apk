package com.weiyun.sdk;

import alla;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import com.weiyun.sdk.util.NetworkUtils;
import java.util.Random;
import java.util.UUID;

public class Global
{
  private static final String KEY_DEVICE_ID = "device_id";
  private static final String KEY_MAC_ADDRESS = "device_mac";
  private static final Random RANDOM = new Random();
  private static final String SP_NAME = "weiyun.sdk.pref.main";
  private static boolean isInit = false;
  private static Context sContext;
  private static HostInterface sHostInterface;
  
  public static int generateRandomId(Object... paramVarArgs)
  {
    int i = 17;
    int k = i;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      k = i;
      if (j < m)
      {
        Object localObject = paramVarArgs[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          i = i * 31 + localObject.hashCode();
        }
      }
    }
    return k * 31 + RANDOM.nextInt();
  }
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static String getDeviceId()
  {
    String str2 = getSpStringValue("device_id", null);
    String str1 = str2;
    if (str2 == null)
    {
      str2 = getSpStringValue("device_mac", null);
      str1 = str2;
      if (str2 == null)
      {
        str2 = NetworkUtils.getWifiMacAddress(sContext);
        str1 = str2;
        if (str2 != null)
        {
          saveSpStringValue("device_mac", str2);
          str1 = str2;
        }
      }
      if (str1 != null)
      {
        str1 = makeStringWithLength(str1, 17);
        saveSpStringValue("device_id", str1);
      }
    }
    else
    {
      return str1;
    }
    str1 = alla.a((TelephonyManager)sContext.getSystemService("phone"));
    if (str1 != null)
    {
      str1 = makeStringWithLength(str1, 17);
      saveSpStringValue("device_id", str1);
      return str1;
    }
    return makeStringWithLength("", 17);
  }
  
  public static HostInterface getHostInterface()
  {
    return sHostInterface;
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    return sContext.getSharedPreferences("weiyun.sdk.pref.main", 0);
  }
  
  public static String getSpStringValue(String paramString1, String paramString2)
  {
    return getSharedPreferences().getString(paramString1, paramString2);
  }
  
  public static void init(Context paramContext, HostInterface paramHostInterface)
  {
    if ((paramContext == null) || (paramHostInterface == null)) {
      throw new IllegalArgumentException("Context and HostInterface should be no-null.");
    }
    isInit = true;
    sContext = paramContext;
    sHostInterface = paramHostInterface;
  }
  
  public static boolean isInit()
  {
    return isInit;
  }
  
  public static String makeStringWithLength(String paramString, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    while (paramString.length() <= paramInt) {
      paramString.append(UUID.randomUUID().toString());
    }
    return paramString.substring(0, paramInt);
  }
  
  public static void saveSpStringValue(String paramString1, String paramString2)
  {
    getSharedPreferences().edit().putString(paramString1, paramString2).commit();
  }
  
  public static abstract interface HostInterface
  {
    public abstract String getAppName();
    
    public abstract long getUin();
    
    public abstract String getVersionCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.Global
 * JD-Core Version:    0.7.0.1
 */