package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.trd.guava.Longs;
import java.util.List;

class AttachFolderListFragment$6
  implements Runnable
{
  AttachFolderListFragment$6(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void run()
  {
    List localList = QMAttachManager.sharedInstance().getAttachFolderListCursorByIds(Longs.toArray(AttachFolderListFragment.access$1000(this.this$0)));
    AttachFolderListFragment.access$1100(this.this$0).addAll(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.6
 * JD-Core Version:    0.7.0.1
 */