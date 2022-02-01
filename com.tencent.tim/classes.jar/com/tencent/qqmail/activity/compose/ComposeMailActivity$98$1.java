package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.utilities.ui.QMProgressTips;

class ComposeMailActivity$98$1
  implements Runnable
{
  ComposeMailActivity$98$1(ComposeMailActivity.98 param98, Long paramLong1, Long paramLong2) {}
  
  public void run()
  {
    double d = QMSendMailTask.calculateSendingProgress(ComposeMailActivity.access$11500(this.this$1.this$0).getProgress(), this.val$bytesWritten.longValue(), this.val$totalBytesWritten, false);
    ComposeMailActivity.access$11500(this.this$1.this$0).updateProgress(d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.98.1
 * JD-Core Version:    0.7.0.1
 */