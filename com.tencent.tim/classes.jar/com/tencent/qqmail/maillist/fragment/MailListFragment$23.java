package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class MailListFragment$23
  implements View.OnClickListener
{
  MailListFragment$23(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (!MailListFragment.access$300(this.this$0)) {
      if (MailListFragment.access$2400(this.this$0) == -3) {
        this.this$0.gotoVipList();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (SendMailInterAppsManager.getInstance().hasFile()) {
        DataCollector.logEvent("Event_Local_File_Reply_But_Compose");
      }
      MailListFragment.access$7300(this.this$0).setVisibility(8);
      ((RelativeLayout.LayoutParams)MailListFragment.access$000(this.this$0).getLayoutParams()).setMargins(0, 0, 0, 0);
      MailListFragment.access$7400(this.this$0);
      continue;
      MailListFragment.access$5600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.23
 * JD-Core Version:    0.7.0.1
 */