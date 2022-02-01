package com.huawei.updatesdk.service.otaupdate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.huawei.updatesdk.service.f.a;

class AppUpdateActivity$8
  implements DialogInterface.OnKeyListener
{
  AppUpdateActivity$8(AppUpdateActivity paramAppUpdateActivity, a parama) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (AppUpdateActivity.f(this.b))
      {
        this.a.c();
        AppUpdateActivity.a(this.b, AppUpdateActivity.g(this.b));
        return true;
      }
      AppUpdateActivity.b(this.b, 4);
      this.b.finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.8
 * JD-Core Version:    0.7.0.1
 */