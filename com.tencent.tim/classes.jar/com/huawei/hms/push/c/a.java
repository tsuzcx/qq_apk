package com.huawei.hms.push.c;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

public class a
{
  public static String a(Bundle paramBundle, String paramString)
  {
    try
    {
      paramBundle = paramBundle.getString(paramString);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      HMSLog.i("BundleUtil", "getString exception" + paramBundle.getMessage());
    }
    return null;
  }
  
  public static String b(Bundle paramBundle, String paramString)
  {
    try
    {
      paramBundle = paramBundle.getString(paramString);
      paramString = paramBundle;
      if (paramBundle == null) {
        paramString = "";
      }
      return paramString;
    }
    catch (Exception paramBundle)
    {
      HMSLog.i("BundleUtil", "getString exception" + paramBundle.getMessage());
    }
    return "";
  }
  
  public static byte[] c(Bundle paramBundle, String paramString)
  {
    try
    {
      paramBundle = paramBundle.getByteArray(paramString);
      paramString = paramBundle;
      if (paramBundle == null) {
        paramString = new byte[0];
      }
      return paramString;
    }
    catch (Exception paramBundle)
    {
      HMSLog.i("BundleUtil", "getByteArray exception" + paramBundle.getMessage());
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.c.a
 * JD-Core Version:    0.7.0.1
 */