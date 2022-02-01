package com.huawei.hms.adapter.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.a.a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.lang.ref.WeakReference;

public class b
  implements IBridgeActivityDelegate
{
  private WeakReference<Activity> a;
  private int b;
  private UpdateBean c;
  
  private void a()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    localActivity.finish();
  }
  
  private boolean a(Context paramContext, String paramString, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramInt == 0)) {
      bool1 = false;
    }
    do
    {
      PackageManagerHelper.PackageStates localPackageStates;
      do
      {
        return bool1;
        paramContext = new PackageManagerHelper(paramContext);
        localPackageStates = paramContext.getPackageStates(paramString);
        bool1 = bool2;
      } while (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localPackageStates));
      bool1 = bool2;
    } while (paramContext.getPackageVersionCode(paramString) < paramInt);
    return false;
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
    a.a().a(8);
    a();
  }
  
  public int getRequestCode()
  {
    return 1001;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 == null)
    {
      c();
      return;
    }
    try
    {
      ((Intent)localObject1).getStringExtra("TestIntentProtocol");
      this.b = ((Intent)localObject1).getIntExtra("update_version", 0);
      if (this.b == 0)
      {
        c();
        return;
      }
    }
    catch (Exception paramActivity)
    {
      HMSLog.e("UpdateAdapter", "intent has some error" + paramActivity.getMessage());
      c();
      return;
    }
    Object localObject2 = new UpdateBean();
    ((UpdateBean)localObject2).setHmsOrApkUpgrade(true);
    ((UpdateBean)localObject2).setClientPackageName(com.huawei.hms.utils.b.a(paramActivity.getApplicationContext()).b());
    ((UpdateBean)localObject2).setClientVersionCode(this.b);
    ((UpdateBean)localObject2).setClientAppId("C10132067");
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    ((UpdateBean)localObject2).setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    this.c = ((UpdateBean)localObject2);
    if (((Intent)localObject1).getBooleanExtra("new_update", false))
    {
      HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
      localObject1 = com.huawei.hms.utils.b.a(paramActivity.getApplicationContext()).b();
      localObject2 = new ComponentName((String)localObject1, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
      Intent localIntent = new Intent();
      localIntent.putExtra("kpms_key_caller_packagename", paramActivity.getApplicationContext().getPackageName());
      localIntent.putExtra("kitUpdatePackageName", (String)localObject1);
      localIntent.setComponent((ComponentName)localObject2);
      paramActivity.startActivityForResult(localIntent, 1001);
      return;
    }
    HMSLog.i("UpdateAdapter", "old framework HMSCore upgrade process");
    UpdateManager.startUpdate(paramActivity, 1001, (UpdateBean)localObject2);
    this.c = null;
  }
  
  public void onBridgeActivityDestroy()
  {
    HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != getRequestCode())
    {
      this.c = null;
      return false;
    }
    HMSLog.i("UpdateAdapter", "onBridgeActivityResult");
    if (paramInt2 == 1214)
    {
      HMSLog.i("UpdateAdapter", "Enter update escape route");
      Activity localActivity = b();
      if (localActivity == null)
      {
        HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
        this.c = null;
        return true;
      }
      UpdateManager.startUpdate(localActivity, 1001, this.c);
      this.c = null;
    }
    if (paramInt2 == -1) {
      if (paramIntent != null)
      {
        if (paramIntent.getIntExtra("kit_update_result", 0) == 1)
        {
          HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
          a.a().a(0);
          this.c = null;
          a();
          return true;
        }
        paramInt1 = paramIntent.getIntExtra("intent.extra.RESULT", -1);
        if (paramInt1 != 0) {
          break label155;
        }
        HMSLog.i("UpdateAdapter", "Error resolved successfully!");
        a.a().a(0);
      }
    }
    for (;;)
    {
      a();
      return true;
      label155:
      if (paramInt1 == 13)
      {
        HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
        a.a().a(13);
      }
      else if (paramInt1 == 8)
      {
        HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
        a.a().a(8);
      }
      else
      {
        HMSLog.i("UpdateAdapter", "Other error codes.");
        a.a().a(paramInt1);
        continue;
        if (paramInt2 == 0)
        {
          HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
          this.c = null;
          paramIntent = b();
          if (paramIntent == null) {
            return true;
          }
          if (a(paramIntent, com.huawei.hms.utils.b.a(paramIntent.getApplicationContext()).b(), this.b))
          {
            HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
            a.a().a(13);
          }
          else
          {
            a.a().a(0);
          }
        }
      }
    }
  }
  
  public void onBridgeConfigurationChanged()
  {
    HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.adapter.b.b
 * JD-Core Version:    0.7.0.1
 */