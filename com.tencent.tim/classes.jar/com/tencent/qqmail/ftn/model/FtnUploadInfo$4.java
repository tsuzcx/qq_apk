package com.tencent.qqmail.ftn.model;

import com.tencent.qqmail.animation.ProgressBarCallback.ICompleteCallback;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import java.lang.ref.WeakReference;

class FtnUploadInfo$4
  implements ProgressBarCallback.ICompleteCallback
{
  FtnUploadInfo$4(FtnUploadInfo paramFtnUploadInfo) {}
  
  public void run(int paramInt)
  {
    this.this$0.setProgress(paramInt);
    if ((this.this$0.isTaskFinish()) && (FtnUploadInfo.access$000(this.this$0) != null))
    {
      FtnListActivity localFtnListActivity = (FtnListActivity)FtnUploadInfo.access$000(this.this$0).get();
      if (localFtnListActivity != null) {
        localFtnListActivity.handleUploadFileSuccess(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnUploadInfo.4
 * JD-Core Version:    0.7.0.1
 */