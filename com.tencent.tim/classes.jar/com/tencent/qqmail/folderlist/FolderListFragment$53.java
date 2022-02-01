package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class FolderListFragment$53
  implements QMUIDialogAction.ActionListener
{
  FolderListFragment$53(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = AccountTypeListActivity.createIntent(true);
    this.this$0.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.53
 * JD-Core Version:    0.7.0.1
 */