package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.b.e;
import com.huawei.hms.aaid.c.b;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.utils.JsonUtil;

public class HmsInstanceIdEx
{
  public static final String TAG = HmsInstanceIdEx.class.getSimpleName();
  private static final byte[] a = new byte[0];
  private Context b = null;
  private com.huawei.hms.aaid.c.c c = null;
  private HuaweiApi<Api.ApiOptions.NoOptions> d;
  
  private HmsInstanceIdEx(Context paramContext)
  {
    this.b = paramContext;
    this.c = new com.huawei.hms.aaid.c.c(paramContext, "aaid");
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {}
    for (this.d = new HuaweiApi((Activity)paramContext, localApi, null, new e());; this.d = new HuaweiApi(paramContext, localApi, null, new e()))
    {
      this.d.setKitSdkVersion(40001301);
      return;
    }
  }
  
  private String a(String paramString)
  {
    return "creationTime" + paramString;
  }
  
  public static HmsInstanceIdEx getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return new HmsInstanceIdEx(paramContext);
  }
  
  public void deleteAAID(String paramString)
    throws ApiException
  {
    if (paramString == null) {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.s);
    }
    try
    {
      if (this.c.d(paramString))
      {
        this.c.e(paramString);
        this.c.e(a(paramString));
      }
      return;
    }
    catch (RuntimeException paramString)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
    catch (Exception paramString)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
  }
  
  public String getAAId(String paramString)
    throws ApiException
  {
    if (paramString == null) {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.s);
    }
    try
    {
      if (this.c.d(paramString)) {
        return this.c.b(paramString);
      }
      String str = com.huawei.hms.aaid.c.a.a(this.b);
      str = com.huawei.hms.aaid.c.a.a(paramString + str);
      this.c.a(paramString, str);
      this.c.a(a(paramString), Long.valueOf(System.currentTimeMillis()));
      return str;
    }
    catch (RuntimeException paramString)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
    catch (Exception paramString)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
  }
  
  public long getCreationTime(String paramString)
    throws ApiException
  {
    if (paramString == null) {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.s);
    }
    try
    {
      if (!this.c.d(a(paramString))) {
        getAAId(paramString);
      }
      long l = this.c.c(a(paramString));
      return l;
    }
    catch (RuntimeException paramString)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
    catch (Exception paramString)
    {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t);
    }
  }
  
  public Task<TokenResult> getToken()
  {
    String str = b.a(this.b, "push.gettoken");
    try
    {
      Object localObject = com.huawei.hms.aaid.c.a.a(null, null, this.b);
      ((TokenReq)localObject).setAaid(HmsInstanceId.getInstance(this.b).getId());
      localObject = this.d.doWrite(new com.huawei.hms.aaid.b.c("push.gettoken", JsonUtil.createJsonString((IMessageEntity)localObject), this.b, str));
      return localObject;
    }
    catch (RuntimeException localRuntimeException)
    {
      TaskCompletionSource localTaskCompletionSource1 = new TaskCompletionSource();
      localTaskCompletionSource1.setException(com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t));
      b.a(this.b, "push.gettoken", str, com.huawei.hms.aaid.constant.a.t);
      return localTaskCompletionSource1.getTask();
    }
    catch (Exception localException)
    {
      TaskCompletionSource localTaskCompletionSource2 = new TaskCompletionSource();
      localTaskCompletionSource2.setException(com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.t));
      b.a(this.b, "push.gettoken", str, com.huawei.hms.aaid.constant.a.t);
      return localTaskCompletionSource2.getTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.HmsInstanceIdEx
 * JD-Core Version:    0.7.0.1
 */