package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;

class ReadMailFragment$101
  implements View.OnClickListener
{
  ReadMailFragment$101(ReadMailFragment paramReadMailFragment, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    this.val$bar.setVisibility(8);
    ReadMailFragment.access$16800(this.this$0);
    QMMailManager.sharedInstance().mobileCancelBar(ReadMailFragment.access$200(this.this$0), ReadMailFragment.access$000(this.this$0).getInformation().getRemoteId());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.101
 * JD-Core Version:    0.7.0.1
 */