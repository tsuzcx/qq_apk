package com.tencent.mobileqq.minigame.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class BlockAdView$SingleBlockAdView$1
  implements View.OnClickListener
{
  BlockAdView$SingleBlockAdView$1(BlockAdView.SingleBlockAdView paramSingleBlockAdView, GdtAd paramGdtAd) {}
  
  public void onClick(View paramView)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 11;
    localParams.activity = new WeakReference((Activity)BlockAdView.SingleBlockAdView.access$100(this.this$1));
    localParams.ad = this.val$gdtAd;
    localParams.reportForClick = true;
    localParams.aOV = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_ref_source_key", "biz_src_miniappD");
    localParams.extra = localBundle;
    GdtHandler.a(localParams);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.SingleBlockAdView.1
 * JD-Core Version:    0.7.0.1
 */