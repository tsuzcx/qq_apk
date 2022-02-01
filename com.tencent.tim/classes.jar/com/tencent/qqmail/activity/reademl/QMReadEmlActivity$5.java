package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.Observable;

class QMReadEmlActivity$5
  extends IObserver
{
  QMReadEmlActivity$5(QMReadEmlActivity paramQMReadEmlActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(6, "QMReadEmlActivity", "Mail-attach-save-ftn error");
    QMReadEmlActivity.access$2500(this.this$0, new QMReadEmlActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.5
 * JD-Core Version:    0.7.0.1
 */