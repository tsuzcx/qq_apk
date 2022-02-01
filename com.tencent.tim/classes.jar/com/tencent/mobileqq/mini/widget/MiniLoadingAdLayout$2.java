package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniLoadingAdLayout$2
  implements View.OnClickListener
{
  MiniLoadingAdLayout$2(MiniLoadingAdLayout paramMiniLoadingAdLayout, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.val$isGame) {
      if ((this.this$0.getContext() instanceof GameActivity)) {
        ((GameActivity)this.this$0.getContext()).doOnBackPressed();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.g().getCurrentAppBrandRuntime();
      if (localAppBrandRuntime != null) {
        localAppBrandRuntime.moveAppBrandToBack();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.2
 * JD-Core Version:    0.7.0.1
 */