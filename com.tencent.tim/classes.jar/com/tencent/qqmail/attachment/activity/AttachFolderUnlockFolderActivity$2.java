package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.FolderLockDialog;
import java.util.ArrayList;
import java.util.HashMap;

class AttachFolderUnlockFolderActivity$2
  implements UITableView.ClickListener
{
  AttachFolderUnlockFolderActivity$2(AttachFolderUnlockFolderActivity paramAttachFolderUnlockFolderActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    QMLog.log(4, AttachFolderUnlockFolderActivity.TAG, "Extension list on click, index: " + paramInt);
    AttachFolderUnlockFolderActivity.access$100(this.this$0).clear();
    LockInfo localLockInfo = (LockInfo)AttachFolderUnlockFolderActivity.access$200(this.this$0).get(paramInt);
    if ((localLockInfo != null) && (!localLockInfo.isUnLock()))
    {
      QMLog.log(4, AttachFolderUnlockFolderActivity.TAG, "Extension index: " + paramInt + " tag: " + paramUITableItemView.getTag() + " accountid: " + localLockInfo.getAccountId());
      AttachFolderUnlockFolderActivity.access$002(this.this$0, new FolderLockDialog(this.this$0, localLockInfo.getFolderId(), localLockInfo.getAccountId(), AttachFolderUnlockFolderActivity.access$500(this.this$0)));
      AttachFolderUnlockFolderActivity.access$000(this.this$0).createDialog(1);
      AttachFolderUnlockFolderActivity.access$000(this.this$0).showDialog();
      AttachFolderUnlockFolderActivity.access$100(this.this$0).put(Integer.valueOf(localLockInfo.getAccountId()), paramUITableItemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderUnlockFolderActivity.2
 * JD-Core Version:    0.7.0.1
 */