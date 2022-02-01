package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.b.e;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;

public class HmsInstanceId
{
  public static final String TAG = HmsInstanceId.class.getSimpleName();
  private static final byte[] a = new byte[0];
  private static final byte[] b = new byte[0];
  private Context c = null;
  private com.huawei.hms.aaid.c.c d = null;
  private HuaweiApi<Api.ApiOptions.NoOptions> e;
  
  private HmsInstanceId(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.d = new com.huawei.hms.aaid.c.c(paramContext, "aaid");
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {}
    for (this.e = new HuaweiApi((Activity)paramContext, localApi, null, new e());; this.e = new HuaweiApi(paramContext, localApi, null, new e()))
    {
      this.e.setKitSdkVersion(40001301);
      return;
    }
  }
  
  public static HmsInstanceId getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return new HmsInstanceId(paramContext);
  }
  
  public void deleteAAID()
    throws ApiException
  {
    try
    {
      if (this.d.d("aaid"))
      {
        this.d.e("aaid");
        this.d.e("creationTime");
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
    catch (Exception localException)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
  }
  
  public void deleteToken(String paramString1, String paramString2)
    throws ApiException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.K);
    }
    String str = com.huawei.hms.aaid.c.b.a(this.c, "push.deletetoken");
    try
    {
      DeleteTokenReq localDeleteTokenReq = new DeleteTokenReq();
      localDeleteTokenReq.setAppId(paramString1);
      localDeleteTokenReq.setScope(paramString2);
      localDeleteTokenReq.setPkgName(this.c.getPackageName());
      if (TextUtils.isEmpty(paramString1)) {
        localDeleteTokenReq.setAppId(Util.getAppId(this.c));
      }
      if (TextUtils.isEmpty(paramString2)) {
        localDeleteTokenReq.setScope("HCM");
      }
      paramString1 = com.huawei.hms.aaid.a.c.a(this.c, "push_client_self_info");
      if (!TextUtils.isEmpty(paramString1)) {
        localDeleteTokenReq.setToken(paramString1);
      }
      Tasks.await(this.e.doWrite(new com.huawei.hms.aaid.b.b("push.deletetoken", JsonUtil.createJsonString(localDeleteTokenReq), str)));
      com.huawei.hms.aaid.a.c.b(this.c, "push_client_self_info");
      return;
    }
    catch (Exception paramString1)
    {
      if ((paramString1.getCause() instanceof ApiException))
      {
        paramString1 = (ApiException)paramString1.getCause();
        com.huawei.hms.aaid.c.b.a(this.c, "push.deletetoken", str, paramString1.getStatusCode());
        throw paramString1;
      }
      com.huawei.hms.aaid.c.b.a(this.c, "push.deletetoken", str, com.huawei.hms.aaid.constant.a.t);
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
  }
  
  public Task<AAIDResult> getAAID()
  {
    try
    {
      Task localTask = Tasks.callInBackground(new com.huawei.hms.aaid.b.a(this.c.getApplicationContext()));
      return localTask;
    }
    catch (Exception localException)
    {
      TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
      localTaskCompletionSource.setException(com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t));
      return localTaskCompletionSource.getTask();
    }
  }
  
  public long getCreationTime()
  {
    try
    {
      if (!this.d.d("creationTime")) {
        getAAID();
      }
      long l = this.d.c("creationTime");
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public String getId()
  {
    return com.huawei.hms.aaid.c.a.b(this.c);
  }
  
  @Deprecated
  public String getToken()
  {
    try
    {
      String str = getToken(null, null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getToken(String paramString1, String paramString2)
    throws ApiException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.K);
    }
    String str = com.huawei.hms.aaid.c.b.a(this.c, "push.gettoken");
    try
    {
      paramString1 = com.huawei.hms.aaid.c.a.a(paramString1, paramString2, this.c);
      paramString1.setAaid(getId());
      HMSLog.d(TAG, "getToken req :" + paramString1.toString());
      paramString1 = ((TokenResult)Tasks.await(this.e.doWrite(new com.huawei.hms.aaid.b.c("push.gettoken", JsonUtil.createJsonString(paramString1), this.c, str)))).getToken();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if ((paramString1.getCause() instanceof ApiException))
      {
        paramString1 = (ApiException)paramString1.getCause();
        com.huawei.hms.aaid.c.b.a(this.c, "push.gettoken", str, paramString1.getStatusCode());
        throw paramString1;
      }
      com.huawei.hms.aaid.c.b.a(this.c, "push.gettoken", str, com.huawei.hms.aaid.constant.a.t);
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.HmsInstanceId
 * JD-Core Version:    0.7.0.1
 */