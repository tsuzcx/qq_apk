package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$3$2
  implements Runnable
{
  ReadMailFragment$3$2(ReadMailFragment.3 param3, int paramInt) {}
  
  public void run()
  {
    QMLog.log(4, "ReadMailFragment", "show tips ret code: " + this.val$retCode);
    if (this.val$retCode == 0)
    {
      ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131718941));
      return;
    }
    if (this.val$retCode == 2)
    {
      ReadMailFragment.access$1600(this.this$1.this$0, this.this$1.this$0.getString(2131694072));
      return;
    }
    if (this.val$retCode == 4)
    {
      ReadMailFragment.access$1600(this.this$1.this$0, this.this$1.this$0.getString(2131694053));
      return;
    }
    if (this.val$retCode == 3)
    {
      ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131718940));
      return;
    }
    if (this.val$retCode == 6)
    {
      ReadMailFragment.access$1600(this.this$1.this$0, this.this$1.this$0.getString(2131694069));
      return;
    }
    ReadMailFragment.access$1600(this.this$1.this$0, this.this$1.this$0.getString(2131718938));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.3.2
 * JD-Core Version:    0.7.0.1
 */