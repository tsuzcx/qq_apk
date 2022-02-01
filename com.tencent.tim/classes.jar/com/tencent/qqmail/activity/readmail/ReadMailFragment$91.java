package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;

class ReadMailFragment$91
  implements View.OnClickListener
{
  ReadMailFragment$91(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    ReadMailFragment.access$12000(this.this$0, paramView);
    ReadMailFragment.access$15000(this.this$0, QMApplicationContext.sharedInstance().getString(2131691548), ReadMailFragment.access$000(this.this$0).getInformation().getSendUtc(), ReadMailFragment.access$16100(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.91
 * JD-Core Version:    0.7.0.1
 */