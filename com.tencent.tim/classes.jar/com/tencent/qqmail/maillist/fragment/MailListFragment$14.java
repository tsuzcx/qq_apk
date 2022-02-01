package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class MailListFragment$14
  implements SyncPhotoWatcher
{
  MailListFragment$14(MailListFragment paramMailListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    if (MailListFragment.access$100(this.this$0) != null) {
      MailListFragment.access$6200(this.this$0, new MailListFragment.14.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.14
 * JD-Core Version:    0.7.0.1
 */