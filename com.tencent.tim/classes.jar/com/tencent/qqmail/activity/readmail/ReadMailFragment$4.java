package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.Observable;

class ReadMailFragment$4
  extends IObserver
{
  ReadMailFragment$4(ReadMailFragment paramReadMailFragment, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(6, "ReadMailFragment", "Mail-attach-save-ftn error");
    ReadMailFragment.access$1800(this.this$0, new ReadMailFragment.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.4
 * JD-Core Version:    0.7.0.1
 */