package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import astt;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class ChannelProxyImpl$13
  implements Runnable
{
  public ChannelProxyImpl$13(astt paramastt, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.val$activity == null) || (this.val$activity.isFinishing())) {
      QMLog.i("ChannelProxyImpl", "activity is null or finishing");
    }
    Bundle localBundle;
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(this.val$appId)) && (!TextUtils.isEmpty(this.bKn))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ChannelProxyImpl", 2, "syncForceGroundAndRefreshBadge--miniConfig error");
      return;
      localBundle = new Bundle();
      localBundle.putString("miniAppID", this.val$appId);
      localBundle.putString("param_proc_name", this.bKn);
      localBundle.putString("param_proc_modulename", "mini_sdk_client_module");
      if ((this.val$activity instanceof AppBrandUI))
      {
        if (QMLog.isColorLevel()) {
          QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
        }
        ((AppBrandUI)this.val$activity).onProcessForeGround(localBundle);
        if (QMLog.isColorLevel()) {
          QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
        }
        ((AppBrandUI)this.val$activity).onRefreshMiniBadge(localBundle);
        return;
      }
    } while (!(this.val$activity instanceof GameActivity1));
    if (QMLog.isColorLevel()) {
      QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
    }
    ((GameActivity1)this.val$activity).onProcessForeGround(localBundle);
    if (QMLog.isColorLevel()) {
      QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
    }
    ((GameActivity1)this.val$activity).onRefreshMiniBadge(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.13
 * JD-Core Version:    0.7.0.1
 */