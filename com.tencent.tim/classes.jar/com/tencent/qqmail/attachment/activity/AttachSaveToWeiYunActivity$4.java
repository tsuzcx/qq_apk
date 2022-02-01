package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.activity.watcher.ForwardToWeiYunWatcher;
import com.tencent.qqmail.utilities.log.QMLog;

class AttachSaveToWeiYunActivity$4
  implements ForwardToWeiYunWatcher
{
  AttachSaveToWeiYunActivity$4(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity) {}
  
  public void onError(int paramInt)
  {
    QMLog.log(6, "AttachSaveToWeiYunActivity", "forwardToWeiYunWatcher onError. ErrCode:" + paramInt + ",isLoading:" + AttachSaveToWeiYunActivity.access$000(this.this$0));
    if (AttachSaveToWeiYunActivity.access$000(this.this$0)) {
      AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
    }
    AttachSaveToWeiYunActivity.IS_TASK_LOADING = false;
  }
  
  public void onSuccess()
  {
    QMLog.log(4, "AttachSaveToWeiYunActivity", "forwardToWeiYunWatcher onSuccess; isLoading:" + AttachSaveToWeiYunActivity.access$000(this.this$0));
    if (AttachSaveToWeiYunActivity.access$000(this.this$0)) {
      AttachSaveToWeiYunActivity.access$500(this.this$0, 0, "");
    }
    AttachSaveToWeiYunActivity.IS_TASK_LOADING = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.4
 * JD-Core Version:    0.7.0.1
 */