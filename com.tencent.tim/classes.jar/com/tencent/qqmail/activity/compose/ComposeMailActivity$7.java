package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.Iterator;
import java.util.List;
import moai.oss.KvHelper;

class ComposeMailActivity$7
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$7(ComposeMailActivity paramComposeMailActivity, List paramList, Runnable paramRunnable) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Iterator localIterator = this.val$newAddAttachInfos.iterator();
    while (localIterator.hasNext())
    {
      AttachInfo localAttachInfo = (AttachInfo)localIterator.next();
      localAttachInfo.setNeedFtnUpload(true);
      localAttachInfo.setBigAttach(true);
    }
    if (this.val$addAttachTask != null) {
      this.val$addAttachTask.run();
    }
    if (!ComposeMailActivity.access$200(this.this$0)) {
      KvHelper.eventSendBigattachmentConfirm(new double[0]);
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.7
 * JD-Core Version:    0.7.0.1
 */