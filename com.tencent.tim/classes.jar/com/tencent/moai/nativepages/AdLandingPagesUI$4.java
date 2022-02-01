package com.tencent.moai.nativepages;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdLandingPagesUI$4
  implements View.OnClickListener
{
  AdLandingPagesUI$4(AdLandingPagesUI paramAdLandingPagesUI) {}
  
  public void onClick(View paramView)
  {
    this.this$0.more();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.4
 * JD-Core Version:    0.7.0.1
 */