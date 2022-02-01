package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class InternalJSPlugin$6
  implements Runnable
{
  InternalJSPlugin$6(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, PackageManager paramPackageManager, String paramString3, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    DialogUtil.createCustomDialog(this.val$activity, 230, null, String.format("即将离开QQ，打开「%s」", new Object[] { this.val$appName }), "取消", "允许", new InternalJSPlugin.6.1(this), new InternalJSPlugin.6.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.6
 * JD-Core Version:    0.7.0.1
 */