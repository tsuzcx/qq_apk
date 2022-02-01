package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.QMReadMailView;
import java.util.concurrent.atomic.AtomicBoolean;

class ReadMailFragment$38
  implements Runnable
{
  ReadMailFragment$38(ReadMailFragment paramReadMailFragment) {}
  
  public void run()
  {
    if ((ReadMailFragment.access$10700(this.this$0) != null) && (ReadMailFragment.access$2400(this.this$0) != null) && (ReadMailFragment.access$2400(this.this$0).setTranslateStatus(4)))
    {
      ReadMailFragment.access$10800(this.this$0, ReadMailFragment.access$10700(this.this$0).getTranslateContent(), ReadMailFragment.access$10700(this.this$0).getTranslateSubj());
      if (ReadMailFragment.access$2300(this.this$0) != null) {
        ReadMailFragment.access$10902(this.this$0, ReadMailFragment.access$2300(this.this$0).getScrollY());
      }
      ReadMailFragment.access$9100(this.this$0, true);
      ReadMailFragment.access$11000(this.this$0).getAndSet(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.38
 * JD-Core Version:    0.7.0.1
 */