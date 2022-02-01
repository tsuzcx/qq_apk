package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import java.util.List;

class ComposeMailActivity$5
  implements Runnable
{
  ComposeMailActivity$5(ComposeMailActivity paramComposeMailActivity, List paramList) {}
  
  public void run()
  {
    this.this$0.composeMail.setForceSync(false);
    QMAttachUtils.handleAddAttach(this.val$attachInfos, this.this$0.composeMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.5
 * JD-Core Version:    0.7.0.1
 */