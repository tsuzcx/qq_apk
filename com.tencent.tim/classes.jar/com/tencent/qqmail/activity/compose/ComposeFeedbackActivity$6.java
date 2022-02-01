package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.FeedbackManager;

class ComposeFeedbackActivity$6
  implements Runnable
{
  ComposeFeedbackActivity$6(ComposeFeedbackActivity paramComposeFeedbackActivity) {}
  
  public void run()
  {
    String str = this.this$0.getContentFromComposeView();
    FeedbackManager.sendLog("mailapppushlog@qq.com", "mailapppushlog", "d90Ebe5$2c848j57", "loginhelp@qq.com", this.this$0.prepareFeedbackSubject(), this.this$0.prepareFeedbackBodyString(str), null, this.this$0.composeMail.getAddAttachInfoList(), this.this$0.sendcallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.6
 * JD-Core Version:    0.7.0.1
 */