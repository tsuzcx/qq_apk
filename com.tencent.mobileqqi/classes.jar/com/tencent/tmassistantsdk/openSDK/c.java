package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.j;
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
        j.b("QQDownloaderOpenSDKDataProcessor", "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
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
  
  private static byte[] a(JceStruct paramJceStruct)
  {
    paramJceStruct = com.tencent.tmassistantsdk.openSDK.param.a.a(paramJceStruct);
    if (paramJceStruct != null)
    {
      paramJceStruct = com.tencent.tmassistantsdk.openSDK.param.a.a(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0)) {
        return paramJceStruct;
      }
      j.b("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
      return null;
    }
    j.b("QQDownloaderOpenSDKDataProcessor", "handleUriAction IPCRequest = null");
    return null;
  }
  
  private BatchDownloadActionRequest b(int paramInt, ArrayList paramArrayList)
  {
    BatchDownloadActionRequest localBatchDownloadActionRequest = new BatchDownloadActionRequest();
    localBatchDownloadActionRequest.batchRequestType = paramInt;
    localBatchDownloadActionRequest.batchData = new ArrayList();
    Object localObject = "appList {";
    if (paramArrayList != null)
    {
      String str = "appList {" + "appList.size=" + paramArrayList.size() + "\n";
      paramInt = 0;
      for (;;)
      {
        localObject = str;
        if (paramInt >= paramArrayList.size()) {
          break;
        }
        localObject = b((TMQQDownloaderOpenSDKParam)paramArrayList.get(paramInt));
        IPCDownloadParam localIPCDownloadParam = new IPCDownloadParam();
        localIPCDownloadParam.baseParam = ((IPCBaseParam)localObject);
        localBatchDownloadActionRequest.batchData.add(localIPCDownloadParam);
        str = str + "element:" + paramInt + "IPCDownloadParam {IPCBaseParam {hostAppId:" + localIPCDownloadParam.baseParam.hostAppId + "|taskAppId:" + localIPCDownloadParam.baseParam.taskAppId + "|taskPackageName:" + localIPCDownloadParam.baseParam.taskPackageName + "|taskVersion:" + localIPCDownloadParam.baseParam.taskVersion + "}|actionFlag:" + localIPCDownloadParam.actionFlag + "|verifyType:" + localIPCDownloadParam.verifyType + "}\n";
        paramInt += 1;
      }
    }
    j.b("QQDownloaderOpenSDKDataProcessor", (String)localObject + "}");
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
    j.b("QQDownloaderOpenSDKDataProcessor", "getDownloadTask param.sngAppid:" + paramTMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + paramTMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + paramTMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + paramTMQQDownloaderOpenSDKParam.taskVersion);
    paramTMQQDownloaderOpenSDKParam = b(paramTMQQDownloaderOpenSDKParam);
    Object localObject2 = new QueryDownloadTaskRequest();
    ((QueryDownloadTaskRequest)localObject2).baseParam = paramTMQQDownloaderOpenSDKParam;
    paramTMQQDownloaderOpenSDKParam = a((JceStruct)localObject2);
    if ((paramTMQQDownloaderOpenSDKParam != null) && (paramTMQQDownloaderOpenSDKParam.length > 0)) {}
    for (;;)
    {
      try
      {
        b(e.a().b());
        if (this.b == null) {
          break label229;
        }
        paramTMQQDownloaderOpenSDKParam = this.b.a(paramTMQQDownloaderOpenSDKParam);
        paramTMQQDownloaderOpenSDKParam = com.tencent.tmassistantsdk.openSDK.param.a.a(paramTMQQDownloaderOpenSDKParam);
        if (paramTMQQDownloaderOpenSDKParam == null) {
          break;
        }
        localObject2 = (QueryDownloadTaskResponse)com.tencent.tmassistantsdk.openSDK.param.a.a(paramTMQQDownloaderOpenSDKParam);
        j.b("QQDownloaderOpenSDKDataProcessor", "QueryDownloadTaskResponse downloadTask:" + localObject2);
        int i = e.a(((QueryDownloadTaskResponse)localObject2).state);
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
      j.b("QQDownloaderOpenSDKDataProcessor", "getDownloadTask sendData = null");
      label229:
      paramTMQQDownloaderOpenSDKParam = null;
    }
    j.b("QQDownloaderOpenSDKDataProcessor", "getDownloadTask IPCResponse = null");
    return null;
  }
  
  public final ArrayList a(ArrayList paramArrayList)
  {
    IPCQueryDownloadInfo localIPCQueryDownloadInfo = null;
    if (paramArrayList == null) {
      return null;
    }
    j.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos appList.size:" + paramArrayList.size());
    paramArrayList = a(b(3, paramArrayList));
    if ((paramArrayList != null) && (paramArrayList.length > 0)) {}
    String str;
    for (;;)
    {
      try
      {
        b(e.a().b());
        if (this.b != null)
        {
          paramArrayList = this.b.a(paramArrayList);
          paramArrayList = com.tencent.tmassistantsdk.openSDK.param.a.a(paramArrayList);
          if (paramArrayList == null) {
            break label325;
          }
          BatchDownloadActionResponse localBatchDownloadActionResponse = (BatchDownloadActionResponse)com.tencent.tmassistantsdk.openSDK.param.a.a(paramArrayList);
          if (localBatchDownloadActionResponse == null) {
            break label315;
          }
          paramArrayList = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + localBatchDownloadActionResponse.batchRequestType;
          if (localBatchDownloadActionResponse.batchData == null) {
            break label287;
          }
          str = paramArrayList + "response.batchData.size:" + localBatchDownloadActionResponse.batchData.size();
          paramArrayList = new ArrayList();
          int i = 0;
          if (i >= localBatchDownloadActionResponse.batchData.size()) {
            break;
          }
          localIPCQueryDownloadInfo = (IPCQueryDownloadInfo)localBatchDownloadActionResponse.batchData.get(i);
          int j = e.a(localIPCQueryDownloadInfo.state);
          if (localIPCQueryDownloadInfo != null) {
            paramArrayList.add(new TMAssistantDownloadTaskInfo(localIPCQueryDownloadInfo.url, localIPCQueryDownloadInfo.savePath, j, localIPCQueryDownloadInfo.receivedLen, localIPCQueryDownloadInfo.totalLen, "application/vnd.android.package-archive"));
          }
          i += 1;
          continue;
          j.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos sendData = null or length = 0");
        }
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        return null;
      }
      paramArrayList = null;
    }
    for (;;)
    {
      j.b("QQDownloaderOpenSDKDataProcessor", str);
      return paramArrayList;
      label287:
      str = paramArrayList + "response.batchData = null";
      paramArrayList = localIPCQueryDownloadInfo;
    }
    label315:
    j.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos BatchDownloadActionResponse response = null");
    return null;
    label325:
    j.b("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos IPCResponse resp = null");
    return null;
  }
  
  public final void a()
  {
    if (this.c != null) {
      this.c.OnQQDownloaderInvalid();
    }
    Context localContext = e.a().b();
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
            j.b("QQDownloaderOpenSDKDataProcessor", "状态回调：GetDownloadStateResponse param.taskAppId:" + ((TMQQDownloaderOpenSDKParam)localObject).taskAppId + ",param.taskPackageName:" + ((TMQQDownloaderOpenSDKParam)localObject).taskPackageName + ",state:" + paramArrayOfByte.state + ",response.errorCode" + paramArrayOfByte.errorCode);
            this.c.OnDownloadTaskStateChanged((TMQQDownloaderOpenSDKParam)localObject, e.a(paramArrayOfByte.state), e.b(paramArrayOfByte.errorCode), paramArrayOfByte.errorMsg);
            return;
          } while (localObject == null);
          paramArrayOfByte = (GetDownloadProgressResponse)localObject;
          localObject = a(paramArrayOfByte.requestParam);
        } while ((localObject == null) || (this.c == null));
        j.b("QQDownloaderOpenSDKDataProcessor", "进度回调：GetDownloadProgressResponse response.receivedLen:" + paramArrayOfByte.receivedLen + ",response.totalLen" + paramArrayOfByte.totalLen);
        this.c.OnDownloadTaskProgressChanged((TMQQDownloaderOpenSDKParam)localObject, paramArrayOfByte.receivedLen, paramArrayOfByte.totalLen);
        return;
      } while (this.c == null);
      this.c.OnServiceFree();
      return;
    }
    j.b("QQDownloaderOpenSDKDataProcessor", "onActionResult reponseData = null");
  }
  
  public final boolean a(int paramInt, ArrayList paramArrayList)
  {
    boolean bool = false;
    j.b("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction batchRequestType:" + paramInt + "|appList:" + paramArrayList);
    paramArrayList = a(b(paramInt, paramArrayList));
    if ((paramArrayList != null) && (paramArrayList.length > 0)) {
      try
      {
        b(e.a().b());
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
    j.b("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction sendData = null or length = 0");
    return false;
  }
  
  public final boolean a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    j.b("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask requestType:" + paramInt + "  param.sngAppid:" + paramTMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + paramTMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + paramTMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + paramTMQQDownloaderOpenSDKParam.taskVersion + "| param.actionFlag:" + paramString2 + " | verifyType:" + paramString3);
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
        b(e.a().b());
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
    j.b("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask sendData = null");
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
          b(e.a().b());
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
    j.b("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
    return false;
  }
  
  public final void b()
  {
    this.c = null;
    Context localContext = e.a().b();
    if (localContext != null) {
      TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.d);
    }
    this.b = null;
  }
  
  public final void c()
  {
    if (this.b != null)
    {
      Context localContext = e.a().b();
      if (localContext != null) {
        TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.d);
      }
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.c
 * JD-Core Version:    0.7.0.1
 */