package com.app.hubert.guide.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.app.hubert.guide.model.GuidePage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuideLayout$1
  implements View.OnClickListener
{
  GuideLayout$1(GuideLayout paramGuideLayout) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.guidePage.isEverywhereCancelable()) {
      this.this$0.remove();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.core.GuideLayout.1
 * JD-Core Version:    0.7.0.1
 */