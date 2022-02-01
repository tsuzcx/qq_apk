package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class MailListFragment$15
  implements SyncWatcher
{
  MailListFragment$15(MailListFragment paramMailListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    DataCollector.logPerformanceEnd("Performance_Check_New_Mail_MailList_maillist_" + MailListFragment.access$2400(this.this$0), "");
    if ((MailListFragment.access$2200(this.this$0) == paramInt) || (paramInt == 0)) {
      MailListFragment.access$6500(this.this$0, new MailListFragment.15.2(this, paramQMNetworkError));
    }
  }
  
  public void onSuccess(int paramInt)
  {
    DataCollector.logPerformanceEnd("Performance_Check_New_Mail_MailList_maillist_" + MailListFragment.access$2400(this.this$0), "");
    MailListFragment.access$6300(this.this$0, new MailListFragment.15.1(this));
  }
  
  public void onSyncBegin(int paramInt, boolean paramBoolean) {}
  
  public void onSyncEnd(int paramInt, boolean paramBoolean)
  {
    if (((MailListFragment.access$2200(this.this$0) != paramInt) && (paramInt != 0)) || (MailListFragment.access$200(this.this$0) == null)) {
      return;
    }
    MailListFragment.access$6600(this.this$0, new MailListFragment.15.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.15
 * JD-Core Version:    0.7.0.1
 */