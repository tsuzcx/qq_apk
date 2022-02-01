package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.FeedbackManager;

class ComposeFeedbackActivity$10
  implements Runnable
{
  ComposeFeedbackActivity$10(ComposeFeedbackActivity paramComposeFeedbackActivity, String paramString, AttachInfo paramAttachInfo, ComposeMailUI paramComposeMailUI) {}
  
  public void run()
  {
    FeedbackManager.compressFeedbackFile(this.val$zipFilePath, null, ComposeFeedbackActivity.access$500(this.this$0));
    this.val$attachInfo.setRealSize(FileUtil.getFileSize(this.val$attachInfo.getAttachPath()));
    ComposeFeedbackActivity.access$602(this.this$0, Attach.generateHashId(this.val$composeMail.getComposeDate(), String.valueOf(this.val$attachInfo.getRealSize()), this.val$attachInfo.getAttachName()));
    this.val$attachInfo.setHashId(ComposeFeedbackActivity.access$600(this.this$0));
    ComposeFeedbackActivity.10.1 local1 = new ComposeFeedbackActivity.10.1(this);
    ComposeFeedbackActivity.access$700(this.this$0, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.10
 * JD-Core Version:    0.7.0.1
 */