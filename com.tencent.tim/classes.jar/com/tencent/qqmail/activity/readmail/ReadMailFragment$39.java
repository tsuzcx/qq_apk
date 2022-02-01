package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMMailManager;

class ReadMailFragment$39
  implements Runnable
{
  ReadMailFragment$39(ReadMailFragment paramReadMailFragment) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().tryLoadMail(ReadMailFragment.access$000(this.this$0), ReadMailFragment.access$3000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.39
 * JD-Core Version:    0.7.0.1
 */