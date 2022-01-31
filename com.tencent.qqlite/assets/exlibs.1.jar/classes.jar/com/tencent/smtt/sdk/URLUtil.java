package com.tencent.smtt.sdk;

public final class URLUtil
{
  public static String composeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilComposeSearchUrl(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.composeSearchUrl(paramString1, paramString2, paramString3);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws IllegalArgumentException
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilDecode(paramArrayOfByte);
    }
    return android.webkit.URLUtil.decode(paramArrayOfByte);
  }
  
  public static final String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilGuessFileName(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.guessFileName(paramString1, paramString2, paramString3);
  }
  
  public static String guessUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilGuessUrl(paramString);
    }
    return android.webkit.URLUtil.guessUrl(paramString);
  }
  
  public static boolean isAboutUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsAboutUrl(paramString);
    }
    return android.webkit.URLUtil.isAboutUrl(paramString);
  }
  
  public static boolean isAssetUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsAssetUrl(paramString);
    }
    return android.webkit.URLUtil.isAssetUrl(paramString);
  }
  
  public static boolean isContentUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsContentUrl(paramString);
    }
    return android.webkit.URLUtil.isContentUrl(paramString);
  }
  
  @Deprecated
  public static boolean isCookielessProxyUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsCookielessProxyUrl(paramString);
    }
    return android.webkit.URLUtil.isCookielessProxyUrl(paramString);
  }
  
  public static boolean isDataUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsDataUrl(paramString);
    }
    return android.webkit.URLUtil.isDataUrl(paramString);
  }
  
  public static boolean isFileUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsFileUrl(paramString);
    }
    return android.webkit.URLUtil.isFileUrl(paramString);
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsHttpUrl(paramString);
    }
    return android.webkit.URLUtil.isHttpUrl(paramString);
  }
  
  public static boolean isHttpsUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsHttpsUrl(paramString);
    }
    return android.webkit.URLUtil.isHttpsUrl(paramString);
  }
  
  public static boolean isJavaScriptUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsJavaScriptUrl(paramString);
    }
    return android.webkit.URLUtil.isJavaScriptUrl(paramString);
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsNetworkUrl(paramString);
    }
    return android.webkit.URLUtil.isNetworkUrl(paramString);
  }
  
  public static boolean isValidUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilIsValidUrl(paramString);
    }
    return android.webkit.URLUtil.isValidUrl(paramString);
  }
  
  public static String stripAnchor(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().urlUtilStripAnchor(paramString);
    }
    return android.webkit.URLUtil.stripAnchor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.URLUtil
 * JD-Core Version:    0.7.0.1
 */