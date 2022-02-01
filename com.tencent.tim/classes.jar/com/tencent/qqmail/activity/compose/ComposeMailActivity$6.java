package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import java.util.List;

class ComposeMailActivity$6
  implements Runnable
{
  ComposeMailActivity$6(ComposeMailActivity paramComposeMailActivity, ComposeMailUI paramComposeMailUI, List paramList) {}
  
  public void run()
  {
    this.val$composeMail.setForceSync(false);
    QMAttachUtils.handleAddAttach(this.val$attachInfos, this.val$composeMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.6
 * JD-Core Version:    0.7.0.1
 */