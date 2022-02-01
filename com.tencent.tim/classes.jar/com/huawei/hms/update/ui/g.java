package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class g
  extends a
{
  private boolean d()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    while ((this.c == null) || (TextUtils.isEmpty(this.j))) {
      return false;
    }
    try
    {
      ResourceLoaderUtil.setmContext(localActivity);
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(ResourceLoaderUtil.getString("hms_base_vmall") + this.j));
      localIntent.setFlags(268435456);
      localActivity.startActivityForResult(localIntent, getRequestCode());
      a(0, this.f);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      HMSLog.e("HiappWebWizard", "can not find web to hold update hms apk");
    }
    return false;
  }
  
  void a()
  {
    b(13, this.f);
  }
  
  public void a(b paramb)
  {
    HMSLog.d("HiappWebWizard", "Enter onCancel.");
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
      HMSLog.e("HiappWebWizard", "In showDialog, Failed to show the dialog." + paramClass.getMessage());
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
    HMSLog.d("HiappWebWizard", "Enter onDoWork.");
    if ((paramb instanceof i))
    {
      paramb.c();
      if (!d()) {
        b(8, this.f);
      }
    }
  }
  
  public int getRequestCode()
  {
    return 2004;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {}
    do
    {
      return;
      this.f = 4;
      if ((this.c.isNeedConfirm()) && (!TextUtils.isEmpty(this.h)))
      {
        a(i.class);
        return;
      }
    } while (d());
    b(8, this.f);
  }
  
  public void onBridgeActivityDestroy()
  {
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void onBridgeConfigurationChanged()
  {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
    {
      HMSLog.i("HiappWebWizard", "In onKeyUp, Call finish.");
      paramKeyEvent = b();
      if ((paramKeyEvent != null) && (!paramKeyEvent.isFinishing()))
      {
        paramKeyEvent.setResult(0, null);
        paramKeyEvent.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.g
 * JD-Core Version:    0.7.0.1
 */