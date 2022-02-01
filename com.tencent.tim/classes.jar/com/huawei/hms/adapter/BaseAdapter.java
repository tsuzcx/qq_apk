package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.a.b;
import com.huawei.hms.adapter.a.c;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class BaseAdapter
{
  private WeakReference<ApiClient> a;
  private WeakReference<Activity> b;
  private BaseCallBack c;
  private String d;
  private String e;
  private Parcelable f;
  private BaseCallBack g;
  private String h;
  private Context i;
  private RequestHeader j = new RequestHeader();
  private ResponseHeader k = new ResponseHeader();
  private c l = new BaseAdapter.1(this);
  
  public BaseAdapter(ApiClient paramApiClient)
  {
    this.a = new WeakReference(paramApiClient);
  }
  
  public BaseAdapter(ApiClient paramApiClient, Activity paramActivity)
  {
    this.a = new WeakReference(paramApiClient);
    this.b = new WeakReference(paramActivity);
    this.i = paramActivity.getApplicationContext();
  }
  
  private Activity a()
  {
    if (this.b == null) {
      return null;
    }
    ApiClient localApiClient = (ApiClient)this.a.get();
    if (localApiClient == null) {
      return null;
    }
    return Util.getActiveActivity((Activity)this.b.get(), localApiClient.getContext());
  }
  
  private PendingResult<ResolveResult<CoreBaseResponse>> a(ApiClient paramApiClient, String paramString, CoreBaseRequest paramCoreBaseRequest)
  {
    return new a(paramApiClient, paramString, paramCoreBaseRequest);
  }
  
  private String a(int paramInt)
  {
    this.k.setTransactionId(this.j.getTransactionId());
    this.k.setAppID(this.j.getAppID());
    this.k.setApiName(this.j.getApiName());
    this.k.setSrvName(this.j.getSrvName());
    this.k.setPkgName(this.j.getPkgName());
    this.k.setStatusCode(1);
    this.k.setErrorCode(paramInt);
    this.k.setErrorReason("Core error");
    return this.k.toJson();
  }
  
  private void a(Activity paramActivity, Parcelable paramParcelable)
  {
    HMSLog.i("BaseAdapter", "startResolution");
    if (this.j != null) {
      b(this.i, this.j);
    }
    com.huawei.hms.adapter.a.a.b().a(this.l);
    Intent localIntent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.adapter.b.a.class.getName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("resolution", paramParcelable);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("transaction_id", this.h);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(Context paramContext, RequestHeader paramRequestHeader)
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", localMap);
  }
  
  private void a(Context paramContext, ResponseHeader paramResponseHeader)
  {
    HiAnalyticsUtil.getInstance();
    paramResponseHeader = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    paramResponseHeader.put("direction", "rsp");
    paramResponseHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", paramResponseHeader);
  }
  
  private void a(Context paramContext, ResponseHeader paramResponseHeader, long paramLong)
  {
    HiAnalyticsUtil.getInstance();
    paramResponseHeader = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    paramResponseHeader.put("direction", "rsp");
    paramResponseHeader.put("waitTime", String.valueOf(paramLong));
    paramResponseHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", paramResponseHeader);
  }
  
  private void a(Parcelable paramParcelable)
  {
    this.f = paramParcelable;
  }
  
  private void a(BaseCallBack paramBaseCallBack)
  {
    this.g = paramBaseCallBack;
  }
  
  private void a(String paramString)
  {
    this.d = paramString;
  }
  
  private void a(String paramString1, String paramString2, Parcelable paramParcelable, BaseCallBack paramBaseCallBack)
  {
    a(paramString1);
    b(paramString2);
    a(paramParcelable);
    a(paramBaseCallBack);
  }
  
  private BaseCallBack b()
  {
    if (this.c == null)
    {
      HMSLog.e("BaseAdapter", "callback null");
      return null;
    }
    return this.c;
  }
  
  private void b(Context paramContext, RequestHeader paramRequestHeader)
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", localMap);
  }
  
  private void b(String paramString)
  {
    this.e = paramString;
  }
  
  private String c()
  {
    return this.d;
  }
  
  private String d()
  {
    return this.e;
  }
  
  private Parcelable e()
  {
    return this.f;
  }
  
  private BaseCallBack f()
  {
    return this.g;
  }
  
  private void g()
  {
    this.k = null;
    this.k = new ResponseHeader();
    baseRequest(c(), d(), e(), f());
    h();
  }
  
  private void h()
  {
    a(null);
    b(null);
    a(null);
    a(null);
  }
  
  public void baseRequest(String paramString1, String paramString2, Parcelable paramParcelable, BaseCallBack paramBaseCallBack)
  {
    a(paramString1, paramString2, paramParcelable, paramBaseCallBack);
    if (this.a == null)
    {
      HMSLog.e("BaseAdapter", "client is null");
      h();
      paramBaseCallBack.onError(a(-2));
      return;
    }
    ApiClient localApiClient = (ApiClient)this.a.get();
    this.c = paramBaseCallBack;
    JsonUtil.jsonToEntity(paramString1, this.j);
    CoreBaseRequest localCoreBaseRequest = new CoreBaseRequest();
    localCoreBaseRequest.setJsonObject(paramString2);
    localCoreBaseRequest.setJsonHeader(paramString1);
    localCoreBaseRequest.setParcelable(paramParcelable);
    paramString1 = this.j.getApiName();
    if (TextUtils.isEmpty(paramString1))
    {
      HMSLog.e("BaseAdapter", "get uri null");
      h();
      paramBaseCallBack.onError(a(-5));
      return;
    }
    this.h = this.j.getTransactionId();
    if (TextUtils.isEmpty(this.h))
    {
      HMSLog.e("BaseAdapter", "get transactionId null");
      h();
      paramBaseCallBack.onError(a(-6));
      return;
    }
    HMSLog.i("BaseAdapter", "in baseRequest + uri is :" + paramString1 + ", transactionId is : " + this.h);
    a(this.i, this.j);
    a(localApiClient, paramString1, localCoreBaseRequest).setResultCallback(new BaseRequestResultCallback());
  }
  
  public static abstract interface BaseCallBack
  {
    public abstract void onComplete(String paramString1, String paramString2, Parcelable paramParcelable);
    
    public abstract void onError(String paramString);
  }
  
  public class BaseRequestResultCallback
    implements ResultCallback<ResolveResult<CoreBaseResponse>>
  {
    public BaseRequestResultCallback() {}
    
    private void a(BaseAdapter.BaseCallBack paramBaseCallBack, CoreBaseResponse paramCoreBaseResponse)
    {
      HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
      Object localObject = paramCoreBaseResponse.getPendingIntent();
      if (localObject != null)
      {
        BaseAdapter.b(BaseAdapter.this);
        paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), (Parcelable)localObject);
        return;
      }
      localObject = paramCoreBaseResponse.getIntent();
      if (localObject != null)
      {
        BaseAdapter.b(BaseAdapter.this);
        paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), (Parcelable)localObject);
        return;
      }
      BaseAdapter.b(BaseAdapter.this);
      paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), null);
    }
    
    public void onResult(ResolveResult<CoreBaseResponse> paramResolveResult)
    {
      BaseAdapter.BaseCallBack localBaseCallBack = BaseAdapter.a(BaseAdapter.this);
      if (localBaseCallBack == null)
      {
        HMSLog.e("BaseAdapter", "onResult baseCallBack null");
        BaseAdapter.b(BaseAdapter.this);
        return;
      }
      if (paramResolveResult == null)
      {
        HMSLog.e("BaseAdapter", "result null");
        localBaseCallBack.onError(BaseAdapter.a(BaseAdapter.this, -1));
        BaseAdapter.b(BaseAdapter.this);
        return;
      }
      Object localObject = (CoreBaseResponse)paramResolveResult.getValue();
      if (localObject == null)
      {
        HMSLog.e("BaseAdapter", "response null");
        BaseAdapter.b(BaseAdapter.this);
        localBaseCallBack.onError(BaseAdapter.a(BaseAdapter.this, -1));
        return;
      }
      if (TextUtils.isEmpty(((CoreBaseResponse)localObject).getJsonHeader()))
      {
        HMSLog.e("BaseAdapter", "jsonHeader null");
        BaseAdapter.b(BaseAdapter.this);
        localBaseCallBack.onError(BaseAdapter.a(BaseAdapter.this, -1));
        return;
      }
      JsonUtil.jsonToEntity(((CoreBaseResponse)localObject).getJsonHeader(), BaseAdapter.c(BaseAdapter.this));
      BaseAdapter.a(BaseAdapter.this, BaseAdapter.d(BaseAdapter.this), BaseAdapter.c(BaseAdapter.this));
      if ("intent".equals(BaseAdapter.c(BaseAdapter.this).getResolution()))
      {
        paramResolveResult = BaseAdapter.e(BaseAdapter.this);
        if ((paramResolveResult == null) || (paramResolveResult.isFinishing()))
        {
          HMSLog.e("BaseAdapter", "activity null");
          a(localBaseCallBack, (CoreBaseResponse)localObject);
          return;
        }
        PendingIntent localPendingIntent = ((CoreBaseResponse)localObject).getPendingIntent();
        if (localPendingIntent != null)
        {
          BaseAdapter.a(BaseAdapter.this, paramResolveResult, localPendingIntent);
          return;
        }
        localObject = ((CoreBaseResponse)localObject).getIntent();
        if (localObject != null)
        {
          BaseAdapter.a(BaseAdapter.this, paramResolveResult, (Parcelable)localObject);
          return;
        }
        HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
        BaseAdapter.b(BaseAdapter.this);
        localBaseCallBack.onError(BaseAdapter.a(BaseAdapter.this, -4));
        return;
      }
      a(localBaseCallBack, (CoreBaseResponse)localObject);
    }
  }
  
  static class a
    extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse>
  {
    public a(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public ResolveResult<CoreBaseResponse> a(CoreBaseResponse paramCoreBaseResponse)
    {
      paramCoreBaseResponse = new ResolveResult(paramCoreBaseResponse);
      paramCoreBaseResponse.setStatus(Status.SUCCESS);
      return paramCoreBaseResponse;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */