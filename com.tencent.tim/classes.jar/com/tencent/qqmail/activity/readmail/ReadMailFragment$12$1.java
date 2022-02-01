package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$12$1
  implements Runnable
{
  ReadMailFragment$12$1(ReadMailFragment.12 param12) {}
  
  public void run()
  {
    this.this$1.this$0.refreshData(false);
    ReadMailFragment.access$5100(this.this$1.this$0);
    ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131695670));
    QMLog.log(4, "ReadMailFragment", "topWatch onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.12.1
 * JD-Core Version:    0.7.0.1
 */