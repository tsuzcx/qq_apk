package com.tencent.youtu.ytcommon.auth;

import alkz;
import alla;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StatisticsUtils
{
  private static String encryptUid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      localStringBuilder.append(k + k % j);
      i += 1;
    }
    localStringBuilder.reverse();
    return localStringBuilder.toString();
  }
  
  private static char getChar(byte paramByte, int paramInt)
  {
    return (char)(paramByte - getOffset(paramInt & 0x1));
  }
  
  public static String getDeviceUid(Context paramContext)
  {
    if (paramContext.getPackageName().startsWith("com.tencent")) {
      return "com.tencent";
    }
    String str = getIMEI(paramContext.getApplicationContext());
    Object localObject = getMacAddr(paramContext.getApplicationContext());
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 1;
      paramContext = (Context)localObject;
      if (i != 0) {
        paramContext = ((String)localObject).replaceAll(":", "");
      }
      localObject = new StringBuilder().append(str);
      if (i == 0) {
        break label91;
      }
    }
    for (;;)
    {
      return toMD5(encryptUid(paramContext));
      i = 0;
      break;
      label91:
      paramContext = "";
    }
  }
  
  public static String getIMEI(Context paramContext)
  {
    String str = alla.getString(paramContext.getContentResolver(), "android_id");
    if (TextUtils.isEmpty(str))
    {
      paramContext = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
      if (paramContext != null) {
        return alla.a(paramContext);
      }
    }
    return str;
  }
  
  public static String getMacAddr(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = alkz.a(paramContext);
      if (paramContext == null) {}
    }
    for (paramContext = alkz.c(paramContext);; paramContext = null) {
      return paramContext;
    }
  }
  
  private static byte getOffset(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 65;; paramInt = 97) {
      return (byte)paramInt;
    }
  }
  
  public static String toMD5(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).reset();
        ((MessageDigest)localObject).update(paramString.getBytes());
        for (paramString = new BigInteger(1, ((MessageDigest)localObject).digest()).toString(16);; paramString = "0" + paramString)
        {
          localObject = paramString;
          if (paramString.length() >= 32) {
            break;
          }
        }
        return "";
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.StatisticsUtils
 * JD-Core Version:    0.7.0.1
 */