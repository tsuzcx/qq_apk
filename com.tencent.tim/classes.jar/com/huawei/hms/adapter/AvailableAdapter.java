package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.a.a;
import com.huawei.hms.adapter.a.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;
import java.util.concurrent.atomic.AtomicBoolean;

public class AvailableAdapter
{
  private static AtomicBoolean c = new AtomicBoolean(false);
  private static int d = 0;
  private final int a;
  private AvailableCallBack b;
  private c e = new AvailableAdapter.1(this);
  
  public AvailableAdapter(int paramInt)
  {
    this.a = paramInt;
  }
  
  private AvailableCallBack c()
  {
    return this.b;
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    if (Build.VERSION.SDK_INT < 16)
    {
      HMSLog.i("AvailableAdapter", "HMS can not be supported under android 4.1");
      return 21;
    }
    PackageManagerHelper localPackageManagerHelper = new PackageManagerHelper(paramContext);
    paramContext = com.huawei.hms.utils.b.a(paramContext);
    PackageManagerHelper.PackageStates localPackageStates = paramContext.a();
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localPackageStates))
    {
      HMSLog.i("AvailableAdapter", "HMS is not installed");
      return 1;
    }
    if (PackageManagerHelper.PackageStates.DISABLED.equals(localPackageStates))
    {
      HMSLog.i("AvailableAdapter", "HMS is disabled");
      return 3;
    }
    int i = localPackageManagerHelper.getPackageVersionCode(paramContext.b());
    HMSLog.i("AvailableAdapter", "current versionCode:" + i + ",minimum version requirements: " + this.a);
    if (i < this.a)
    {
      HMSLog.i("AvailableAdapter", "The current version dose not meet the minimum version requirements");
      return 2;
    }
    return 0;
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void startResolution(Activity paramActivity, AvailableCallBack paramAvailableCallBack)
  {
    int i = 0;
    if (com.huawei.hms.utils.b.a(paramActivity).c() >= 40000000) {
      HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
    }
    for (boolean bool = true;; bool = false)
    {
      if (c.compareAndSet(false, true))
      {
        HMSLog.i("AvailableAdapter", "Start to resolution for the 1st time.");
        HMSLog.i("AvailableAdapter", "startResolution");
        if ((paramActivity != null) && (paramAvailableCallBack != null)) {}
      }
      else
      {
        label151:
        do
        {
          return;
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            HMSLog.i("AvailableAdapter", "main thread invokes resolution.");
            break;
          }
          HMSLog.i("AvailableAdapter", "Another thread start to resolution.");
          for (;;)
          {
            if (!c.get()) {
              break label151;
            }
            if (i >= 300)
            {
              HMSLog.i("AvailableAdapter", "Previous popup is not handled by user or download has not finished within 1min.");
              if (paramAvailableCallBack == null) {
                break;
              }
              paramAvailableCallBack.onComplete(27);
              return;
            }
            try
            {
              HMSLog.d("AvailableAdapter", "Concurrent startResolution thread is waiting.");
              Thread.sleep(200L);
              i += 1;
            }
            catch (InterruptedException paramActivity)
            {
              HMSLog.d("AvailableAdapter", "Concurrent startResolution thread waiting is interrupted.");
            }
          }
          HMSLog.i("AvailableAdapter", "Concurrent startResolution thread waiting finished.");
        } while (paramAvailableCallBack == null);
        paramAvailableCallBack.onComplete(d);
        return;
      }
      this.b = paramAvailableCallBack;
      a.b().a(this.e);
      paramAvailableCallBack = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.adapter.b.b.class.getName());
      paramAvailableCallBack.putExtra("update_version", this.a);
      paramAvailableCallBack.putExtra("new_update", bool);
      paramActivity.startActivity(paramAvailableCallBack);
      return;
    }
  }
  
  public static abstract interface AvailableCallBack
  {
    public abstract void onComplete(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.adapter.AvailableAdapter
 * JD-Core Version:    0.7.0.1
 */