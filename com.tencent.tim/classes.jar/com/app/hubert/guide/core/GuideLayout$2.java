package com.app.hubert.guide.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuideLayout$2
  implements View.OnClickListener
{
  GuideLayout$2(GuideLayout paramGuideLayout) {}
  
  public void onClick(View paramView)
  {
    this.this$0.remove();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.core.GuideLayout.2
 * JD-Core Version:    0.7.0.1
 */