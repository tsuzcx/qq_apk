package com.tencent.qqmail.sendmaillist;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.sendmail.SendMailTaskFtnInfo;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.ui.QMSendMailNotification;
import java.util.Iterator;
import java.util.List;

class SendMailListFragment$8
  implements QMUIDialogAction.ActionListener
{
  SendMailListFragment$8(SendMailListFragment paramSendMailListFragment, QMSendMailTask paramQMSendMailTask) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    this.val$selectedTask.deleteComposeCache();
    Object localObject = QMTaskManager.sharedInstance(1).getSQLite().getSendMailTaskFtnInfos(this.val$selectedTask.getId());
    paramQMUIDialog = FtnManager.sharedInstance();
    if (paramQMUIDialog != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SendMailTaskFtnInfo localSendMailTaskFtnInfo = (SendMailTaskFtnInfo)((Iterator)localObject).next();
        paramQMUIDialog.abortAndRemoveRequest(localSendMailTaskFtnInfo.getFid());
        paramQMUIDialog.removeUploadData(localSendMailTaskFtnInfo.getFid());
        paramQMUIDialog.deleteUploadInfo(localSendMailTaskFtnInfo.getRid());
      }
    }
    QMTaskManager.sharedInstance(1).delete(this.val$selectedTask.getId());
    if (SendMailListFragment.access$1000(this.this$0).getCount() <= 1) {
      QMSendMailNotification.getInstance().clearErrorNotification();
    }
    SendMailListFragment.access$1000(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.8
 * JD-Core Version:    0.7.0.1
 */