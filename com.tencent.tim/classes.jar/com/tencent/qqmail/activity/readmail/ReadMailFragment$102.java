package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;

class ReadMailFragment$102
  implements View.OnClickListener
{
  ReadMailFragment$102(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getIcsEvent() != null))
    {
      ReadIcsFragment localReadIcsFragment = new ReadIcsFragment(ReadMailFragment.access$000(this.this$0).getInformation().getAccountId(), ReadMailFragment.access$000(this.this$0).getInformation().getRemoteId());
      this.this$0.startFragment(localReadIcsFragment);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.102
 * JD-Core Version:    0.7.0.1
 */