package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.GetDownloadProgressResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.GetDownloadStateResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCBaseParam;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCDownloadParam;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCQueryDownloadInfo;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.OperateDownloadTaskRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.URIActionRequest;
import java.util.ArrayList;
import java.util.UUID;

public final class c
  implements com.tencent.tmassistantsdk.downloadclient.a
{
  private static c a = null;
  private com.tencent.tmassistantsdk.downloadclient.c b = null;
  private ITMQQDownloaderOpenSDKListener c = null;
  private String d = UUID.randomUUID().toString();
  
  public c() {}
  
  private c(Context paramContext)
  {
    if (paramContext != null) {
      b(paramContext);
    }
  }
  
  private static TMQQDownloaderOpenSDKParam a(IPCBaseParam paramIPCBaseParam)
  {
    if (paramIPCBaseParam == null) {
      return null;
    }
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
    localTMQQDownloaderOpenSDKParam.SNGAppId = paramIPCBaseParam.hostAppId;
    localTMQQDownloaderOpenSDKParam.taskAppId = paramIPCBaseParam.taskAppId;
    localTMQQDownloaderOpenSDKParam.taskPackageName = paramIPCBaseParam.taskPackageName;
    try
    {
      localTMQQDownloaderOpenSDKParam.taskVersion = Integer.valueOf(paramIPCBaseParam.taskVersion).intValue();
      localTMQQDownloaderOpenSDKParam.uin = paramIPCBaseParam.uin;
      localTMQQDownloaderOpenSDKParam.uinType = paramIPCBaseParam.uinType;
      localTMQQDownloaderOpenSDKParam.via = paramIPCBaseParam.via;
      localTMQQDownloaderOpenSDKParam.channelId = paramIPCBaseParam.channelId;
      return localTMQQDownloaderOpenSDKParam;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        k.b("QQDownloaderOpenSDKDataProcessor", "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
      }
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  protected static byte[] a(JceStruct paramJceStruct)
  {
    paramJceStruct = com.tencent.tmassistantsdk.openSDK.param.a.a(paramJceStruct);
    if (paramJceStruct != null)
    {
      paramJceStruct = com.tencent.tmassistantsdk.openSDK.param.a.a(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0)) {
        return paramJceStruct;
      }
      k.b("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
      return null;
    }
    k.b("QQDownloaderOpenSDKDataProcessor", "handleUriAction IPCRequest = null");
    return null;
  }
  
  protected static BatchDownloadActionRequest b(int paramInt, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    BatchDownloadActionRequest localBatchDownloadActionRequest = new BatchDownloadActionRequest();
    localBatchDownloadActionRequest.batchRequestType = paramInt;
    if (paramString1 != null) {
      localBatchDownloadActionRequest.via = paramString1;
    }
    if (paramString2 != null) {
      localBatchDownloadActionRequest.uin = paramString2;
    }
    if (paramString3 != null) {
      localBatchDownloadActionRequest.uinType = paramString3;
    }
    localBatchDownloadActionRequest.batchData = new ArrayList();
    paramString2 = "appList {";
    if (paramArrayList != null)
    {
      paramString1 = "appList {" + "appList.size=" + paramArrayList.size() + "\n";
      paramInt = 0;
      for (;;)
      {
        paramString2 = paramString1;
        if (paramInt >= paramArrayList.size()) {
          break;
        }
        paramString2 = b((TMQQDownloaderOpenSDKParam)paramArrayList.get(paramInt));
        paramString3 = new IPCDownloadParam();
        paramString3.baseParam = paramString2;
        localBatchDownloadActionRequest.batchData.add(paramString3);
        paramString1 = paramString1 + "element:" + paramInt + "IPCDownloadParam {IPCBaseParam {hostAppId:" + paramString3.baseParam.hostAppId + "|taskAppId:" + paramString3.baseParam.taskAppId + "|taskPackageName:" + paramString3.baseParam.taskPackageName + "|taskVersion:" + paramString3.baseParam.taskVersion + "}|actionFlag:" + paramString3.actionFlag + "|verifyType:" + paramString3.verifyType + "}\n";
        paramInt += 1;
      }
    }
    k.b("QQDownloaderOpenSDKDataProcessor", paramString2 + "}");
    return localBatchDownloadActionRequest;
  }
  
  private static IPCBaseParam b(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    if (paramTMQQDownloaderOpenSDKParam == null) {
      return null;
    }
    IPCBaseParam localIPCBaseParam = new IPCBaseParam();
    localIPCBaseParam.hostAppId = paramTMQQDownloaderOpenSDKParam.SNGAppId;
    localIPCBaseParam.taskAppId = paramTMQQDownloaderOpenSDKParam.taskAppId;
    localIPCBaseParam.taskPackageName = paramTMQQDownloaderOpenSDKParam.taskPackageName;
    localIPCBaseParam.taskVersion = String.valueOf(paramTMQQDownloaderOpenSDKParam.taskVersion);
    localIPCBaseParam.uin = paramTMQQDownloaderOpenSDKParam.uin;
    localIPCBaseParam.uinType = paramTMQQDownloaderOpenSDKParam.uinType;
    localIPCBaseParam.via = paramTMQQDownloaderOpenSDKParam.via;
    localIPCBaseParam.channelId = paramTMQQDownloaderOpenSDKParam.channelId;
    return localIPCBaseParam;
  }
  
  private void b(Context paramContext)
  {
    try
    {
      if ((this.b == null) && (paramContext != null))
      {
        this.b = TMAssistantDownloadSDKManager.getInstance(paramContext).getDownloadOpenSDKClient(this.d);
        if (this.b != null) {
          this.b.a(this);
        }
      }
      return;
    }
    finally {}
  }
  
  public final TMAssistantDownloadTaskInfo a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    Object localObject1 = null;
    k.b("QQDownloaderOpenSDKDataProcessor", "getDownloadTask param.sngAppid:" + paramTMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + paramTMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + paramTMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + paramTMQQDownloaderOpenSDKParam.taskVersion);
    paramTMQQDownloaderOpenSDKParam = b(paramTMQQDownloaderOpenSDKParam);
    Object localObject2 = new QueryDownloadTaskRequest();
    ((QueryDownloadTaskRequest)localObject2).baseParam = paramTMQQDownloaderOpenSDKParam;
    paramTMQQDownloaderOpenSDKParam = a((JceStruct)localObject2);
    if ((paramTMQQDownloaderOpenSDKParam != null) && (paramTMQQDownloaderOpenSDKParam.length > 0)) {}
    for (;;)
    {
      try
      {
        b(f.a().b());
        if (this.b == null) {
          break label232;
        }
        paramTMQQDownloaderOpenSDKParam = this.b.a(paramTMQQDownloaderOpenSDKParam);
        paramTMQQDownloaderOpenSDKParam = com.tencent.tmassistantsdk.openSDK.param.a.a(paramTMQQDownloaderOpenSDKParam);
        if (paramTMQQDownloaderOpenSDKParam == null) {
          break;
        }
        localObject2 = (QueryDownloadTaskResponse)com.tencent.tmassistantsdk.openSDK.param.a.a(paramTMQQDownloaderOpenSDKParam);
        k.b("QQDownloaderOpenSDKDataProcessor", "QueryDownloadTaskResponse downloadTask state:" + ((QueryDownloadTaskResponse)localObject2).state);
        int i = f.a(((QueryDownloadTaskResponse)localObject2).state);
        paramTMQQDownloaderOpenSDKParam = localObject1;
        if (localObject2 != null) {
          paramTMQQDownloaderOpenSDKParam = new TMAssistantDownloadTaskInfo(((QueryDownloadTaskResponse)localObject2).url, ((QueryDownloadTaskResponse)localObject2).savePath, i, ((QueryDownloadTaskResponse)localObject2).receivedLen, ((QueryDownloadTaskResponse)localObject2).totalLen, "application/vnd.android.package-archive");
        }
        return paramTMQQDownloaderOpenSDKParam;
      }
      catch (Throwable paramTMQQDownloaderOpenSDKParam)
      {
        paramTMQQDownloaderOpenSDKParam.printStackTrace();
        return null;
      }
      k.b("QQDownloaderOpenSDKDataProcessor", "getDownloadTask sendData = null");
      label232:
      paramTMQQDownloaderOpenSDKParam = null;
    }
    k.b("QQDownloaderOpenSDKDataProcessor", "getDownloadTask IPCResponse = null");
    return null;
  }
  
  public final ArrayList a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (paramArrayList == null) {
      return null;
    }
    k.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos appList.size:" + paramArrayList.size());
    paramString1 = a(b(3, paramArrayList, paramString1, paramString2, paramString3));
    paramArrayList = null;
    if ((paramString1 != null) && (paramString1.length > 0)) {}
    for (;;)
    {
      try
      {
        b(f.a().b());
        if (this.b != null) {
          paramArrayList = this.b.a(paramString1);
        }
        paramArrayList = com.tencent.tmassistantsdk.openSDK.param.a.a(paramArrayList);
        if (paramArrayList == null) {
          break label321;
        }
        paramString2 = (BatchDownloadActionResponse)com.tencent.tmassistantsdk.openSDK.param.a.a(paramArrayList);
        if (paramString2 == null) {
          break label311;
        }
        paramArrayList = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + paramString2.batchRequestType;
        if (paramString2.batchData == null) {
          break label285;
        }
        paramString1 = paramArrayList + "response.batchData.size:" + paramString2.batchData.size();
        paramArrayList = new ArrayList();
        int i = 0;
        if (i >= paramString2.batchData.size()) {
          break;
        }
        paramString3 = (IPCQueryDownloadInfo)paramString2.batchData.get(i);
        int j = f.a(paramString3.state);
        if (paramString3 != null) {
          paramArrayList.add(new TMAssistantDownloadTaskInfo(paramString3.url, paramString3.savePath, j, paramString3.receivedLen, paramString3.totalLen, "application/vnd.android.package-archive"));
        }
        i += 1;
        continue;
        k.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos sendData = null or length = 0");
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        return null;
      }
    }
    for (;;)
    {
      k.b("QQDownloaderOpenSDKDataProcessor", paramString1);
      return paramArrayList;
      label285:
      paramString1 = paramArrayList + "response.batchData = null";
      paramArrayList = null;
    }
    label311:
    k.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos BatchDownloadActionResponse response = null");
    return null;
    label321:
    k.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos IPCResponse resp = null");
    return null;
  }
  
  public final void a()
  {
    if (this.c != null) {
      this.c.OnQQDownloaderInvalid();
    }
    Context localContext = f.a().b();
    if (localContext != null) {
      TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.d);
    }
    this.b = null;
  }
  
  public final void a(ITMQQDownloaderOpenSDKListener paramITMQQDownloaderOpenSDKListener)
  {
    this.c = paramITMQQDownloaderOpenSDKListener;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.tencent.tmassistantsdk.openSDK.param.a.a(paramArrayOfByte);
      Object localObject = com.tencent.tmassistantsdk.openSDK.param.a.a(paramArrayOfByte);
      switch (paramArrayOfByte.head.cmdId)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (localObject == null);
              paramArrayOfByte = (GetDownloadStateResponse)localObject;
              localObject = a(paramArrayOfByte.requestParam);
            } while ((localObject == null) || (this.c == null));
            k.b("QQDownloaderOpenSDKDataProcessor", "状态回调：GetDownloadStateResponse param.taskAppId:" + ((TMQQDownloaderOpenSDKParam)localObject).taskAppId + ",param.taskPackageName:" + ((TMQQDownloaderOpenSDKParam)localObject).taskPackageName + ",state:" + paramArrayOfByte.state + ",response.errorCode" + paramArrayOfByte.errorCode);
            this.c.OnDownloadTaskStateChanged((TMQQDownloaderOpenSDKParam)localObject, f.a(paramArrayOfByte.state), f.b(paramArrayOfByte.errorCode), paramArrayOfByte.errorMsg);
            return;
          } while (localObject == null);
          paramArrayOfByte = (GetDownloadProgressResponse)localObject;
          localObject = a(paramArrayOfByte.requestParam);
        } while ((localObject == null) || (this.c == null));
        k.b("QQDownloaderOpenSDKDataProcessor", "进度回调：GetDownloadProgressResponse response.receivedLen:" + paramArrayOfByte.receivedLen + ",response.totalLen" + paramArrayOfByte.totalLen);
        this.c.OnDownloadTaskProgressChanged((TMQQDownloaderOpenSDKParam)localObject, paramArrayOfByte.receivedLen, paramArrayOfByte.totalLen);
        return;
      } while (this.c == null);
      this.c.OnServiceFree();
      return;
    }
    k.b("QQDownloaderOpenSDKDataProcessor", "onActionResult reponseData = null");
  }
  
  public final boolean a(int paramInt, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    k.b("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction batchRequestType:" + paramInt + "|appList:" + paramArrayList);
    paramArrayList = a(b(paramInt, paramArrayList, paramString1, paramString2, paramString3));
    if ((paramArrayList != null) && (paramArrayList.length > 0)) {
      try
      {
        b(f.a().b());
        if (this.b != null)
        {
          this.b.b(paramArrayList);
          bool = true;
        }
        return bool;
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
    }
    k.b("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction sendData = null or length = 0");
    return false;
  }
  
  public final boolean a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    k.b("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask requestType:" + paramInt + "  param.sngAppid:" + paramTMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + paramTMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + paramTMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + paramTMQQDownloaderOpenSDKParam.taskVersion + "| param.actionFlag:" + paramString2 + " | verifyType:" + paramString3);
    OperateDownloadTaskRequest localOperateDownloadTaskRequest = new OperateDownloadTaskRequest();
    paramTMQQDownloaderOpenSDKParam = b(paramTMQQDownloaderOpenSDKParam);
    localOperateDownloadTaskRequest.requestType = paramInt;
    localOperateDownloadTaskRequest.baseParam = paramTMQQDownloaderOpenSDKParam;
    localOperateDownloadTaskRequest.actionFlag = paramString2;
    localOperateDownloadTaskRequest.verifyType = paramString3;
    localOperateDownloadTaskRequest.opList = paramString1;
    paramTMQQDownloaderOpenSDKParam = a(localOperateDownloadTaskRequest);
    if ((paramTMQQDownloaderOpenSDKParam != null) && (paramTMQQDownloaderOpenSDKParam.length > 0)) {
      try
      {
        b(f.a().b());
        if (this.b != null)
        {
          this.b.b(paramTMQQDownloaderOpenSDKParam);
          bool = true;
        }
        return bool;
      }
      catch (Throwable paramTMQQDownloaderOpenSDKParam)
      {
        paramTMQQDownloaderOpenSDKParam.printStackTrace();
        return false;
      }
    }
    k.b("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask sendData = null");
    return false;
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = a(new URIActionRequest(paramString));
      if ((paramString != null) && (paramString.length > 0)) {
        try
        {
          b(f.a().b());
          if (this.b != null)
          {
            this.b.b(paramString);
            return false;
          }
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          return false;
        }
      }
    }
    k.b("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
    return false;
  }
  
  public final void b()
  {
    this.c = null;
    Context localContext = f.a().b();
    if (localContext != null) {
      TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.d);
    }
    this.b = null;
  }
  
  public final void c()
  {
    if (this.b != null)
    {
      Context localContext = f.a().b();
      if (localContext != null) {
        TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.d);
      }
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.c
 * JD-Core Version:    0.7.0.1
 */