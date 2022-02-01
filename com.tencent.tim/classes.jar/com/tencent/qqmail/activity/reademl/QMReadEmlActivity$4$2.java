package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.utilities.log.QMLog;

class QMReadEmlActivity$4$2
  implements Runnable
{
  QMReadEmlActivity$4$2(QMReadEmlActivity.4 param4, int paramInt) {}
  
  public void run()
  {
    QMLog.log(4, "QMReadEmlActivity", "show tips ret code: " + this.val$retCode);
    if (this.val$retCode == 0)
    {
      QMReadEmlActivity.access$2200(this.this$1.this$0, this.this$1.this$0.getString(2131718941));
      return;
    }
    if (this.val$retCode == 2)
    {
      QMReadEmlActivity.access$2300(this.this$1.this$0, this.this$1.this$0.getString(2131694072));
      return;
    }
    if (this.val$retCode == 4)
    {
      QMReadEmlActivity.access$2300(this.this$1.this$0, this.this$1.this$0.getString(2131694053));
      return;
    }
    if (this.val$retCode == 3)
    {
      QMReadEmlActivity.access$2200(this.this$1.this$0, this.this$1.this$0.getString(2131718940));
      return;
    }
    if (this.val$retCode == 6)
    {
      QMReadEmlActivity.access$2300(this.this$1.this$0, this.this$1.this$0.getString(2131694069));
      return;
    }
    QMReadEmlActivity.access$2300(this.this$1.this$0, this.this$1.this$0.getString(2131718938));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.4.2
 * JD-Core Version:    0.7.0.1
 */