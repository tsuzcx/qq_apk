package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.utilities.thread.Threads;

class MailListFragment$52
  implements Runnable
{
  MailListFragment$52(MailListFragment paramMailListFragment) {}
  
  public void run()
  {
    Threads.cancelTask(MailListFragment.access$3900(this.this$0));
    int i = MailListFragment.access$2400(this.this$0);
    if (((MailListFragment.access$2800(this.this$0) == 5) || (MailListFragment.access$2800(this.this$0) == 6) || (MailListFragment.access$2800(this.this$0) == 15)) && (MailListFragment.access$100(this.this$0) != null)) {
      this.this$0.markAllMailRead();
    }
    QMFolderManager.sharedInstance().resetFolderHasNew(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.52
 * JD-Core Version:    0.7.0.1
 */