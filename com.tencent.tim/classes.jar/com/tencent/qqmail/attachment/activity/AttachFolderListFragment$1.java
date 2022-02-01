package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.model.mail.watcher.LoadAttachFolderListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AttachFolderListFragment$1
  implements LoadAttachFolderListWatcher
{
  AttachFolderListFragment$1(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onError(int paramInt, boolean paramBoolean, QMNetworkError paramQMNetworkError)
  {
    if (AttachFolderListFragment.access$000(this.this$0) == null) {
      return;
    }
    AttachFolderListFragment.access$000(this.this$0).refresh(false, new AttachFolderListFragment.1.2(this));
  }
  
  public void onProcess(int paramInt1, int paramInt2) {}
  
  public void onSuccess(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (AttachFolderListFragment.access$000(this.this$0) == null) {
      return;
    }
    if ((paramBoolean2) && (paramBoolean3)) {
      AttachFolderListFragment.access$000(this.this$0).update(paramInt);
    }
    AttachFolderListFragment.access$000(this.this$0).refresh(false, new AttachFolderListFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.1
 * JD-Core Version:    0.7.0.1
 */