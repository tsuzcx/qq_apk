package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class AppBrandFragment$5
  implements Runnable
{
  AppBrandFragment$5(AppBrandFragment paramAppBrandFragment, Activity paramActivity) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_app_client_module");
    if ((this.val$activity != null) && ((this.val$activity instanceof AppBrandUI)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandFragment", 1, "onStop--onProcessBackground");
      }
      ((AppBrandUI)this.val$activity).onProcessBackground(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment.5
 * JD-Core Version:    0.7.0.1
 */