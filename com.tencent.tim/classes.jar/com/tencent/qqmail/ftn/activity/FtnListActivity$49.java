package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.concurrent.atomic.AtomicBoolean;

class FtnListActivity$49
  implements Runnable
{
  FtnListActivity$49(FtnListActivity paramFtnListActivity, FtnUploadInfo paramFtnUploadInfo) {}
  
  public void run()
  {
    this.val$uploadItem.needFlushProgress.getAndSet(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.49
 * JD-Core Version:    0.7.0.1
 */