package com.tencent.mobileqq.mini.appbrand.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.MalformedURLException;
import java.net.URL;

public class IPV6OnlyUtils
{
  public static final String DEFAULT_PREFIX = "https://";
  public static final String HTTP_PREFIX = "http://";
  public static final String TAG = "IPV6OnlyUtils";
  public static final String WSS_PREFIX = "wss://";
  public static final String WS_PREFIX = "ws://";
  
  private static boolean checkEnableIPV6Only()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1;
  }
  
  public static String getDomain(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    for (;;)
    {
      return str;
      if (paramString.startsWith("wss://"))
      {
        str = paramString;
        if (paramString.length() > 6) {
          str = "https://" + paramString.substring(6);
        }
      }
      try
      {
        for (;;)
        {
          URL localURL1 = new URL(str);
          paramString = localURL1.getHost();
          localURL1.getPort();
          str = paramString;
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          str = paramString;
          if (!paramString.startsWith("www.")) {
            break;
          }
          return paramString.substring(4);
          str = paramString;
          if (!paramString.startsWith("https://")) {
            if (paramString.startsWith("http://")) {
              str = "https://" + paramString.substring("http://".length());
            } else {
              str = "https://" + paramString;
            }
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        try
        {
          URL localURL2 = new URL("https://" + str);
          paramString = localURL2.getHost();
          localURL2.getPort();
        }
        catch (MalformedURLException paramString)
        {
          QLog.e("IPV6OnlyUtils", 1, "getDomainConfig url error" + str, localMalformedURLException);
        }
      }
    }
    return null;
  }
  
  public static String getEncoding(String paramString)
  {
    QLog.d("IPV6OnlyUtils", 2, "getMiniType " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "utf-8";
    }
    try
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.trim().toLowerCase().startsWith("charset"))
        {
          paramString = localObject.split("=")[1];
          return paramString;
        }
        i += 1;
      }
      return "utf-8";
    }
    catch (Exception paramString)
    {
      QLog.e("IPV6OnlyUtils", 1, "getEncoding failed, ", paramString);
    }
  }
  
  public static String getMimeType(String paramString)
  {
    QLog.d("IPV6OnlyUtils", 2, "getMiniType " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "text/html";
      return paramString;
    }
    String[] arrayOfString = paramString.split(";");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label85;
      }
      String str = arrayOfString[i];
      paramString = str;
      if (!str.trim().toLowerCase().startsWith("charset")) {
        break;
      }
      i += 1;
    }
    label85:
    return "text/html";
  }
  
  public static boolean isDomainMatchRfc2109(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    QLog.e("IPV6OnlyUtils", 1, "isDomainMatchRfc2109 candidateDomain=" + paramString1 + ", checkDomain=" + paramString2);
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    if (paramString2.startsWith(".")) {
      return paramString1.endsWith(paramString2);
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean isIPV6Enable()
  {
    return (checkEnableIPV6Only()) && (RequestStrategy.g.isIPv6Only());
  }
  
  public static boolean isIPV6Enable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!isIPV6Enable()) || ((!paramString.toLowerCase().startsWith("http://")) && (!paramString.toLowerCase().startsWith("https:"))) || (!isUrlAllowedProxy(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean isUrlAllowedProxy(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_domain_black_list", ".idqqimg.com,.qq.com");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return true;
      localObject = ((String)localObject).split(",");
      paramString = getDomain(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (isDomainMatchRfc2109(paramString, localObject[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.IPV6OnlyUtils
 * JD-Core Version:    0.7.0.1
 */