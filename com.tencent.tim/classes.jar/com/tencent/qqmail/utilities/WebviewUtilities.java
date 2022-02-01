package com.tencent.qqmail.utilities;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMWebView;
import java.net.URL;

public class WebviewUtilities
{
  private static final String TAG = "WebviewUtilities";
  
  public static void cacheWebViewInlineImage(int paramInt, String paramString)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setAccountId(paramInt);
    localDownloadInfo.setUrl(paramString);
    localDownloadInfo.setImageDownloadListener(new WebviewUtilities.1());
    ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
  }
  
  public static void clearAllCookie()
  {
    CookieSyncManager.createInstance(QMApplicationContext.sharedInstance());
    CookieManager.getInstance().removeAllCookie();
  }
  
  public static String getCookies(String paramString)
  {
    CookieSyncManager.createInstance(QMApplicationContext.sharedInstance());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    return localCookieManager.getCookie(paramString);
  }
  
  public static String getUrl(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http")) {
      if (!paramString.contains("http"))
      {
        str = paramString;
        if (!paramString.contains("https")) {}
      }
      else
      {
        int i = paramString.indexOf("http");
        str = "" + paramString.substring(i);
      }
    }
    return str;
  }
  
  public static void initWebViewSetting(QMWebView paramQMWebView)
  {
    WebSettings localWebSettings = paramQMWebView.getSettings();
    try
    {
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setSupportZoom(true);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setDefaultTextEncodingName("GBK");
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setAppCacheMaxSize(8388608L);
      if (FileUtil.hasSdcard()) {
        localWebSettings.setAppCachePath(QMPathManager.sharedInstance().getQQMailCacheDir());
      }
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDatabasePath(FileDefine.INNER_DATA_DIR + "/databases/");
      localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " mailapp/" + AppConfig.getCodeVersionName());
      QMUIHelper.setZoomControlGone(paramQMWebView);
      removeJavascriptInterface(paramQMWebView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, "WebviewUtilities", "setJavaScriptEnabled", localException);
      }
    }
  }
  
  public static boolean isOnLeftEdge(WebView paramWebView)
  {
    return (paramWebView != null) && (paramWebView.getScrollX() < 1);
  }
  
  public static boolean isQQMailDomainLink(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getHost();
      if (paramString != null)
      {
        boolean bool = paramString.endsWith("mail.qq.com");
        return bool;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static void removeJavascriptInterface(QMWebView paramQMWebView)
  {
    if ((paramQMWebView != null) && (Build.VERSION.SDK_INT >= 11)) {
      paramQMWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public static void setCookies(String paramString1, String paramString2)
  {
    CookieSyncManager.createInstance(QMApplicationContext.sharedInstance());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localCookieManager.removeSessionCookie();
    if (paramString2 != null)
    {
      paramString2 = paramString2.split(";");
      int i = 0;
      while (i < paramString2.length)
      {
        localCookieManager.setCookie(paramString1, paramString2[i]);
        i += 1;
      }
    }
    CookieSyncManager.getInstance().sync();
  }
  
  public static void setCookies(String paramString, String[] paramArrayOfString)
  {
    CookieSyncManager.createInstance(QMApplicationContext.sharedInstance());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localCookieManager.removeSessionCookie();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localCookieManager.setCookie(paramString, paramArrayOfString[i]);
      i += 1;
    }
    CookieSyncManager.getInstance().sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.WebviewUtilities
 * JD-Core Version:    0.7.0.1
 */