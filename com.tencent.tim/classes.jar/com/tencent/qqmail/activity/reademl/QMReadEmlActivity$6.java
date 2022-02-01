package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

class QMReadEmlActivity$6
  extends IObserver
{
  QMReadEmlActivity$6(QMReadEmlActivity paramQMReadEmlActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(6, "QMReadEmlActivity", "Mail-attach-save-ftn error");
    long l = ((Long)((HashMap)paramObject).get("ftnfailexpired")).longValue();
    paramObservable = QMReadEmlActivity.access$1300(this.this$0).getBigAttachList().iterator();
    while (paramObservable.hasNext())
    {
      paramObject = (MailBigAttach)paramObservable.next();
      if (l == paramObject.getHashId()) {
        paramObject.setExpire(-2L);
      }
    }
    QMReadEmlActivity.access$2600(this.this$0, new QMReadEmlActivity.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.6
 * JD-Core Version:    0.7.0.1
 */