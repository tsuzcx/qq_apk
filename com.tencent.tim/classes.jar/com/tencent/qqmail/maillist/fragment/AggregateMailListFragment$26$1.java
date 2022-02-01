package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

class AggregateMailListFragment$26$1
  implements QMUIDialogAction.ActionListener
{
  AggregateMailListFragment$26$1(AggregateMailListFragment.26 param26) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Iterator localIterator = QMFolderManager.sharedInstance().getFoldersByAccountId(AggregateMailListFragment.access$3300(this.this$1.this$0)).iterator();
    while (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)localIterator.next();
      if (localQMFolder.getType() == 1) {
        AggregateMailListFragment.access$3200(this.this$1.this$0).rejectMail(AggregateMailListFragment.access$3300(this.this$1.this$0), localQMFolder.getId(), AggregateMailListFragment.access$2800(this.this$1.this$0), true, false);
      }
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.26.1
 * JD-Core Version:    0.7.0.1
 */