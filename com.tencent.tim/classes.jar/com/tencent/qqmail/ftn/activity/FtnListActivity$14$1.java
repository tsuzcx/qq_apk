package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;

class FtnListActivity$14$1
  implements Runnable
{
  FtnListActivity$14$1(FtnListActivity.14 param14, int paramInt, FtnUploadInfo paramFtnUploadInfo) {}
  
  public void run()
  {
    if (this.val$cgiException == 5)
    {
      this.this$1.this$0.updateUploadItemState(this.val$uploadItemData, 3);
      return;
    }
    this.this$1.this$0.updateUploadItemState(this.val$uploadItemData, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.14.1
 * JD-Core Version:    0.7.0.1
 */