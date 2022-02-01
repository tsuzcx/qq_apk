package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMReadMailView;
import com.tencent.qqmail.view.QMReadMailView.VIEW_ITEM;

class ReadMailFragment$16$1
  implements Runnable
{
  ReadMailFragment$16$1(ReadMailFragment.16 param16) {}
  
  public void run()
  {
    if (ReadMailFragment.access$4100(this.this$1.this$0))
    {
      if (ReadMailFragment.access$6100(this.this$1.this$0)) {
        this.this$1.this$0.setFragmentActivityResult(105, null);
      }
      this.this$1.this$0.popBackStack();
    }
    for (;;)
    {
      QMLog.log(4, "ReadMailFragment", "deleteWatcher onSuccess");
      return;
      ReadMailFragment.access$2400(this.this$1.this$0).setBottomBarItemClickable(QMReadMailView.VIEW_ITEM.DELETE, false);
      new MailDeleteAnimation(ReadMailFragment.access$2400(this.this$1.this$0).getAnimationView(), ReadMailFragment.access$6200(this.this$1.this$0), this.this$1.this$0.getActivity(), new ReadMailFragment.16.1.1(this)).animationStart();
      ReadMailFragment.access$6300(this.this$1.this$0);
      if ((ReadMailFragment.access$000(this.this$1.this$0) != null) && (ReadMailFragment.access$000(this.this$1.this$0).getInformation() != null) && (ReadMailFragment.access$000(this.this$1.this$0).getInformation().getSendUtc() > 0L)) {
        DataCollector.logEvent("Event_Delete_Timer_Mail_Success");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.16.1
 * JD-Core Version:    0.7.0.1
 */