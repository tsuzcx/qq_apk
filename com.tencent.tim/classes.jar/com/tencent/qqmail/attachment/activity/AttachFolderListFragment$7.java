package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import java.util.concurrent.Callable;

class AttachFolderListFragment$7
  implements Callable<AttachFolderListCursor>
{
  AttachFolderListFragment$7(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public AttachFolderListCursor call()
  {
    AttachFolderListCursor localAttachFolderListCursor = QMAttachManager.sharedInstance().getAttachFolderListCursor();
    localAttachFolderListCursor.setOnRefresh(new AttachFolderListFragment.7.1(this));
    localAttachFolderListCursor.refresh(true, null);
    return localAttachFolderListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.7
 * JD-Core Version:    0.7.0.1
 */