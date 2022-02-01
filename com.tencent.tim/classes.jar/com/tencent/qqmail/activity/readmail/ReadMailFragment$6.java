package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class ReadMailFragment$6
  extends IObserver
{
  ReadMailFragment$6(ReadMailFragment paramReadMailFragment, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    long l = ((Long)((HashMap)paramObject).get("ftn_fail_exceed_limit")).longValue();
    int j = ReadMailFragment.AttachListViewAdapter.access$2100(ReadMailFragment.access$2000(this.this$0));
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        paramObservable = (Attach)ReadMailFragment.access$2000(this.this$0).getItem(i);
        if ((paramObservable != null) && (paramObservable.getHashId() == l)) {
          ReadMailFragment.access$2200(this.this$0, new ReadMailFragment.6.1(this));
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.6
 * JD-Core Version:    0.7.0.1
 */