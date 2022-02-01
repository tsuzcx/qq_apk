package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.model.mail.watcher.ParseEmlWatcher;

class QMReadEmlActivity$2
  implements ParseEmlWatcher
{
  QMReadEmlActivity$2(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void onError()
  {
    QMReadEmlActivity.access$1100(this.this$0, new QMReadEmlActivity.2.2(this));
  }
  
  public void onSuccess(int paramInt, long paramLong)
  {
    QMReadEmlActivity.access$002(this.this$0, paramLong);
    QMReadEmlActivity.access$702(this.this$0, true);
    QMReadEmlActivity.access$802(this.this$0, false);
    QMReadEmlActivity.access$1000(this.this$0, new QMReadEmlActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.2
 * JD-Core Version:    0.7.0.1
 */