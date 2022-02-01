package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$14$2
  implements Runnable
{
  ReadMailFragment$14$2(ReadMailFragment.14 param14) {}
  
  public void run()
  {
    if (ReadMailFragment.access$5600(this.this$1.this$0))
    {
      ReadMailFragment.access$1600(this.this$1.this$0, this.this$1.this$0.getString(2131695665));
      ReadMailFragment.access$5602(this.this$1.this$0, false);
    }
    QMLog.log(6, "ReadMailFragment", "unreadWatch onError");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.14.2
 * JD-Core Version:    0.7.0.1
 */