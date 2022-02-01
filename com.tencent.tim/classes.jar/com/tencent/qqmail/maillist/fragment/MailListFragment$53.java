package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.folderlist.QMFolderManager;

class MailListFragment$53
  implements Runnable
{
  MailListFragment$53(MailListFragment paramMailListFragment) {}
  
  public void run()
  {
    QMFolderManager.sharedInstance().resetFolderHasNew(MailListFragment.access$2400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.53
 * JD-Core Version:    0.7.0.1
 */