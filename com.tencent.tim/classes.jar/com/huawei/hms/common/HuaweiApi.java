package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.ConnectionManagerKey;
import com.huawei.hms.common.internal.HuaweiApiManager;
import com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class HuaweiApi<TOption extends Api.ApiOptions>
{
  private HuaweiApiManager a;
  private Context b;
  private ConnectionManagerKey<TOption> c;
  private TOption d;
  private AbstractClientBuilder<?, TOption> e;
  private String f;
  private String g;
  private String h;
  private SubAppInfo i;
  private WeakReference<Activity> j;
  private int k;
  private int l = 1;
  private boolean m = false;
  
  public HuaweiApi(Activity paramActivity, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder)
  {
    Checker.checkNonNull(paramActivity, "Null activity is not permitted.");
    this.j = new WeakReference(paramActivity);
    a(paramActivity, paramApi, paramTOption, paramAbstractClientBuilder, 0, null);
  }
  
  public HuaweiApi(Activity paramActivity, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt)
  {
    Checker.checkNonNull(paramActivity, "Null activity is not permitted.");
    this.j = new WeakReference(paramActivity);
    a(paramActivity, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, null);
  }
  
  public HuaweiApi(Activity paramActivity, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt, String paramString)
  {
    Checker.checkNonNull(paramActivity, "Null activity is not permitted.");
    this.j = new WeakReference(paramActivity);
    a(paramActivity, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, paramString);
  }
  
  public HuaweiApi(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder)
  {
    Checker.checkNonNull(paramContext, "Null context is not permitted.");
    a(paramContext, paramApi, paramTOption, paramAbstractClientBuilder, 0, null);
  }
  
  public HuaweiApi(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt)
  {
    Checker.checkNonNull(paramContext, "Null context is not permitted.");
    a(paramContext, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, null);
  }
  
  public HuaweiApi(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt, String paramString)
  {
    Checker.checkNonNull(paramContext, "Null context is not permitted.");
    a(paramContext, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, paramString);
  }
  
  private <TResult, TClient extends AnyClient> Task<TResult> a(TaskApiCall<TClient, TResult> paramTaskApiCall)
  {
    if (paramTaskApiCall.getToken() == null) {}
    for (TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();; localTaskCompletionSource = new TaskCompletionSource(paramTaskApiCall.getToken()))
    {
      this.a.sendRequest(this, paramTaskApiCall, localTaskCompletionSource);
      return localTaskCompletionSource.getTask();
    }
  }
  
  private void a(Context paramContext)
  {
    HMSBIInitializer.getInstance(paramContext).initBI();
  }
  
  private void a(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt, String paramString)
  {
    this.b = paramContext.getApplicationContext();
    this.a = HuaweiApiManager.getInstance(this.b);
    this.c = ConnectionManagerKey.createConnectionManagerKey(paramApi, paramTOption, paramString);
    this.d = paramTOption;
    this.e = paramAbstractClientBuilder;
    this.f = Util.getAppId(paramContext);
    this.g = this.f;
    this.h = Util.getCpId(paramContext);
    this.i = new SubAppInfo("");
    this.k = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals(this.f)) {
        break label117;
      }
      HMSLog.e("HuaweiApi", "subAppId is host appid");
    }
    for (;;)
    {
      a(paramContext);
      return;
      label117:
      HMSLog.i("HuaweiApi", "subAppId is " + paramString);
      this.i = new SubAppInfo(paramString);
    }
  }
  
  public Task<Boolean> disconnectService()
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.a.disconnectService(this, localTaskCompletionSource);
    return localTaskCompletionSource.getTask();
  }
  
  public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> paramTaskApiCall)
  {
    this.m = true;
    if (paramTaskApiCall == null)
    {
      HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
      paramTaskApiCall = new TaskCompletionSource();
      paramTaskApiCall.setException(new ApiException(Status.FAILURE));
      return paramTaskApiCall.getTask();
    }
    if (TextUtils.isEmpty(this.i.getSubAppID())) {}
    for (String str = this.g;; str = this.i.getSubAppID())
    {
      b.a(this.b, paramTaskApiCall.getUri(), str, paramTaskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
      return a(paramTaskApiCall);
    }
  }
  
  public int getApiLevel()
  {
    return this.l;
  }
  
  public String getAppID()
  {
    return this.g;
  }
  
  public AnyClient getClient(Looper paramLooper, HuaweiApiManager.ConnectionManager paramConnectionManager)
  {
    return this.e.buildClient(this.b, getClientSetting(), paramConnectionManager, paramConnectionManager);
  }
  
  protected ClientSettings getClientSetting()
  {
    ClientSettings localClientSettings = new ClientSettings(this.b.getPackageName(), this.b.getClass().getName(), getScopes(), this.f, null, this.i);
    localClientSettings.setCpID(this.h);
    if (this.j != null) {
      localClientSettings.setCpActivity((Activity)this.j.get());
    }
    return localClientSettings;
  }
  
  public ConnectionManagerKey<TOption> getConnectionManagerKey()
  {
    return this.c;
  }
  
  public Context getContext()
  {
    return this.b;
  }
  
  public int getKitSdkVersion()
  {
    return this.k;
  }
  
  public TOption getOption()
  {
    return this.d;
  }
  
  protected List<Scope> getScopes()
  {
    return Collections.emptyList();
  }
  
  public String getSubAppID()
  {
    return this.i.getSubAppID();
  }
  
  public void setApiLevel(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setKitSdkVersion(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setSubAppId(String paramString)
    throws ApiException
  {
    if (!setSubAppInfo(new SubAppInfo(paramString))) {
      throw new ApiException(Status.FAILURE);
    }
  }
  
  @Deprecated
  public boolean setSubAppInfo(SubAppInfo paramSubAppInfo)
  {
    HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
    if ((this.i != null) && (!TextUtils.isEmpty(this.i.getSubAppID())))
    {
      HMSLog.e("HuaweiApi", "subAppInfo is already set");
      return false;
    }
    if (paramSubAppInfo == null)
    {
      HMSLog.e("HuaweiApi", "subAppInfo is null");
      return false;
    }
    String str = paramSubAppInfo.getSubAppID();
    if (TextUtils.isEmpty(str))
    {
      HMSLog.e("HuaweiApi", "subAppId is empty");
      return false;
    }
    if (str.equals(this.f))
    {
      HMSLog.e("HuaweiApi", "subAppId is host appid");
      return false;
    }
    if (this.m)
    {
      HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
      return false;
    }
    this.i = new SubAppInfo(paramSubAppInfo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.HuaweiApi
 * JD-Core Version:    0.7.0.1
 */