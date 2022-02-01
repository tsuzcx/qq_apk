package com.tencent.qqmail.attachment.activity;

import android.widget.ImageView;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.view.FolderLockDialog;
import java.util.ArrayList;
import java.util.HashMap;

class AttachFolderUnlockFolderActivity$1$1
  implements Runnable
{
  AttachFolderUnlockFolderActivity$1$1(AttachFolderUnlockFolderActivity.1 param1, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    AttachFolderUnlockFolderActivity.access$000(this.this$1.this$0).cancelDialog();
    AttachFolderUnlockFolderActivity.access$000(this.this$1.this$0).dismissTips();
    if (AttachFolderUnlockFolderActivity.access$100(this.this$1.this$0).containsKey(Integer.valueOf(this.val$accountId)))
    {
      ((UITableItemView)AttachFolderUnlockFolderActivity.access$100(this.this$1.this$0).get(Integer.valueOf(this.val$accountId))).getTailImage().setVisibility(0);
      QMSettingManager.sharedInstance().setAttachFolderLockStatus(this.val$accountId, false);
      while (i < AttachFolderUnlockFolderActivity.access$200(this.this$1.this$0).size())
      {
        if (((LockInfo)AttachFolderUnlockFolderActivity.access$200(this.this$1.this$0).get(i)).getAccountId() == this.val$accountId) {
          ((LockInfo)AttachFolderUnlockFolderActivity.access$200(this.this$1.this$0).get(i)).setUnLock(true);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderUnlockFolderActivity.1.1
 * JD-Core Version:    0.7.0.1
 */