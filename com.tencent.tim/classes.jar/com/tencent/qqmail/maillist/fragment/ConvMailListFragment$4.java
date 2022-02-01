package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.watcher.LoadMailWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ConvMailListFragment$4
  implements LoadMailWatcher
{
  ConvMailListFragment$4(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onConvChildSuccess(long paramLong1, long paramLong2) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    ConvMailListFragment.access$1200(this.this$0, new ConvMailListFragment.4.2(this));
  }
  
  public void onLocalSuccess(Mail paramMail) {}
  
  public void onProcess(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onSuccess(long paramLong)
  {
    if (paramLong == ConvMailListFragment.access$800(this.this$0)) {
      ConvMailListFragment.access$500(this.this$0).refresh(new ConvMailListFragment.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.4
 * JD-Core Version:    0.7.0.1
 */