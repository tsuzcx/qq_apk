package com.tencent.qapmsdk.impl.util;

import com.tencent.qapmsdk.common.logger.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class StringUtil
{
  private static String TAG = "QAPM_Impl_StringUtil";
  
  public static String changeUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      URL localURL = new URL(paramString);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(localURL.getProtocol());
      localStringBuffer.append("://");
      if (paramString.startsWith("file")) {
        localStringBuffer.append("localfile");
      }
      localStringBuffer.append(localURL.getHost());
      if (localURL.getPort() != -1)
      {
        localStringBuffer.append(":");
        localStringBuffer.append(localURL.getPort());
      }
      localStringBuffer.append(localURL.getPath());
      return localStringBuffer.toString();
    }
    catch (MalformedURLException localMalformedURLException) {}
    return paramString;
  }
  
  public static String contentType(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = paramString.split(";")[0];
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String getHostFromUrl(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      String str = new URL(paramString).getHost();
      return str;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { TAG, "getHostFromUrl is error:", localException.getMessage() + ", url:", paramString });
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */