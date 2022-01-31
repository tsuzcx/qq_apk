package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.c.a;
import com.tencent.tmassistantsdk.c.b;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.f.j;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TMQQDownloaderOpenSDK_V2
  extends BaseQQDownloaderOpenSDK
  implements ITMQQDownloaderOpenSDKListener, com.tencent.tmassistantsdk.openSDK.QQDownloader.c
{
  protected static final String TAG = "QQDownloaderOpenSDK";
  protected static TMQQDownloaderOpenSDK_V2 mInstance = null;
  protected CopyOnWriteArrayList mTaskList = null;
  
  public static String about()
  {
    return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
  }
  
  private void addToTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    if (paramTMQQDownloaderOpenSDKParam != null) {}
    for (;;)
    {
      try
      {
        TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam;
        if (this.mTaskList != null)
        {
          Iterator localIterator = this.mTaskList.iterator();
          if (!localIterator.hasNext()) {
            break label145;
          }
          localTMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam)localIterator.next();
          if (localTMQQDownloaderOpenSDKParam.taskAppId == null) {
            continue;
          }
          if (!localTMQQDownloaderOpenSDKParam.taskAppId.equals(paramTMQQDownloaderOpenSDKParam.taskAppId)) {
            continue;
          }
          if (localTMQQDownloaderOpenSDKParam.taskPackageName == null) {
            break label150;
          }
          if (!localTMQQDownloaderOpenSDKParam.taskPackageName.equals(paramTMQQDownloaderOpenSDKParam.taskPackageName)) {
            continue;
          }
          break label150;
          if (i == 0) {
            this.mTaskList.add(paramTMQQDownloaderOpenSDKParam);
          }
        }
        return;
        if (localTMQQDownloaderOpenSDKParam.taskPackageName == null) {
          continue;
        }
        boolean bool = localTMQQDownloaderOpenSDKParam.taskPackageName.equals(paramTMQQDownloaderOpenSDKParam.taskPackageName);
        if (bool != true) {
          continue;
        }
        i = 1;
        continue;
        i = 0;
      }
      finally {}
      label145:
      continue;
      label150:
      int i = 1;
    }
  }
  
  public static TMQQDownloaderOpenSDK_V2 getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMQQDownloaderOpenSDK_V2();
      }
      TMQQDownloaderOpenSDK_V2 localTMQQDownloaderOpenSDK_V2 = mInstance;
      return localTMQQDownloaderOpenSDK_V2;
    }
    finally {}
  }
  
  private void onProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMQQDownloaderOpenSDKListener localITMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get();
      if (localITMQQDownloaderOpenSDKListener == null) {
        j.b("QQDownloaderOpenSDK", "onDownloadStateChanged listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnDownloadTaskProgressChanged(paramTMQQDownloaderOpenSDKParam, paramLong1, paramLong2);
      }
    }
  }
  
  public void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2)
  {
    if (paramTMQQDownloaderOpenSDKParam != null) {
      onProgressChanged(paramTMQQDownloaderOpenSDKParam, paramLong1, paramLong2);
    }
  }
  
  public void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt1, int paramInt2, String paramString)
  {
    if (paramTMQQDownloaderOpenSDKParam != null) {
      onStateChanged(paramTMQQDownloaderOpenSDKParam, paramInt1, paramInt2, paramString);
    }
  }
  
  public void OnQQDownloaderInvalid()
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMQQDownloaderOpenSDKListener localITMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get();
      if (localITMQQDownloaderOpenSDKListener == null) {
        j.b("QQDownloaderOpenSDK", "OnQQDownloaderInvalid listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnQQDownloaderInvalid();
      }
    }
  }
  
  public void OnServiceFree()
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMQQDownloaderOpenSDKListener localITMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get();
      if (localITMQQDownloaderOpenSDKListener == null) {
        j.b("QQDownloaderOpenSDK", "OnQQDownloaderInvalid listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnServiceFree();
      }
    }
  }
  
  public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 2);
  }
  
  public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, true, true, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString, 3);
  }
  
  public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 1);
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    NetworkMonitorReceiver.a().c();
    b.a().b();
    com.tencent.tmassistantsdk.c.e.a();
    com.tencent.tmassistantsdk.c.e.d();
    com.tencent.tmassistantsdk.c.e.a().b();
    if (this.mContext != null)
    {
      c.a(this.mContext).b();
      QQDownloaderInstalled.a().b();
      QQDownloaderInstalled.a().b(this.mContext);
    }
    com.tencent.tmassistantsdk.f.e.a().c();
    this.mContext = null;
  }
  
  public ArrayList getBatchTaskState(ArrayList paramArrayList)
  {
    if (this.mContext == null) {
      throw new Exception("mContext shouldn't be null !");
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      throw new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
    }
    int i = getQQDownloadApiLevel(this.mContext);
    if (i <= 0) {
      return null;
    }
    if (i < 4)
    {
      paramArrayList = c.a(this.mContext).a((TMQQDownloaderOpenSDKParam)paramArrayList.get(0));
      if (paramArrayList != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramArrayList);
        return localArrayList;
      }
      return null;
    }
    return c.a(this.mContext).a(paramArrayList);
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    if (this.mContext == null) {
      throw new Exception("Context shouldn't be null !");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      throw new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
    }
    return c.a(this.mContext).a(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void initQQDownloaderOpenSDK(Context paramContext)
  {
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = com.tencent.tmassistantsdk.f.e.c(this.mContext);
    com.tencent.tmassistantsdk.f.e.a().a(this.mContext);
    this.sdkAPILevel = 2;
    if (this.mContext != null)
    {
      c.a(this.mContext).a(this);
      QQDownloaderInstalled.a().a(this.mContext);
      QQDownloaderInstalled.a().a(this);
    }
    NetworkMonitorReceiver.a().b();
    b.a().c();
    com.tencent.tmassistantsdk.c.e.a();
    com.tencent.tmassistantsdk.c.e.c();
  }
  
  public void onQQDownloaderInstalled(Context paramContext)
  {
    try
    {
      j.b("QQDownloaderOpenSDK", "received qqdownload install broadcase!");
      paramContext = this.mTaskList.iterator();
      while (paramContext.hasNext())
      {
        TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam)paramContext.next();
        if (localTMQQDownloaderOpenSDKParam != null) {
          try
          {
            getDownloadTaskState(localTMQQDownloaderOpenSDKParam);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    finally {}
  }
  
  public void releaseIPCConnected()
  {
    if (this.mContext != null) {
      c.a(this.mContext).c();
    }
  }
  
  public void startToAppDetail(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 1;
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    paramContext = UUID.randomUUID().toString();
    if (paramBoolean1)
    {
      a.a();
      DownloadChunkLogInfo localDownloadChunkLogInfo = a.a((byte)1);
      localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
      localDownloadChunkLogInfo.UUID = paramContext;
      localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
      localDownloadChunkLogInfo.resultState = 1;
      a.a().a(localDownloadChunkLogInfo);
    }
    if (paramTMQQDownloaderOpenSDKParam != null)
    {
      paramContext = super.formatOplist(paramBoolean1, paramBoolean2);
      if (1 != paramInt) {
        break label124;
      }
    }
    label124:
    for (paramInt = i;; paramInt = 4)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      c.a(this.mContext).a(paramTMQQDownloaderOpenSDKParam, paramInt, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, null);
      return;
    }
  }
  
  public void startToAuthorized(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    paramContext = UUID.randomUUID().toString();
    a.a();
    DownloadChunkLogInfo localDownloadChunkLogInfo = a.a((byte)1);
    localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
    localDownloadChunkLogInfo.UUID = paramContext;
    localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
    localDownloadChunkLogInfo.resultState = 1;
    a.a().a(localDownloadChunkLogInfo);
    if (paramTMQQDownloaderOpenSDKParam != null)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      paramContext = super.formatOplist(true, true);
      c.a(this.mContext).a(paramTMQQDownloaderOpenSDKParam, 3, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString);
    }
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    paramContext = super.formatEncryptUrl(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      c.a(this.mContext).a(paramContext);
    }
  }
  
  public int startToBatchUpdateOperation(Context paramContext, ArrayList paramArrayList, boolean paramBoolean, int paramInt)
  {
    int j = 2;
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    int i = getQQDownloadApiLevel(paramContext);
    if (i <= 0) {
      return 1;
    }
    if (i < 4) {
      return 2;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      i = j;
      switch (paramInt)
      {
      default: 
        i = j;
      case 0: 
        TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
        localTMQQDownloaderOpenSDKParam.uin = "";
        localTMQQDownloaderOpenSDKParam.uinType = "";
        paramContext = paramArrayList;
        if (paramArrayList == null) {
          paramContext = new ArrayList();
        }
        paramContext.add(localTMQQDownloaderOpenSDKParam);
      }
    }
    for (;;)
    {
      if (!c.a(this.mContext).a(i, paramContext)) {
        j.d("QQDownloaderOpenSDK", "handleBatchRequestAction return false with batchRequestType=" + i);
      }
      return 0;
      i = 1;
      break;
      i = 6;
      break;
      i = 5;
      break;
      switch (paramInt)
      {
      default: 
        i = j;
        paramContext = paramArrayList;
        break;
      case 0: 
      case 1: 
        i = 4;
        paramContext = paramArrayList;
        break;
      case 2: 
        i = 8;
        paramContext = paramArrayList;
        break;
      case 3: 
        i = 7;
        paramContext = paramArrayList;
      }
    }
  }
  
  public void startToDownloadTaskList(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {}
    do
    {
      return;
      paramContext = UUID.randomUUID().toString();
      if (paramBoolean1)
      {
        a.a();
        DownloadChunkLogInfo localDownloadChunkLogInfo = a.a((byte)1);
        localDownloadChunkLogInfo.UUID = paramContext;
        localDownloadChunkLogInfo.requestUrl = "";
        localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
        localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
        a.a().a(localDownloadChunkLogInfo);
      }
    } while (paramTMQQDownloaderOpenSDKParam == null);
    paramContext = super.formatOplist(paramBoolean1, paramBoolean2);
    if (1 == paramInt) {}
    for (paramInt = 2;; paramInt = 5)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      c.a(this.mContext).a(paramTMQQDownloaderOpenSDKParam, paramInt, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, null);
      return;
    }
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new Exception("param url shouldn't be null!");
    }
    paramContext = new HashMap();
    paramContext.put("url", paramString);
    paramContext = super.formatIntentUriPath(5, paramContext);
    j.b("QQDownloaderOpenSDK", "startToWebView finalPath:" + paramContext);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      c.a(this.mContext).a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2
 * JD-Core Version:    0.7.0.1
 */