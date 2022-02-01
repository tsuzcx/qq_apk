package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class ReadVirtualAdsMailFragment$4
  implements View.OnClickListener
{
  ReadVirtualAdsMailFragment$4(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_AD_Mail_Delete");
    this.this$0.deleteMail();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.4
 * JD-Core Version:    0.7.0.1
 */