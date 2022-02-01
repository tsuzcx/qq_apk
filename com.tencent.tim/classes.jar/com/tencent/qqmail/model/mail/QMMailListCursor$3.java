package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.Callable;

class QMMailListCursor$3
  implements Callable<Boolean>
{
  QMMailListCursor$3(QMMailListCursor paramQMMailListCursor) {}
  
  public Boolean call()
  {
    QMLog.log(4, "QMMailListCursor", "queryCanLoadMore," + this.this$0);
    return Boolean.valueOf(this.this$0.queryCanLoadMore());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.3
 * JD-Core Version:    0.7.0.1
 */