package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.functions.Action1;

class SendMailManager$44
  implements Action1<Throwable>
{
  SendMailManager$44(SendMailManager paramSendMailManager) {}
  
  public void call(Throwable paramThrowable)
  {
    QMLog.log(6, SendMailManager.access$100(), "checkFile error: " + paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.44
 * JD-Core Version:    0.7.0.1
 */