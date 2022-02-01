package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$17$1
  implements Runnable
{
  ReadMailFragment$17$1(ReadMailFragment.17 param17) {}
  
  public void run()
  {
    if (ReadMailFragment.access$4100(this.this$1.this$0)) {
      this.this$1.this$0.popBackStack();
    }
    for (;;)
    {
      QMLog.log(4, "ReadMailFragment", "purgeDeleteWatcher onSuccess");
      return;
      new MailDeleteAnimation(ReadMailFragment.access$2400(this.this$1.this$0).getAnimationView(), ReadMailFragment.access$6200(this.this$1.this$0), this.this$1.this$0.getActivity(), new ReadMailFragment.17.1.1(this)).animationStart();
      ReadMailFragment.access$6300(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.17.1
 * JD-Core Version:    0.7.0.1
 */