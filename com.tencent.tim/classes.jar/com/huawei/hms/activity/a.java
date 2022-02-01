package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  implements IBridgeActivityDelegate
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  private RequestHeader b;
  private String c;
  private com.huawei.hms.activity.internal.b d;
  private ResponseHeader e;
  private WeakReference<Activity> f;
  
  private BusResponseCallback a(String paramString)
  {
    return com.huawei.hms.activity.internal.a.a().b(paramString);
  }
  
  private void a()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    localActivity.finish();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    HMSLog.i("ForegroundBusDelegate", "succeedReturn");
    Activity localActivity = b();
    if (localActivity == null) {
      return;
    }
    localActivity.setResult(paramInt, paramIntent);
    a();
  }
  
  private void a(int paramInt, String paramString)
  {
    HMSLog.e("ForegroundBusDelegate", paramString);
    Activity localActivity = b();
    if (localActivity == null) {
      return;
    }
    BusResponseCallback localBusResponseCallback = a(this.d.c());
    if (localBusResponseCallback != null)
    {
      paramString = localBusResponseCallback.innerError((Activity)this.f.get(), paramInt, paramString);
      if (paramString == null) {
        localActivity.setResult(0);
      }
    }
    for (;;)
    {
      a();
      return;
      localActivity.setResult(paramString.getCode(), paramString.getIntent());
      continue;
      localActivity.setResult(0);
    }
  }
  
  private static void a(Activity paramActivity, AvailableAdapter paramAvailableAdapter, AvailableAdapter.AvailableCallBack paramAvailableCallBack)
  {
    if (paramActivity == null) {
      HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
    }
    paramAvailableAdapter.startResolution(paramActivity, paramAvailableCallBack);
  }
  
  private Activity b()
  {
    if (this.f == null) {
      return null;
    }
    return (Activity)this.f.get();
  }
  
  private void c()
  {
    a locala = new a(null);
    AvailableAdapter localAvailableAdapter = new AvailableAdapter(this.d.a());
    int i = localAvailableAdapter.isHuaweiMobileServicesAvailable(b());
    if (i == 0)
    {
      locala.onComplete(i);
      return;
    }
    if (localAvailableAdapter.isUserResolvableError(i))
    {
      a(b(), localAvailableAdapter, locala);
      return;
    }
    locala.onComplete(i);
  }
  
  private void d()
  {
    HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
    Activity localActivity = b();
    if (localActivity == null)
    {
      HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
      return;
    }
    String str = com.huawei.hms.utils.b.a(localActivity.getApplicationContext()).b();
    Intent localIntent = new Intent(this.d.b());
    localIntent.putExtra("HMS_FOREGROUND_REQ_BODY", this.c);
    localIntent.setPackage(str);
    localIntent.setClassName(str, "com.huawei.hms.core.activity.UiJumpActivity");
    localIntent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.b.toJson());
    localIntent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
    a.set(true);
    try
    {
      f();
      localActivity.startActivityForResult(localIntent, 431057);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      a.set(false);
      HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", localActivityNotFoundException);
      a(0, "launch bus intent failed");
    }
  }
  
  private void e()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.b);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.b.getKitSdkVersion())));
    if (b() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", localMap);
    }
  }
  
  private void f()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.b);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.b.getKitSdkVersion())));
    if (b() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", localMap);
    }
  }
  
  private void g()
  {
    if (this.b != null)
    {
      Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.b);
      localMap.put("direction", "rsp");
      localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.b.getKitSdkVersion())));
      if (this.e != null)
      {
        localMap.put("statusCode", String.valueOf(this.e.getStatusCode()));
        localMap.put("result", String.valueOf(this.e.getErrorCode()));
      }
      if (b() != null) {
        HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", localMap);
      }
    }
  }
  
  private void h()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.b);
    localMap.put("direction", "rsp");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.b.getKitSdkVersion())));
    if (this.e != null)
    {
      localMap.put("statusCode", String.valueOf(this.e.getStatusCode()));
      localMap.put("result", String.valueOf(this.e.getErrorCode()));
    }
    if (b() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", localMap);
    }
  }
  
  public int getRequestCode()
  {
    return 431057;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.f = new WeakReference(paramActivity);
    paramActivity = paramActivity.getIntent();
    String str = paramActivity.getStringExtra("HMS_FOREGROUND_REQ_HEADER");
    this.b = new RequestHeader();
    if (!this.b.fromJson(str))
    {
      a(0, "header is invalid");
      return;
    }
    this.c = paramActivity.getStringExtra("HMS_FOREGROUND_REQ_BODY");
    this.d = ((com.huawei.hms.activity.internal.b)paramActivity.getSerializableExtra("HMS_FOREGROUND_REQ_INNER"));
    if (this.d == null)
    {
      a(0, "inner header is invalid");
      return;
    }
    if (TextUtils.isEmpty(this.b.getApiName()))
    {
      a(0, "action is invalid");
      return;
    }
    e();
    if (a.get())
    {
      a(0, "last request is processing");
      return;
    }
    c();
  }
  
  public void onBridgeActivityDestroy()
  {
    g();
    this.f = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    Object localObject;
    if (paramInt1 == 431057)
    {
      a.set(false);
      if ((paramIntent != null) && (paramIntent.hasExtra("HMS_FOREGROUND_RESP_HEADER")))
      {
        localObject = paramIntent.getStringExtra("HMS_FOREGROUND_RESP_HEADER");
        this.e = new ResponseHeader();
        JsonUtil.jsonToEntity((String)localObject, this.e);
      }
      h();
      localObject = a(this.d.c());
      if (localObject != null) {
        break label94;
      }
      a(paramInt2, paramIntent);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label94:
      localObject = ((BusResponseCallback)localObject).succeedReturn((Activity)this.f.get(), paramInt2, paramIntent);
      if (localObject == null) {
        a(paramInt2, paramIntent);
      } else {
        a(((BusResponseResult)localObject).getCode(), ((BusResponseResult)localObject).getIntent());
      }
    }
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
  
  class a
    implements AvailableAdapter.AvailableCallBack
  {
    private a() {}
    
    public void onComplete(int paramInt)
    {
      if (paramInt == 0)
      {
        a.a(a.this);
        return;
      }
      HMSLog.i("ForegroundBusDelegate", "version check failed");
      a.a(a.this, 0, "apk version is invalid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.activity.a
 * JD-Core Version:    0.7.0.1
 */