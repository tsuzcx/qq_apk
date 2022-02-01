package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.HashMap;

class FolderListFragment$24
  implements QMUIDialogAction.ActionListener
{
  FolderListFragment$24(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    DataCollector.logEvent("Event_Folderlist_Hide_Inbox_Dialog_Show_Click_Sure");
    FolderListFragment.access$4900(this.this$0).clear();
    FolderListFragment.access$5000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.24
 * JD-Core Version:    0.7.0.1
 */