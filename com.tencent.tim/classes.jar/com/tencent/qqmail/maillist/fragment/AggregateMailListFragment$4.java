package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.watcher.LoadMailWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AggregateMailListFragment$4
  implements LoadMailWatcher
{
  AggregateMailListFragment$4(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onConvChildSuccess(long paramLong1, long paramLong2) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    AggregateMailListFragment.access$1100(this.this$0, new AggregateMailListFragment.4.2(this));
  }
  
  public void onLocalSuccess(Mail paramMail) {}
  
  public void onProcess(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onSuccess(long paramLong)
  {
    AggregateMailListFragment.access$500(this.this$0).refresh(new AggregateMailListFragment.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.4
 * JD-Core Version:    0.7.0.1
 */