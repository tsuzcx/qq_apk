package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class MailListFragment$48
  implements QMUnlockFolderPwdWatcher
{
  MailListFragment$48(MailListFragment paramMailListFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    MailListFragment.access$10400(this.this$0, new MailListFragment.48.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    MailListFragment.access$10300(this.this$0, new MailListFragment.48.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.48
 * JD-Core Version:    0.7.0.1
 */