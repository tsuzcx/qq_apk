package com.tencent.mobileqq.mini.app;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.OnChooseAdEndListener;

class AppUIProxy$3
  implements MiniLoadingAdManager.OnChooseAdEndListener
{
  AppUIProxy$3(AppUIProxy paramAppUIProxy, BaseActivity paramBaseActivity, MiniAppConfig paramMiniAppConfig) {}
  
  public void onChooseAdEnd(String paramString, GdtAd paramGdtAd)
  {
    if (!AppUIProxy.access$000(this.this$0)) {
      AppUIProxy.access$100(this.this$0, this.val$activity, this.val$miniAppConfig, paramString, paramGdtAd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.3
 * JD-Core Version:    0.7.0.1
 */