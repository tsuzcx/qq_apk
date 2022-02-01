package com.tencent.qqmail.model.mail;

import java.util.concurrent.Callable;

class QMMailListCursor$8
  implements Callable<Boolean>
{
  QMMailListCursor$8(QMMailListCursor paramQMMailListCursor) {}
  
  public Boolean call()
  {
    return Boolean.valueOf(this.this$0.queryCanUpdate());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.8
 * JD-Core Version:    0.7.0.1
 */