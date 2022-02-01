package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class MailRecallListFragment$1
  implements SyncPhotoWatcher
{
  MailRecallListFragment$1(MailRecallListFragment paramMailRecallListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    MailRecallListFragment.access$200(this.this$0, new MailRecallListFragment.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailRecallListFragment.1
 * JD-Core Version:    0.7.0.1
 */