package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;

class FtnListActivity$48
  implements Runnable
{
  FtnListActivity$48(FtnListActivity paramFtnListActivity, FtnUploadInfo paramFtnUploadInfo, int paramInt, double paramDouble) {}
  
  public void run()
  {
    FtnListActivity.access$900(this.this$0).updateUploadProgressBar(this.val$uploadItem, this.val$proc, this.val$fact);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.48
 * JD-Core Version:    0.7.0.1
 */