package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import java.util.List;
import moai.oss.KvHelper;

class ComposeMailActivity$51
  implements Runnable
{
  ComposeMailActivity$51(ComposeMailActivity paramComposeMailActivity, List paramList) {}
  
  public void run()
  {
    this.this$0.composeMail.setForceSync(false);
    QMAttachUtils.handleAddAttach(this.val$newAddAttachInfos, this.this$0.composeMail);
    KvHelper.eventOpeninBigattachmentConfirm(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.51
 * JD-Core Version:    0.7.0.1
 */