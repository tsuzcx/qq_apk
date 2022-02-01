package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

class QMReadEmlActivity$7
  extends IObserver
{
  QMReadEmlActivity$7(QMReadEmlActivity paramQMReadEmlActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    long l = ((Long)((HashMap)paramObject).get("ftn_fail_exceed_limit")).longValue();
    paramObservable = QMReadEmlActivity.access$1300(this.this$0).getBigAttachList().iterator();
    while (paramObservable.hasNext()) {
      if (l == ((MailBigAttach)paramObservable.next()).getHashId()) {
        QMReadEmlActivity.access$2700(this.this$0, new QMReadEmlActivity.7.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.7
 * JD-Core Version:    0.7.0.1
 */