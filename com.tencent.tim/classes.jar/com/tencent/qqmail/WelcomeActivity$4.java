package com.tencent.qqmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.protocol.DataCollector;

class WelcomeActivity$4
  implements View.OnClickListener
{
  WelcomeActivity$4(WelcomeActivity paramWelcomeActivity, PopularizeSubItem paramPopularizeSubItem) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logDetailEvent("DetailEvent_Splash_Popularize_Subitem_Click", 0L, 0L, this.val$subItem.getServerId() + "");
    DataCollector.logDetailEventWithDetailMessage("DetailEvent_Splash_Popularize_Subitem_Click", WelcomeActivity.access$500(this.this$0).getReportId() + "_" + this.val$subItem.getServerId(), 0L, 0L, this.val$subItem.getServerId() + "");
    WelcomeActivity.access$700(this.this$0, this.val$subItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.4
 * JD-Core Version:    0.7.0.1
 */