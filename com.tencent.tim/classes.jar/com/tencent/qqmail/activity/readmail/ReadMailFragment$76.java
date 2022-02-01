package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$76
  implements View.OnClickListener
{
  ReadMailFragment$76(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    QMFolder localQMFolder = ReadMailFragment.access$12400(this.this$0);
    ReadMailFragment.access$2400(this.this$0).toggleRedPointVisibility(3, false);
    if ((ReadMailFragment.access$000(this.this$0) == null) || (ReadMailFragment.access$000(this.this$0).getInformation() == null) || (localQMFolder == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int k = localQMFolder.getType();
      int i = j;
      if (k != 4)
      {
        i = j;
        if (k != 5)
        {
          i = j;
          if (k != 6) {
            i = 1;
          }
        }
      }
      if (!ReadMailFragment.access$000(this.this$0).getStatus().isConversationChild()) {
        i = 1;
      }
      j = i;
      if (k != 3)
      {
        j = i;
        if (k != 4) {
          if (ReadMailFragment.access$000(this.this$0).getStatus().isSystemMail())
          {
            j = i;
            if (!ReadMailFragment.access$000(this.this$0).getStatus().isSubscribeMail()) {}
          }
          else
          {
            j = 1;
          }
        }
      }
      if (j != 0)
      {
        if (this.this$0.getActivity() != null) {
          ReadMailFragment.access$13700(this.this$0);
        }
      }
      else
      {
        ReadMailFragment.access$12000(this.this$0, paramView);
        ReadMailFragment.access$13800(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.76
 * JD-Core Version:    0.7.0.1
 */