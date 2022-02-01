package com.tencent.qqmail.maillist.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.inquirymail.InquiryMailFragmentActivity;
import com.tencent.qqmail.protocol.DataCollector;

class MailListFragment$24
  implements View.OnClickListener
{
  MailListFragment$24(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Received_Mail_Tips_Click");
    Intent localIntent = InquiryMailFragmentActivity.createIntentToMailList(MailListFragment.access$2200(this.this$0));
    this.this$0.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.24
 * JD-Core Version:    0.7.0.1
 */