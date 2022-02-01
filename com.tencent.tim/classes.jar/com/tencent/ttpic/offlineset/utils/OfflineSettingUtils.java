package com.tencent.ttpic.offlineset.utils;

import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.beans.ConfigJsonBean;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineSettingUtils
{
  private static final String CONFIG_NAME = "config.json";
  private static final int REQUEST_CHECK_CODE = 1;
  private static final int REQUEST_DOWNLOAD_ZIP_CODE = 2;
  private static String REQUEST_URL_PRE = "https://offline.qq.com/offline/check?";
  private static final String TAG = "OfflineSettingUtils";
  private static ArrayList<IDownloadedListener> sDownloadedListeners;
  private static IHttpClient sHttpClient;
  private static IResponseListener sResponseListener = new OfflineSettingUtils.1();
  
  public static void addDownloadLister(IDownloadedListener paramIDownloadedListener)
  {
    if (paramIDownloadedListener != null)
    {
      if (sDownloadedListeners == null) {
        sDownloadedListeners = new ArrayList();
      }
      if (!sDownloadedListeners.contains(paramIDownloadedListener)) {
        sDownloadedListeners.add(paramIDownloadedListener);
      }
    }
  }
  
  private static String getBid(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      paramString = "biz=" + Integer.valueOf(i);
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private static String getHVerion(String paramString)
  {
    int i = getLocalVersion(paramString);
    return "hver=" + i;
  }
  
  private static int getLocalVersion(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      paramString = FileOfflineUtil.readJsonStringFromFile(FileOfflineUtil.getOfflineDirPath() + File.separator + paramString + File.separator + "config.json");
    } while (paramString == null);
    paramString = (ConfigJsonBean)GsonUtils.json2Obj(paramString, new OfflineSettingUtils.2().getType());
    if (paramString != null) {}
    for (int i = paramString.version;; i = 0) {
      return i;
    }
  }
  
  public static String getOfflineCGIUrl(String paramString)
  {
    String str1 = null;
    String str2 = getBid(paramString);
    if (str2 != null)
    {
      str1 = REQUEST_URL_PRE;
      paramString = str1 + getHVerion(paramString);
      paramString = paramString + "&";
      paramString = paramString + getPlatformId();
      paramString = paramString + "&";
      str1 = paramString + str2;
    }
    return str1;
  }
  
  private static String getPlatformId()
  {
    return "pf=3";
  }
  
  private static boolean isNeedUpdate(JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramJsonObject = Integer.valueOf(GsonUtils.getIntUnsafe(paramJsonObject, "type"));
        if (paramJsonObject != null)
        {
          int i = paramJsonObject.intValue();
          if (i == 1) {
            return true;
          }
        }
      }
      catch (Exception paramJsonObject) {}
    }
    return false;
  }
  
  private static void notifyDownloadListeners(String paramString)
  {
    Iterator localIterator = sDownloadedListeners.iterator();
    while (localIterator.hasNext()) {
      ((IDownloadedListener)localIterator.next()).downloadCompleted(paramString);
    }
  }
  
  public static void removeDownloadListener(IDownloadedListener paramIDownloadedListener)
  {
    if ((paramIDownloadedListener != null) && (sDownloadedListeners != null)) {
      sDownloadedListeners.remove(paramIDownloadedListener);
    }
  }
  
  public static void setHttpClient(IHttpClient paramIHttpClient)
  {
    sHttpClient = paramIHttpClient;
    if (sHttpClient != null) {
      sHttpClient.setResponseListener(sResponseListener);
    }
  }
  
  private static void startDownload(JsonObject paramJsonObject, String paramString)
  {
    if (paramJsonObject == null) {}
    for (;;)
    {
      return;
      try
      {
        paramJsonObject = GsonUtils.getStringUnsafe(paramJsonObject, "url");
        if (paramJsonObject != null)
        {
          String str = FileOfflineUtil.getOfflineDirPath();
          if (sHttpClient != null)
          {
            sHttpClient.download(2, paramString, paramJsonObject, str);
            return;
          }
        }
      }
      catch (Exception paramJsonObject)
      {
        LogUtils.e("OfflineSettingUtils", "startDownload:" + paramJsonObject.getMessage());
      }
    }
  }
  
  public static boolean updateOfflinePage(String paramString)
  {
    if ((paramString == null) || (sHttpClient == null))
    {
      LogUtils.i("OfflineSettingUtils", "bid :" + paramString + " ,sHttpClient:" + sHttpClient);
      return false;
    }
    String str = getOfflineCGIUrl(paramString);
    LogUtils.i("OfflineSettingUtils", "getUrl:" + str);
    sHttpClient.get(1, paramString, str);
    return true;
  }
  
  public static abstract interface IDownloadedListener
  {
    public abstract void downloadCompleted(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.utils.OfflineSettingUtils
 * JD-Core Version:    0.7.0.1
 */