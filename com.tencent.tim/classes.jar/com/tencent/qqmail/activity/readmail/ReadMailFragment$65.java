package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;

class ReadMailFragment$65
  implements View.OnClickListener
{
  ReadMailFragment$65(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    if (!this.this$0.isAttachedToActivity()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadMailFragment.access$12000(this.this$0, paramView);
      QMFolder localQMFolder = ReadMailFragment.access$12400(this.this$0);
      if (localQMFolder != null)
      {
        int i = j;
        if (localQMFolder.getType() != 5) {
          if (localQMFolder.getType() != 6) {
            break label79;
          }
        }
        label79:
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label84;
          }
          ReadMailFragment.access$12900(this.this$0);
          break;
        }
        label84:
        if (localQMFolder.getType() == 4)
        {
          if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getInformation() != null) && (ReadMailFragment.access$000(this.this$0).getInformation().getSendUtc() > 0L)) {
            ReadMailFragment.access$13000(this.this$0);
          } else {
            ReadMailFragment.access$13100(this.this$0);
          }
        }
        else
        {
          ReadMailFragment.access$13200(this.this$0, false);
          ReadMailFragment.access$6500(this.this$0);
        }
      }
      else
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), "删除失败", 0).show();
        DataCollector.logException(7, 34, "Event_Error", "删除失败", true);
        ReadMailFragment.access$6500(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.65
 * JD-Core Version:    0.7.0.1
 */