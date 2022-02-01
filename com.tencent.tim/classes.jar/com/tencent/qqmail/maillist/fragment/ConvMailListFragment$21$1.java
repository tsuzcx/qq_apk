package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

class ConvMailListFragment$21$1
  implements QMUIDialogAction.ActionListener
{
  ConvMailListFragment$21$1(ConvMailListFragment.21 param21) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Iterator localIterator = QMFolderManager.sharedInstance().getFoldersByAccountId(ConvMailListFragment.access$3300(this.this$1.this$0)).iterator();
    while (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)localIterator.next();
      if (localQMFolder.getType() == 1) {
        ConvMailListFragment.access$3100(this.this$1.this$0).rejectMail(ConvMailListFragment.access$3300(this.this$1.this$0), localQMFolder.getId(), ConvMailListFragment.access$2700(this.this$1.this$0), true, false);
      }
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.21.1
 * JD-Core Version:    0.7.0.1
 */