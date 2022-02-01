package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.a;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class ResolutionDelegate
  implements IBridgeActivityDelegate
{
  public static final String CALLBACK_METHOD = "CALLBACK_METHOD";
  private WeakReference<Activity> a;
  private final String b = "ResolutionDelegate";
  
  private BusResponseCallback a(String paramString)
  {
    return a.a().b(paramString);
  }
  
  private void a()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    localActivity.finish();
  }
  
  private Activity b()
  {
    if (this.a == null) {
      return null;
    }
    return (Activity)this.a.get();
  }
  
  public int getRequestCode()
  {
    return 1002;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
    paramActivity.startActivityForResult((Intent)paramActivity.getIntent().getExtras().getParcelable("resolution"), 1002);
  }
  
  public void onBridgeActivityDestroy()
  {
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != getRequestCode()) {
      return false;
    }
    paramIntent = a("CALLBACK_METHOD");
    Activity localActivity = (Activity)this.a.get();
    paramInt1 = new AvailableAdapter(30000000).isHuaweiMobileServicesAvailable(localActivity);
    if ((paramInt2 == -1) && (paramInt1 == 0)) {
      HMSLog.i("ResolutionDelegate", "Make service available success.");
    }
    for (;;)
    {
      a();
      return true;
      paramIntent.innerError((Activity)this.a.get(), paramInt2, "Make service available failed.");
    }
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.api.ResolutionDelegate
 * JD-Core Version:    0.7.0.1
 */