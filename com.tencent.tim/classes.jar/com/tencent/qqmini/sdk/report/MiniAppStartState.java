package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public class MiniAppStartState
{
  public static boolean isBaseLibLoaded = false;
  public static ConcurrentHashMap<String, StartState> startStateMap = new ConcurrentHashMap();
  
  public static int getApkgDownload(String paramString)
  {
    return getState(paramString).apkgDownload;
  }
  
  public static String getApkgDownloadDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = getApkgDownload(paramString);
    if (i == 0) {
      return "apkg_not_download";
    }
    if (i == 1) {
      return "apkg_download";
    }
    return "unknown";
  }
  
  public static int getBaseLibDownload(String paramString)
  {
    return getState(paramString).baseLibDownload;
  }
  
  public static String getBaseLibDownloadDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = getBaseLibDownload(paramString);
    if (i == 0) {
      return "baselib_not_download";
    }
    if (i == 1) {
      return "baselib_download";
    }
    return "unknown";
  }
  
  public static int getBaselibLoad(String paramString)
  {
    return getState(paramString).baselibLoad;
  }
  
  public static String getBaselibLoadDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = getBaselibLoad(paramString);
    if (i == 0) {
      return "service_not_preload";
    }
    if (i == 1) {
      return "service_preload";
    }
    return "unknown";
  }
  
  public static int getPageSwitch(String paramString)
  {
    return getState(paramString).pageSwitch;
  }
  
  public static String getPageSwitchDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = getPageSwitch(paramString);
    if (i == 0) {
      return "hot_start";
    }
    if (i == 1) {
      return "page_switch";
    }
    return "unknown";
  }
  
  public static int getProcessLoad(String paramString)
  {
    return getState(paramString).processLoad;
  }
  
  public static String getProcessLoadDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = getProcessLoad(paramString);
    if (i == 0) {
      return "service_not_preload";
    }
    if (i == 1) {
      return "service_preload";
    }
    return "unknown";
  }
  
  public static StartState getState(String paramString)
  {
    if (startStateMap.containsKey(paramString)) {
      return (StartState)startStateMap.get(paramString);
    }
    StartState localStartState = new StartState();
    startStateMap.put(paramString, localStartState);
    return localStartState;
  }
  
  public static void removeState(String paramString)
  {
    startStateMap.remove(paramString);
  }
  
  public static void reset(String paramString)
  {
    paramString = getState(paramString);
    paramString.baseLibDownload = -1;
    paramString.baselibLoad = -1;
    paramString.apkgDownload = -1;
    paramString.pageSwitch = -1;
    paramString.processLoad = -1;
  }
  
  public static void reset(String paramString, boolean paramBoolean)
  {
    paramString = getState(paramString);
    if (paramBoolean)
    {
      paramString.baseLibDownload = 1;
      paramString.baselibLoad = 1;
      paramString.apkgDownload = 1;
    }
    for (paramString.processLoad = 1;; paramString.processLoad = 0)
    {
      if (paramString.pageSwitch == -1) {
        paramString.pageSwitch = 0;
      }
      return;
      paramString.baseLibDownload = 0;
      paramString.baselibLoad = 0;
      paramString.apkgDownload = 0;
    }
  }
  
  public static void setApkgDownload(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getState(paramString).apkgDownload = 1;
      return;
    }
    getState(paramString).apkgDownload = 0;
  }
  
  public static void setBaseLibDownload(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getState(paramString).baseLibDownload = 1;
      return;
    }
    getState(paramString).baseLibDownload = 0;
  }
  
  public static void setBaseLibLoad(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getState(paramString).baselibLoad = 1;
      return;
    }
    getState(paramString).baselibLoad = 0;
  }
  
  public static void setProcessLoad(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getState(paramString).processLoad = 1;
      return;
    }
    getState(paramString).processLoad = 0;
  }
  
  public static void setSwitchPage(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getState(paramString).pageSwitch = 1;
      return;
    }
    getState(paramString).pageSwitch = 0;
  }
  
  public static void updateState(String paramString, boolean paramBoolean)
  {
    paramString = getState(paramString);
    if ((paramString != null) && (paramBoolean))
    {
      if (paramString.apkgDownload == -1) {
        paramString.apkgDownload = 1;
      }
      if (paramString.baseLibDownload == -1) {
        paramString.baseLibDownload = 1;
      }
      if (paramString.baselibLoad == -1) {
        paramString.baselibLoad = 1;
      }
    }
  }
  
  public static class StartState
  {
    public int apkgDownload = -1;
    public int baseLibDownload = -1;
    public int baselibLoad = -1;
    public int pageSwitch = -1;
    public int processLoad = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppStartState
 * JD-Core Version:    0.7.0.1
 */