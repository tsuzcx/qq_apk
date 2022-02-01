package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$18$1
  implements Runnable
{
  ReadMailFragment$18$1(ReadMailFragment.18 param18) {}
  
  public void run()
  {
    this.this$1.this$0.refreshData(false);
    ReadMailFragment.access$5100(this.this$1.this$0);
    QMLog.log(4, "ReadMailFragment", "tagWatcher onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.18.1
 * JD-Core Version:    0.7.0.1
 */