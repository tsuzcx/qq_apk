package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.view.FolderLockDialog;

class AttachFolderListFragment$2$1
  implements Runnable
{
  AttachFolderListFragment$2$1(AttachFolderListFragment.2 param2, int paramInt) {}
  
  public void run()
  {
    AttachFolderListFragment.access$400(this.this$1.this$0).cancelDialog();
    AttachFolderListFragment.access$400(this.this$1.this$0).dismissTips();
    QMSettingManager.sharedInstance().setAttachFolderLockStatus(this.val$accountId, false);
    if (AttachFolderListFragment.access$000(this.this$1.this$0) != null) {
      AttachFolderListFragment.access$000(this.this$1.this$0).update(this.val$accountId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.2.1
 * JD-Core Version:    0.7.0.1
 */