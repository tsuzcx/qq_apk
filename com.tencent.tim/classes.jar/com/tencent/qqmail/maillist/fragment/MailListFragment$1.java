package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.FolderUnreadCountWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class MailListFragment$1
  implements FolderUnreadCountWatcher
{
  MailListFragment$1(MailListFragment paramMailListFragment) {}
  
  public void onUpdateAccount(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void onUpdateFolder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (MailListFragment.access$2400(this.this$0) == MailListFragment.access$3600(this.this$0).getId())
    {
      MailListFragment.access$3600(this.this$0).setCliUnreadCount(paramInt2);
      MailListFragment.access$3800(this.this$0, new MailListFragment.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.1
 * JD-Core Version:    0.7.0.1
 */