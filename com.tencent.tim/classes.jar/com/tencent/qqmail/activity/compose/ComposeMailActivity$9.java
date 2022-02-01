package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;

class ComposeMailActivity$9
  implements Runnable
{
  ComposeMailActivity$9(ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    if ((!ComposeMailActivity.access$300(this.this$0)) && (ComposeMailActivity.access$400(this.this$0) != null) && (!ComposeMailActivity.access$400(this.this$0).equals("sendlist")) && (this.this$0.composeMail != null)) {
      this.this$0.composeMail.deleteComposeCache();
    }
    LocalDraftUtils.deleteLocalDraft();
    QMLog.log(4, "LocalDraft", "ComposeMailActivity : delete localdraft done");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.9
 * JD-Core Version:    0.7.0.1
 */