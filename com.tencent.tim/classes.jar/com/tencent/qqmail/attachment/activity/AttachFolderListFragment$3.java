package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.model.mail.watcher.OperationAttachFolderWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AttachFolderListFragment$3
  implements OperationAttachFolderWatcher
{
  AttachFolderListFragment$3(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    if (AttachFolderListFragment.access$000(this.this$0) == null) {
      return;
    }
    AttachFolderListFragment.access$000(this.this$0).refresh(false, new AttachFolderListFragment.3.2(this));
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (AttachFolderListFragment.access$000(this.this$0) == null) {
      return;
    }
    AttachFolderListFragment.access$000(this.this$0).refresh(false, new AttachFolderListFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.3
 * JD-Core Version:    0.7.0.1
 */