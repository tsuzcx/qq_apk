package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMMailManager;

class ReadMailFragment$33$2
  implements Runnable
{
  ReadMailFragment$33$2(ReadMailFragment.33 param33) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().updateMailInfo(ReadMailFragment.access$000(this.this$1.this$0), ReadMailFragment.access$100(this.this$1.this$0));
    ReadMailFragment.access$5100(this.this$1.this$0);
    ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131718965));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.33.2
 * JD-Core Version:    0.7.0.1
 */