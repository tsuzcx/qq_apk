package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.view.QMReadMailView;
import com.tencent.qqmail.view.QMReadMailView.onQuickReplyListener;

class ReadMailFragment$37
  implements QMReadMailView.onQuickReplyListener
{
  ReadMailFragment$37(ReadMailFragment paramReadMailFragment) {}
  
  public void onQuickReply()
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getStatus() != null))
    {
      if ((ReadMailFragment.access$000(this.this$0).getStatus().isGroupMail()) && (ReadMailFragment.access$000(this.this$0).getStatus().isGroupOff())) {
        ReadMailFragment.access$10500(this.this$0, 0);
      }
    }
    else {
      return;
    }
    ReadMailFragment.access$10600(this.this$0);
  }
  
  public void onStartQuickRelply() {}
  
  public void onStartQuickReply()
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getStatus() != null))
    {
      if ((ReadMailFragment.access$000(this.this$0).getStatus().isGroupMail()) && (ReadMailFragment.access$000(this.this$0).getStatus().isGroupOff())) {
        ReadMailFragment.access$2400(this.this$0).setEnterReplyModel(false);
      }
    }
    else {
      return;
    }
    ReadMailFragment.access$2400(this.this$0).setEnterReplyModel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.37
 * JD-Core Version:    0.7.0.1
 */