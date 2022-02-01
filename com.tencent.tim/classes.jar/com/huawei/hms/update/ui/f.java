package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class f
  extends a
{
  private boolean d()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    while (TextUtils.isEmpty(this.g)) {
      return false;
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.g));
      localIntent.setPackage("com.android.vending");
      localActivity.startActivityForResult(localIntent, getRequestCode());
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      HMSLog.e("GooglePlayWizard", "can not open google play");
    }
    return false;
  }
  
  void a()
  {
    b(13, this.f);
  }
  
  public void a(b paramb)
  {
    HMSLog.i("GooglePlayWizard", "Enter onCancel.");
    if ((paramb instanceof i)) {
      a();
    }
  }
  
  void a(Class<? extends b> paramClass)
  {
    c();
    try
    {
      paramClass = (b)paramClass.newInstance();
      if ((!TextUtils.isEmpty(this.h)) && ((paramClass instanceof i)))
      {
        this.h = ResourceLoaderUtil.getString("hms_update_title");
        ((i)paramClass).a(this.h);
      }
      paramClass.a(this);
      this.d = paramClass;
      return;
    }
    catch (InstantiationException paramClass)
    {
      HMSLog.e("GooglePlayWizard", "In showDialog, Failed to show the dialog." + paramClass.getMessage());
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      break label61;
    }
    catch (IllegalStateException paramClass)
    {
      label61:
      break label61;
    }
  }
  
  public void b(b paramb)
  {
    HMSLog.i("GooglePlayWizard", "Enter onDoWork.");
    if ((paramb instanceof i))
    {
      paramb.c();
      if (!d())
      {
        if (a(false)) {
          break label44;
        }
        b(8, this.f);
      }
    }
    return;
    label44:
    a(8, this.f);
  }
  
  public int getRequestCode()
  {
    return 2002;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {}
    do
    {
      return;
      this.f = 2;
      if ((this.c.isNeedConfirm()) && (!TextUtils.isEmpty(this.h)))
      {
        a(i.class);
        return;
      }
    } while (d());
    if (!a(false))
    {
      b(8, this.f);
      return;
    }
    a(8, this.f);
  }
  
  public void onBridgeActivityDestroy()
  {
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.e) && (this.b != null)) {
      bool1 = this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.f != 2);
      bool1 = bool2;
    } while (paramInt1 != getRequestCode());
    if (a(this.g, this.i)) {
      b(0, this.f);
    }
    for (;;)
    {
      return true;
      b(8, this.f);
    }
  }
  
  public void onBridgeConfigurationChanged()
  {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.e) && (this.b != null)) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
    }
    do
    {
      do
      {
        return;
      } while (4 != paramInt);
      HMSLog.i("GooglePlayWizard", "In onKeyUp, Call finish.");
      paramKeyEvent = b();
    } while ((paramKeyEvent == null) || (paramKeyEvent.isFinishing()));
    paramKeyEvent.setResult(0, null);
    paramKeyEvent.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.f
 * JD-Core Version:    0.7.0.1
 */