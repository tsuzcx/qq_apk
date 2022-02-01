package com.huawei.hms.adapter.b;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class a
  implements IBridgeActivityDelegate
{
  private WeakReference<Activity> a;
  private String b = "";
  
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
  
  private void c()
  {
    com.huawei.hms.adapter.a.a.a().a(null, this.b);
    a();
  }
  
  public int getRequestCode()
  {
    return 1001;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
    Object localObject = paramActivity.getIntent();
    if (localObject == null) {
      c();
    }
    do
    {
      return;
      Bundle localBundle;
      try
      {
        ((Intent)localObject).getStringExtra("TestIntentProtocol");
        localBundle = ((Intent)localObject).getExtras();
        this.b = ((Intent)localObject).getStringExtra("transaction_id");
        if (localBundle == null)
        {
          c();
          return;
        }
      }
      catch (Exception paramActivity)
      {
        HMSLog.e("BaseResolutionAdapter", "intent has some error" + paramActivity.getMessage());
        c();
        return;
      }
      localObject = localBundle.getParcelable("resolution");
      if (localObject == null)
      {
        c();
        return;
      }
      if ((localObject instanceof Intent))
      {
        paramActivity.startActivityForResult((Intent)localObject, 1001);
        return;
      }
    } while (!(localObject instanceof PendingIntent));
    try
    {
      paramActivity.startIntentSenderForResult(((PendingIntent)localObject).getIntentSender(), 1001, null, 0, 0, 0);
      return;
    }
    catch (IntentSender.SendIntentException paramActivity)
    {
      c();
      HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
    }
  }
  
  public void onBridgeActivityDestroy()
  {
    HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != getRequestCode()) {
      return false;
    }
    HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult");
    if (paramInt2 == -1) {
      com.huawei.hms.adapter.a.a.a().a(paramIntent, this.b);
    }
    for (;;)
    {
      a();
      return true;
      com.huawei.hms.adapter.a.a.a().a(null, this.b);
    }
  }
  
  public void onBridgeConfigurationChanged()
  {
    HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.adapter.b.a
 * JD-Core Version:    0.7.0.1
 */