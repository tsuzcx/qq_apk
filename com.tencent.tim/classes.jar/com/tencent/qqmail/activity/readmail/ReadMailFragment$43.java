package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.attachment.QMAttachManager;

class ReadMailFragment$43
  implements Runnable
{
  ReadMailFragment$43(ReadMailFragment paramReadMailFragment) {}
  
  public void run()
  {
    QMAttachManager.sharedInstance().checkAttachFolderListUpdate(ReadMailFragment.access$200(this.this$0), true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.43
 * JD-Core Version:    0.7.0.1
 */