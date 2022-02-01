package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

class ReadMailFragment$5
  extends IObserver
{
  ReadMailFragment$5(ReadMailFragment paramReadMailFragment, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(6, "ReadMailFragment", "Mail-attach-save-ftn error");
    long l = ((Long)((HashMap)paramObject).get("ftnfailexpired")).longValue();
    paramObservable = ReadMailFragment.access$000(this.this$0).getInformation().getBigAttachList().iterator();
    while (paramObservable.hasNext())
    {
      paramObject = (MailBigAttach)paramObservable.next();
      if (l == paramObject.getHashId()) {
        paramObject.setExpire(-2L);
      }
    }
    ReadMailFragment.access$1900(this.this$0, new ReadMailFragment.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.5
 * JD-Core Version:    0.7.0.1
 */