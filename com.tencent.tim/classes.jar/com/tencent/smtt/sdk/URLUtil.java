package com.tencent.smtt.sdk;

public final class URLUtil
{
  public static String composeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().a(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.composeSearchUrl(paramString1, paramString2, paramString3);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws IllegalArgumentException
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().a(paramArrayOfByte);
    }
    return android.webkit.URLUtil.decode(paramArrayOfByte);
  }
  
  public static final String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().b(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.guessFileName(paramString1, paramString2, paramString3);
  }
  
  public static String guessUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().m(paramString);
    }
    return android.webkit.URLUtil.guessUrl(paramString);
  }
  
  public static boolean isAboutUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().q(paramString);
    }
    return android.webkit.URLUtil.isAboutUrl(paramString);
  }
  
  public static boolean isAssetUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().n(paramString);
    }
    return android.webkit.URLUtil.isAssetUrl(paramString);
  }
  
  public static boolean isContentUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().w(paramString);
    }
    return android.webkit.URLUtil.isContentUrl(paramString);
  }
  
  @Deprecated
  public static boolean isCookielessProxyUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().o(paramString);
    }
    return android.webkit.URLUtil.isCookielessProxyUrl(paramString);
  }
  
  public static boolean isDataUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().r(paramString);
    }
    return android.webkit.URLUtil.isDataUrl(paramString);
  }
  
  public static boolean isFileUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().p(paramString);
    }
    return android.webkit.URLUtil.isFileUrl(paramString);
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().t(paramString);
    }
    return android.webkit.URLUtil.isHttpUrl(paramString);
  }
  
  public static boolean isHttpsUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().u(paramString);
    }
    return android.webkit.URLUtil.isHttpsUrl(paramString);
  }
  
  public static boolean isJavaScriptUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().s(paramString);
    }
    return android.webkit.URLUtil.isJavaScriptUrl(paramString);
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().v(paramString);
    }
    return android.webkit.URLUtil.isNetworkUrl(paramString);
  }
  
  public static boolean isValidUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().x(paramString);
    }
    return android.webkit.URLUtil.isValidUrl(paramString);
  }
  
  public static String stripAnchor(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().y(paramString);
    }
    return android.webkit.URLUtil.stripAnchor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.URLUtil
 * JD-Core Version:    0.7.0.1
 */