package com.tencent.mobileqq.mini.apkg;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ApkgInfo
  extends ApkgBaseInfo
{
  private static final String NAME_APP_SERVICE_JS = "app-service.js";
  private static final String NAME_CONFIG_JSON = "app-config.json";
  private static final String NAME_PAGE_FRAME_HTML = "page-frame.html";
  private static final String NAME_PAGE_FRAME_JS = "page-frame.js";
  private static final String NAME_WXSS_JS = "app-wxss.js";
  private static final String TAG = "ApkgInfo";
  public static final int URL_OPEN_TYPE_EXTERNAL = 1;
  public static final int URL_OPEN_TYPE_INTERNAL = 0;
  private Map<String, Bitmap> bitmapCache = new HashMap();
  public AppConfigInfo mAppConfigInfo;
  private Map<String, String> mPageJsMap = new HashMap();
  
  public ApkgInfo(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    super(paramString, paramMiniAppConfig);
  }
  
  public static ApkgInfo loadApkgInfoFromFolderPath(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new ApkgInfo(paramString1, paramMiniAppConfig);
    paramString1.init(paramString2);
    paramString2 = paramString1.mAppConfigInfo.networkTimeoutInfo;
    MiniOkHttpClientFactory.init(paramString2.request, paramString2.uploadFile, paramString2.downloadFile);
    return paramString1;
  }
  
  public static String normalize(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int j = paramString.indexOf("?");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public void downloadSubPack(String paramString, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    ApkgManager.getInstance().downloadSubPack(this, paramString, paramOnInitApkgListener);
  }
  
  public AppConfigInfo getAppConfigInfo()
  {
    return this.mAppConfigInfo;
  }
  
  public String getAppServiceJsContent(String paramString)
  {
    return FileUtils.readFileToStr(new File(getAppServiceJsPath(paramString)));
  }
  
  public String getAppServiceJsPath()
  {
    return getApkgFolderPath() + "/" + "app-service.js";
  }
  
  public String getAppServiceJsPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return getApkgFolderPath() + "/" + "app-service.js";
    }
    return new File(new File(getApkgFolderPath(), paramString), "app-service.js").getAbsolutePath();
  }
  
  public Bitmap getBitmap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.bitmapCache.get(paramString);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = ImageUtil.getLocalBitmap(paramString);
    this.bitmapCache.put(paramString, localObject);
    return localObject;
  }
  
  public boolean getDebug()
  {
    if (this.mAppConfigInfo != null) {
      return this.mAppConfigInfo.debug;
    }
    return false;
  }
  
  public String getPageFrameHtmlUrl()
  {
    return "https://servicewechat.com/page-frame.html";
  }
  
  public String getPageFrameJSStr(String paramString)
  {
    paramString = this.mAppConfigInfo.getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(new File(getApkgFolderPath(), paramString), "page-frame.js");
    if (paramString.exists()) {
      return FileUtils.readFileToStr(paramString);
    }
    return "";
  }
  
  public PageHtmlContent getPageHtmlContent()
  {
    Object localObject = new File(getApkgFolderPath(), "page-frame.html");
    PageHtmlContent localPageHtmlContent = new PageHtmlContent();
    if (!((File)localObject).exists())
    {
      localPageHtmlContent.htmlStr = getPageHtmlStr();
      return localPageHtmlContent;
    }
    try
    {
      localObject = FileUtils.readFileToStr((File)localObject);
      String str = ((String)localObject).substring(((String)localObject).indexOf("<script>") + "<script>".length(), ((String)localObject).indexOf("</script>"));
      localPageHtmlContent.htmlStr = ((String)localObject);
      localPageHtmlContent.jsStr = str;
      return localPageHtmlContent;
    }
    catch (Exception localException)
    {
      QLog.e("ApkgInfo", 1, "getPageHtmlContent Exception!", localException);
    }
    return localPageHtmlContent;
  }
  
  public String getPageHtmlStr()
  {
    return ApkgManager.getInstance().getBasePageFrameStr();
  }
  
  public String getPageJsStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = normalize(paramString);
      str1 = (String)this.mPageJsMap.get(str2);
      paramString = str1;
    } while (!TextUtils.isEmpty(str1));
    paramString = str1;
    try
    {
      String str3 = FileUtils.readFileToString(new File(getApkgFolderPath(), str2));
      paramString = str1;
      str1 = str3.substring(str3.indexOf("<script>") + "<script>".length(), str3.indexOf("</script>"));
      paramString = str1;
      this.mPageJsMap.put(str2, str1);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApkgInfo", 1, "getPageJsStr error." + localThrowable);
      localThrowable.printStackTrace();
    }
    return paramString;
  }
  
  public String getRootPath(String paramString)
  {
    return this.mAppConfigInfo.getRootPath(paramString);
  }
  
  public String getRootWxssJsContent()
  {
    File localFile = new File(new File(getApkgFolderPath()), "app-wxss.js");
    if (localFile.exists()) {
      return FileUtils.readFileToStr(localFile);
    }
    return "";
  }
  
  public int getURLOpenType(String paramString)
  {
    if ("fbf1c3b512b1e5f14b1c8629c8677961".equals(this.appConfig.config.appId)) {
      return 1;
    }
    return 0;
  }
  
  public String getWAServiceJSStr()
  {
    return ApkgManager.getInstance().getWaServiceJsStr();
  }
  
  public String getWAWebviewJSStr()
  {
    return ApkgManager.getInstance().getWAWebviewJsStr();
  }
  
  public String getWaConsoleJsStr()
  {
    return ApkgManager.getInstance().getWaConsoleJsStr();
  }
  
  public String getWorkerJsContent(String paramString1, String paramString2)
  {
    return FileUtils.readFileToStr(new File(getWorkerPath(paramString1, paramString2)));
  }
  
  public String getWorkerPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return getApkgFolderPath() + File.separator + paramString2;
    }
    return new File(new File(getApkgFolderPath(), paramString1), paramString2).getAbsolutePath();
  }
  
  public void init(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath() + "/" + paramString, "app-config.json"));
        updateConfigStr(this.mConfigStr);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), "app-config.json"));
    }
  }
  
  public boolean isHomePage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = AppBrandUtil.getUrlWithoutParams(paramString);
    } while ((!isTabBarPage(paramString)) && (!paramString.equals(this.mAppConfigInfo.entryPagePath)));
    return true;
  }
  
  public boolean isTabBarPage(String paramString)
  {
    paramString = AppBrandUtil.getUrlWithoutParams(paramString);
    Object localObject = this.mAppConfigInfo.tabBarInfo;
    if (localObject != null)
    {
      localObject = ((TabBarInfo)localObject).list.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TabBarInfo.ButtonInfo)((Iterator)localObject).next()).pagePath.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isUrlFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(getFilePath(AppBrandUtil.getUrlWithoutParams(paramString))).exists()) {
      return false;
    }
    return true;
  }
  
  public boolean isUrlResReady(String paramString)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      return true;
      paramString = new File(ApkgManager.getApkgFolderPath(this.appConfig.config), paramString).getAbsolutePath();
      bool = new File(paramString).exists();
      if (QLog.isColorLevel()) {
        QLog.d("ApkgInfo", 1, "isUrlResReady | subFolderPath :" + paramString + "isExist:" + bool);
      }
    } while (bool);
    return false;
  }
  
  public void setDebug(boolean paramBoolean)
  {
    if (paramBoolean == this.mAppConfigInfo.debug) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(this.mConfigStr);
      ((JSONObject)localObject).put("debug", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      FileUtils.writeFile(new File(getApkgFolderPath(), "app-config.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void updateConfigStr(String paramString)
  {
    MiniAppInfo localMiniAppInfo = null;
    for (;;)
    {
      try
      {
        this.mConfigStr = paramString;
        JSONObject localJSONObject = new JSONObject(this.mConfigStr);
        paramString = new JSONObject();
        paramString.put("USER_DATA_PATH", "wxfile://usr");
        localJSONObject.put("env", paramString);
        String str2 = localJSONObject.optString("entryPagePath");
        if (this.appConfig == null) {
          break label191;
        }
        LaunchParam localLaunchParam2 = this.appConfig.launchParam;
        if (localLaunchParam2 != null)
        {
          paramString = localLaunchParam2.entryPath;
          str1 = paramString;
          localLaunchParam1 = localLaunchParam2;
          if (this.appConfig.config != null)
          {
            localMiniAppInfo = this.appConfig.config;
            localLaunchParam1 = localLaunchParam2;
            str1 = paramString;
          }
          if (!isUrlFileExist(str1))
          {
            paramString = str2;
            localJSONObject.put("appLaunchInfo", AppBrandUtil.getAppLaunchInfo(paramString, localLaunchParam1, localMiniAppInfo));
            this.mConfigStr = localJSONObject.toString();
            this.mAppConfigInfo = AppConfigInfo.parseAppConfig(this.mConfigStr, this);
            AuthorizeCenter.updateScopeDescription(this.mAppConfigInfo.permissionInfo);
            return;
          }
          paramString = str1;
          continue;
        }
        paramString = null;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      label191:
      String str1 = null;
      LaunchParam localLaunchParam1 = null;
    }
  }
  
  public void updateMiniConfig(MiniAppConfig paramMiniAppConfig)
  {
    String str = this.appConfig.config.version;
    this.appConfig = paramMiniAppConfig;
    this.appConfig.config.version = str;
    init(null);
  }
  
  public static class PageHtmlContent
  {
    public String htmlStr;
    public String jsStr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgInfo
 * JD-Core Version:    0.7.0.1
 */