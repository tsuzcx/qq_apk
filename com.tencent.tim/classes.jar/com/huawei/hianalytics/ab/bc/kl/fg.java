package com.huawei.hianalytics.ab.bc.kl;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class fg
{
  private static final String[] ab = { "dbankcloud.com", "dbankcloud.cn", "dbankcloud.eu", "dbankcloud.asia", "digitalincloud.com", "digitalincloud.cn", "digitalincloud.eu", "digitalincloud.asia", "dbankcdn.com", "dbankcdn.cn", "dbankcdn.eu", "dbankcdn.asia", "hicloud.com" };
  
  public static boolean ab(String paramString)
  {
    if (com.huawei.hianalytics.ab.gh.ab.ab.booleanValue()) {
      return true;
    }
    String[] arrayOfString = ab;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label42;
      }
      if (ab(paramString, arrayOfString[i])) {
        break;
      }
      i += 1;
    }
    label42:
    return false;
  }
  
  public static boolean ab(String paramString1, String paramString2)
  {
    paramString1 = bc(paramString1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.huawei.hianalytics.ab.bc.ef.ab.de("UriUtil", "url or whitelist is null");
    }
    for (;;)
    {
      return false;
      paramString2 = cd(paramString2);
      if (TextUtils.isEmpty(paramString2))
      {
        Log.e("UriUtil", "whitelist host is null");
        return false;
      }
      if (paramString2.equals(paramString1)) {
        return true;
      }
      if (paramString1.endsWith(paramString2)) {
        try
        {
          paramString1 = paramString1.substring(0, paramString1.length() - paramString2.length());
          if (paramString1.endsWith("."))
          {
            boolean bool = paramString1.matches("^[A-Za-z0-9.-]+$");
            return bool;
          }
        }
        catch (IndexOutOfBoundsException paramString1)
        {
          com.huawei.hianalytics.ab.bc.ef.ab.de("UriUtil", "IndexOutOfBoundsException" + paramString1.getMessage());
          return false;
        }
        catch (Exception paramString1)
        {
          com.huawei.hianalytics.ab.bc.ef.ab.de("UriUtil", "Exception : " + paramString1.getMessage());
        }
      }
    }
    return false;
  }
  
  @TargetApi(9)
  public static String bc(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("UriUtil", "url is null");
      return paramString;
    }
    try
    {
      if ((!URLUtil.isNetworkUrl(paramString)) || (paramString.toLowerCase(Locale.US).startsWith("http:")))
      {
        com.huawei.hianalytics.ab.bc.ef.ab.de("UriUtil", "url don't starts with https");
        return null;
      }
      paramString = new URI(paramString).getHost();
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.de("UriUtil", "getHostByURI error : " + paramString.getMessage());
    }
    return null;
  }
  
  private static String cd(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("UriUtil", "whiteListUrl is null");
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (!URLUtil.isNetworkUrl(paramString));
    return bc(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.kl.fg
 * JD-Core Version:    0.7.0.1
 */