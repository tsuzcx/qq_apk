package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.c.a;
import com.tencent.tmassistantsdk.c.d;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
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
  
  private int getBatchRequestType(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      case 0: 
      default: 
        return 2;
      case 1: 
        return 1;
      case 2: 
        return 6;
      }
      return 5;
    }
    switch (paramInt)
    {
    default: 
      return 2;
    case 0: 
    case 1: 
      return 4;
    case 2: 
      return 8;
    }
    return 7;
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
        k.b("QQDownloaderOpenSDK", "onDownloadStateChanged listener = null");
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
        k.b("QQDownloaderOpenSDK", "OnQQDownloaderInvalid listener = null");
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
        k.b("QQDownloaderOpenSDK", "OnQQDownloaderInvalid listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnServiceFree();
      }
    }
  }
  
  public long addBatchUpdateOperationToDB(ArrayList paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramInt = getBatchRequestType(paramBoolean, paramInt);
      if ((paramInt == 3) || (paramBoolean)) {
        break;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam)localIterator.next();
        if (localTMQQDownloaderOpenSDKParam != null) {
          addToTaskList(localTMQQDownloaderOpenSDKParam);
        }
      }
    }
    paramArrayList = c.b(paramInt, paramArrayList, paramString1, paramString2, paramString3);
    if (paramArrayList != null)
    {
      paramArrayList = c.a(paramArrayList);
      if (paramArrayList != null) {
        return buildAddDBData(paramArrayList);
      }
    }
    return -1L;
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
    d.a();
    d.d();
    d.a().b();
    if (this.mContext != null)
    {
      c.a(this.mContext).b();
      QQDownloaderInstalled.a().b();
      QQDownloaderInstalled.a().b(this.mContext);
    }
    f.a().c();
    this.mContext = null;
  }
  
  public ArrayList getBatchTaskState(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (this.mContext == null) {
      throw new Exception("mContext shouldn't be null !");
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      throw new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
    }
    int i = getQQDownloadApiLevel(this.mContext);
    if (i <= 1) {
      return null;
    }
    if (i < 4)
    {
      paramArrayList = c.a(this.mContext).a((TMQQDownloaderOpenSDKParam)paramArrayList.get(0));
      if (paramArrayList != null)
      {
        paramString1 = new ArrayList();
        paramString1.add(paramArrayList);
        return paramString1;
      }
      return null;
    }
    return c.a(this.mContext).a(paramArrayList, paramString1, paramString2, paramString3);
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
    this.hostVersionCode = f.c(this.mContext);
    f.a().a(this.mContext);
    this.sdkAPILevel = 2;
    if (this.mContext != null)
    {
      c.a(this.mContext).a(this);
      QQDownloaderInstalled.a().a(this.mContext);
      QQDownloaderInstalled.a().a(this);
    }
    NetworkMonitorReceiver.a().b();
  }
  
  /* Error */
  public void onQQDownloaderInstalled(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 12
    //   4: ldc 252
    //   6: invokestatic 93	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 26	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   13: ifnull +65 -> 78
    //   16: aload_0
    //   17: getfield 26	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   20: invokevirtual 39	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 45 1 0
    //   30: ifeq +48 -> 78
    //   33: aload_1
    //   34: invokeinterface 49 1 0
    //   39: checkcast 51	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull -20 -> 24
    //   47: aload_0
    //   48: aload_2
    //   49: invokevirtual 254	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:getDownloadTaskState	(Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;)Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo;
    //   52: pop
    //   53: aload_0
    //   54: getfield 26	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   57: aload_2
    //   58: invokevirtual 257	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   61: pop
    //   62: goto -38 -> 24
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   75: goto -22 -> 53
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	TMQQDownloaderOpenSDK_V2
    //   0	81	1	paramContext	Context
    //   42	16	2	localTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   70	2	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	24	65	finally
    //   24	43	65	finally
    //   47	53	65	finally
    //   53	62	65	finally
    //   71	75	65	finally
    //   47	53	70	java/lang/Exception
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
        break label125;
      }
    }
    label125:
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
  
  public int startToBatchUpdateOperation(Context paramContext, ArrayList paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
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
    paramBoolean = bool;
    if (paramArrayList != null) {
      if (paramArrayList.size() != 0) {
        break label112;
      }
    }
    label112:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramInt = getBatchRequestType(paramBoolean, paramInt);
      if (!c.a(this.mContext).a(paramInt, paramArrayList, paramString1, paramString2, paramString3)) {
        k.d("QQDownloaderOpenSDK", "handleBatchRequestAction return false with batchRequestType=" + paramInt);
      }
      return 0;
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
    k.b("QQDownloaderOpenSDK", "startToWebView finalPath:" + paramContext);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      c.a(this.mContext).a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2
 * JD-Core Version:    0.7.0.1
 */