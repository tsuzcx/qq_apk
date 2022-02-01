package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.card.watcher.SaveCardWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ComposeMailActivity$87
  implements SaveCardWatcher
{
  ComposeMailActivity$87(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onBefore() {}
  
  public void onError(QMNetworkError paramQMNetworkError, int paramInt)
  {
    QMLog.log(4, "ComposeMailActivity", "cardpreview h5url: error: " + paramInt, paramQMNetworkError);
    ComposeMailActivity.access$4402(this.this$0, ComposeMailActivity.SendMailStatus.SENDFAIL);
    ComposeMailActivity.access$10200(this.this$0, new ComposeMailActivity.87.2(this));
    ComposeMailActivity.access$3702(this.this$0, false);
  }
  
  public void onSuccess(String paramString1, String paramString2, int paramInt)
  {
    QMLog.log(4, "ComposeMailActivity", "cardpreview h5url: " + paramString1 + ", key: " + paramInt + ", " + ComposeMailActivity.access$9400(this.this$0) + ", cardId: " + paramString2);
    if (ComposeMailActivity.access$9400(this.this$0) == paramInt) {
      ComposeMailActivity.access$9900(this.this$0, new ComposeMailActivity.87.1(this, paramString2, paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.87
 * JD-Core Version:    0.7.0.1
 */