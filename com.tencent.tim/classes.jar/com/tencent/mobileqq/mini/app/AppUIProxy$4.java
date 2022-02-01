package com.tencent.mobileqq.mini.app;

import android.app.Fragment;
import android.view.ViewGroup;
import android.view.Window;
import aroi;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;

class AppUIProxy$4
  implements Runnable
{
  AppUIProxy$4(AppUIProxy paramAppUIProxy, BaseActivity paramBaseActivity, MiniAppConfig paramMiniAppConfig, String paramString, GdtAd paramGdtAd) {}
  
  public void run()
  {
    DisplayUtil.setSystemUIVisible(this.val$activity, false);
    MiniLoadingAdLayout localMiniLoadingAdLayout = MiniLoadingAdManager.getInstance().getLoadingAdLayout(this.val$miniAppConfig, this.this$0.getAppBrandFragment().getActivity(), false, this.val$filePath, this.val$adInfo);
    ((ViewGroup)this.val$activity.getWindow().getDecorView()).addView(localMiniLoadingAdLayout);
    MiniLoadingAdManager.getInstance().show(localMiniLoadingAdLayout, this.val$miniAppConfig.config.appId, String.valueOf(aroi.a().getUin()), new AppUIProxy.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.4
 * JD-Core Version:    0.7.0.1
 */