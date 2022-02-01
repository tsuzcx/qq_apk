package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ConvMailListFragment$1
  implements LoadListWatcher
{
  ConvMailListFragment$1(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onPopIn(long paramLong, String paramString)
  {
    ConvMailListFragment.access$300(this.this$0, new ConvMailListFragment.1.2(this, paramLong, paramString));
  }
  
  public void onProcess(int paramInt, boolean paramBoolean) {}
  
  public void onSuccess(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ConvMailListFragment.access$100(this.this$0, new ConvMailListFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.1
 * JD-Core Version:    0.7.0.1
 */