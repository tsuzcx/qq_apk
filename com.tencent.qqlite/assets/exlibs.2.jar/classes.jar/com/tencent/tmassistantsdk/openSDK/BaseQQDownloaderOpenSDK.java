package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.b.b;
import com.tencent.tmassistantsdk.b.c;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.f.a;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseQQDownloaderOpenSDK
{
  protected static final String TAG = "BaseQQDownloaderOpenSDK";
  protected String hostPackageName = null;
  protected int hostVersionCode = 0;
  protected Context mContext = null;
  protected ReferenceQueue mListenerQueue = new ReferenceQueue();
  protected ArrayList mWeakListenerArrayList = new ArrayList();
  protected int sdkAPILevel = 1;
  protected b sdkChannel = new b();
  
  public static int getQQDownloadApiLevel(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return 0;
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        if ((paramContext != null) && (paramContext.metaData != null))
        {
          int i = paramContext.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
          return i;
        }
      }
      catch (Exception paramContext)
      {
        k.b("BaseQQDownloaderOpenSDK", "packagename not found！");
      }
    }
    return 0;
  }
  
  public static boolean isExistActoin(long paramLong)
  {
    if (paramLong < 0L) {
      return false;
    }
    Object localObject = new b().a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if ((localc.a == paramLong) && (localc.c - localc.b <= 300000L)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public abstract long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString);
  
  public abstract long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2);
  
  public long addDownloadTaskFromWebview(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    paramString = formatIntentUriPath(5, localHashMap);
    long l = System.currentTimeMillis();
    k.b("BaseQQDownloaderOpenSDK", "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=" + "; dataItemType=0" + ";dataItemAction=" + paramString);
    return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramString, l, l + 300000L, 0, null);
  }
  
  public long buildAddDBData(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramTMQQDownloaderOpenSDKParam = formatMapParams(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2);
    }
    for (;;)
    {
      paramTMQQDownloaderOpenSDKParam = formatIntentUriPath(paramInt, paramTMQQDownloaderOpenSDKParam);
      long l = System.currentTimeMillis();
      k.b("BaseQQDownloaderOpenSDK", "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=" + "; dataItemType=0" + ";dataItemAction=" + paramTMQQDownloaderOpenSDKParam);
      return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramTMQQDownloaderOpenSDKParam, l, l + 300000L, 0, null);
      paramTMQQDownloaderOpenSDKParam = formatMapParams(paramTMQQDownloaderOpenSDKParam, true, true);
      paramTMQQDownloaderOpenSDKParam.put("verifytype", paramString2);
    }
  }
  
  protected long buildAddDBData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1L;
    }
    long l = System.currentTimeMillis();
    return this.sdkChannel.a(null, 0, null, 0, null, l, l + 300000L, 1, paramArrayOfByte);
  }
  
  public int checkQQDownloaderInstalled()
  {
    int i = 0;
    if (this.mContext == null) {
      throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
    }
    PackageManager localPackageManager = this.mContext.getPackageManager();
    if (localPackageManager != null) {
      try
      {
        if (localPackageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) != null)
        {
          int j = f.a().m();
          int k = this.sdkAPILevel;
          if (k > j) {
            i = 2;
          }
          return i;
        }
        return 1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        k.b("BaseQQDownloaderOpenSDK", "packagename not found！");
      }
    }
    return 1;
  }
  
  public abstract void destroyQQDownloaderOpenSDK();
  
  protected String formatEncryptUrl(String paramString)
  {
    paramString = paramString.getBytes();
    byte[] arrayOfByte = "ji*9^&43U0X-~./(".getBytes();
    paramString = URLEncoder.encode(a.a(new e().b(paramString, arrayOfByte), 0));
    return "tmast://encrypt?encryptdata=" + paramString;
  }
  
  protected String formatIntentUriPath(int paramInt, Map paramMap)
  {
    Object localObject;
    String str2;
    switch (paramInt)
    {
    default: 
      localObject = "appdetails";
      str2 = "tpmast://" + (String)localObject + "?";
      String str1 = "";
      localObject = str1;
      if (paramMap != null)
      {
        localObject = str1;
        if (paramMap.size() > 0)
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          paramInt = 0;
          paramMap = str1;
          label103:
          localObject = paramMap;
          if (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            str1 = (String)((Map.Entry)localObject).getKey();
            String str3 = (String)((Map.Entry)localObject).getValue();
            if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str3))) {
              break label304;
            }
            if (paramInt <= 0)
            {
              localObject = "";
              label171:
              paramMap = paramMap + (String)localObject + str1 + "=" + URLEncoder.encode(str3);
            }
          }
        }
      }
      break;
    }
    label304:
    for (;;)
    {
      paramInt += 1;
      break label103;
      localObject = "appdetails";
      break;
      localObject = "download";
      break;
      localObject = "appdetails";
      break;
      localObject = "updatedownload";
      break;
      localObject = "webview";
      break;
      localObject = "&";
      break label171;
      paramMap = str2 + (String)localObject;
      k.b("BaseQQDownloaderOpenSDK", "path:" + paramMap);
      return formatEncryptUrl(paramMap);
    }
  }
  
  protected Map formatMapParams(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = formatOplist(paramBoolean1, paramBoolean2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("hostpname", this.hostPackageName);
    localHashMap.put("hostversioncode", String.valueOf(this.hostVersionCode));
    localHashMap.put("sngappid", paramTMQQDownloaderOpenSDKParam.SNGAppId);
    localHashMap.put("appid", paramTMQQDownloaderOpenSDKParam.taskAppId);
    localHashMap.put("apkid", paramTMQQDownloaderOpenSDKParam.taskApkId);
    localHashMap.put("pname", paramTMQQDownloaderOpenSDKParam.taskPackageName);
    localHashMap.put("via", paramTMQQDownloaderOpenSDKParam.via);
    localHashMap.put("uin", paramTMQQDownloaderOpenSDKParam.uin);
    localHashMap.put("uintype", paramTMQQDownloaderOpenSDKParam.uinType);
    localHashMap.put("versioncode", String.valueOf(paramTMQQDownloaderOpenSDKParam.taskVersion));
    localHashMap.put("oplist", str);
    localHashMap.put("channelid", paramTMQQDownloaderOpenSDKParam.channelId);
    localHashMap.put("actionflag", paramTMQQDownloaderOpenSDKParam.actionFlag);
    localHashMap.put("sdkid", paramTMQQDownloaderOpenSDKParam.sdkId);
    return localHashMap;
  }
  
  protected String formatOplist(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = "";
    if ((paramBoolean1) && (paramBoolean2)) {
      str = "1;2";
    }
    do
    {
      return str;
      if (paramBoolean2) {
        return "2";
      }
    } while (!paramBoolean1);
    return "1";
  }
  
  public abstract TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam);
  
  public abstract void initQQDownloaderOpenSDK(Context paramContext);
  
  protected void onStateChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMQQDownloaderOpenSDKListener localITMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get();
      if (localITMQQDownloaderOpenSDKListener == null) {
        k.b("BaseQQDownloaderOpenSDK", "onDownloadStateChanged listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnDownloadTaskStateChanged(paramTMQQDownloaderOpenSDKParam, paramInt1, paramInt2, paramString);
      }
    }
  }
  
  public boolean registerListener(ITMQQDownloaderOpenSDKListener paramITMQQDownloaderOpenSDKListener)
  {
    if (paramITMQQDownloaderOpenSDKListener == null) {
      return false;
    }
    for (;;)
    {
      localObject = this.mListenerQueue.poll();
      if (localObject == null) {
        break;
      }
      this.mWeakListenerArrayList.remove(localObject);
    }
    Object localObject = this.mWeakListenerArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((ITMQQDownloaderOpenSDKListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMQQDownloaderOpenSDKListener) {
        return true;
      }
    }
    paramITMQQDownloaderOpenSDKListener = new WeakReference(paramITMQQDownloaderOpenSDKListener, this.mListenerQueue);
    this.mWeakListenerArrayList.add(paramITMQQDownloaderOpenSDKListener);
    return true;
  }
  
  public boolean removeDownloadTask(long paramLong)
  {
    if (paramLong >= 0L) {
      return this.sdkChannel.a(paramLong);
    }
    return false;
  }
  
  public abstract void startToAuthorized(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString);
  
  public void startToDownloadTaskList(Context paramContext)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode));
    if ((paramContext instanceof Application)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public abstract void startToWebView(Context paramContext, String paramString);
  
  public boolean unregisterListener(ITMQQDownloaderOpenSDKListener paramITMQQDownloaderOpenSDKListener)
  {
    if (paramITMQQDownloaderOpenSDKListener == null) {
      return false;
    }
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext()) {
      if ((ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get() == paramITMQQDownloaderOpenSDKListener)
      {
        localIterator.remove();
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
 * JD-Core Version:    0.7.0.1
 */