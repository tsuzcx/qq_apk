package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class ReadVirtualAdsMailFragment$3
  implements View.OnClickListener
{
  ReadVirtualAdsMailFragment$3(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_AD_Mail_Forward");
    ReadVirtualAdsMailFragment.access$400(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.3
 * JD-Core Version:    0.7.0.1
 */