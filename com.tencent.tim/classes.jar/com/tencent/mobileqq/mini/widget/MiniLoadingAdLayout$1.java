package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class MiniLoadingAdLayout$1
  implements View.OnClickListener
{
  MiniLoadingAdLayout$1(MiniLoadingAdLayout paramMiniLoadingAdLayout, GdtAd paramGdtAd) {}
  
  public void onClick(View paramView)
  {
    QLog.i("MiniLoadingAdLayout", 1, "yuki LoadingAd reportClick");
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 11;
    localParams.activity = new WeakReference((Activity)this.this$0.getContext());
    localParams.ad = this.val$adInfo;
    localParams.reportForClick = true;
    localParams.aOV = MiniLoadingAdLayout.access$000(this.this$0);
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_ref_source_key", "biz_src_miniappD");
    localParams.extra = localBundle;
    GdtHandler.a(localParams);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.1
 * JD-Core Version:    0.7.0.1
 */