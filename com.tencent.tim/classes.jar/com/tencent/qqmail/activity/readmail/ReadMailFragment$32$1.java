package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$32$1
  implements Runnable
{
  ReadMailFragment$32$1(ReadMailFragment.32 param32, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (ReadMailFragment.access$2400(this.this$1.this$0) != null)
    {
      if ((this.val$error != null) && (this.val$error.desp != null) && (this.val$error.desp.equals(QMApplicationContext.sharedInstance().getString(2131696284)))) {
        ReadMailFragment.access$2400(this.this$1.this$0).setTranslateStatus(2, -2);
      }
    }
    else {
      return;
    }
    ReadMailFragment.access$2400(this.this$1.this$0).setTranslateStatus(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.32.1
 * JD-Core Version:    0.7.0.1
 */