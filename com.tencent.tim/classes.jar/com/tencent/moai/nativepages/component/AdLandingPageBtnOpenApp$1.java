package com.tencent.moai.nativepages.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.moai.nativepages.model.AdLandingPageComponentBtnInfo;
import com.tencent.moai.nativepages.util.AppInfoUtil;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdLandingPageBtnOpenApp$1
  implements View.OnClickListener
{
  AdLandingPageBtnOpenApp$1(AdLandingPageBtnOpenApp paramAdLandingPageBtnOpenApp, AdLandingPageComponentBtnInfo paramAdLandingPageComponentBtnInfo) {}
  
  public void onClick(View paramView)
  {
    this.this$0.addClickCount();
    AppInfoUtil.openApp(this.this$0.context, this.val$info.handleJumpedAppId);
    DataUtil.collect(this.this$0.getInfo().cId, "Event_Native_AD_Component_Button_Click", 1L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBtnOpenApp.1
 * JD-Core Version:    0.7.0.1
 */