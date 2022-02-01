package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.FolderLockDialog;
import java.util.ArrayList;
import java.util.HashMap;

class UnlockFolderActivity$2
  implements UITableView.ClickListener
{
  UnlockFolderActivity$2(UnlockFolderActivity paramUnlockFolderActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    QMLog.log(4, "UnlockFolderActivity", "Extension list on click, index: " + paramInt);
    UnlockFolderActivity.access$100(this.this$0).clear();
    LockInfo localLockInfo = (LockInfo)UnlockFolderActivity.access$200(this.this$0).get(paramInt);
    if ((localLockInfo != null) && (!localLockInfo.isUnLock()))
    {
      QMLog.log(4, "UnlockFolderActivity", "Extension index: " + paramInt + " tag: " + paramUITableItemView.getTag() + " accountid: " + localLockInfo.getAccountId());
      UnlockFolderActivity.access$002(this.this$0, new FolderLockDialog(this.this$0, localLockInfo.getFolderId(), localLockInfo.getAccountId(), UnlockFolderActivity.access$500(this.this$0)));
      UnlockFolderActivity.access$000(this.this$0).createDialog(1);
      UnlockFolderActivity.access$000(this.this$0).showDialog();
      UnlockFolderActivity.access$100(this.this$0).put(Integer.valueOf(localLockInfo.getAccountId()), paramUITableItemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.UnlockFolderActivity.2
 * JD-Core Version:    0.7.0.1
 */