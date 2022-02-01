package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.watcher.DeleteMailSyncRemoteWatcher;

class ConvMailListFragment$6
  implements DeleteMailSyncRemoteWatcher
{
  ConvMailListFragment$6(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onSuccess()
  {
    ConvMailListFragment.access$500(this.this$0).reloadAfterDeleteMailSyncRemote();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.6
 * JD-Core Version:    0.7.0.1
 */