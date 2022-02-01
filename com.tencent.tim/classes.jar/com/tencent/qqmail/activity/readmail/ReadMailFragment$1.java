package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import java.util.concurrent.Callable;

class ReadMailFragment$1
  implements Callable<Boolean>
{
  ReadMailFragment$1(ReadMailFragment paramReadMailFragment) {}
  
  public Boolean call()
  {
    QMMailManager.sharedInstance().fillMailExtra(ReadMailFragment.access$000(this.this$0), ReadMailFragment.access$100(this.this$0), false);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.1
 * JD-Core Version:    0.7.0.1
 */