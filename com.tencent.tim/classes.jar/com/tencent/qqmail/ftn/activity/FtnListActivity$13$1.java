package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;

class FtnListActivity$13$1
  implements Runnable
{
  FtnListActivity$13$1(FtnListActivity.13 param13, FtnUploadInfo paramFtnUploadInfo) {}
  
  public void run()
  {
    if (this.val$uploadItemData.getProgress() >= 100)
    {
      this.this$1.this$0.handleUploadFileSuccess(this.val$uploadItemData);
      return;
    }
    this.val$uploadItemData.setTaskFinish(true);
    this.val$uploadItemData.setSchedule(100);
    FtnListActivity.access$3400(this.this$1.this$0, this.val$uploadItemData, 100, 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.13.1
 * JD-Core Version:    0.7.0.1
 */