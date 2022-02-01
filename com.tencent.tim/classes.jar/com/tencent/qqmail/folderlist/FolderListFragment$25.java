package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class FolderListFragment$25
  implements QMUIDialogAction.ActionListener
{
  FolderListFragment$25(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    DataCollector.logEvent("Event_Folderlist_Hide_Inbox_Dialog_Show_Click_Cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.25
 * JD-Core Version:    0.7.0.1
 */