package com.tencent.qqmail.model.media;

import android.app.Activity;
import com.tencent.qqmail.BaseActivityImpl.PageProvider;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.media.IMediaInterface;

class QMUploadImageManager$4
  implements Runnable
{
  QMUploadImageManager$4(QMUploadImageManager paramQMUploadImageManager, int paramInt) {}
  
  public void run()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if ((localActivity != null) && ((localActivity instanceof BaseActivityImpl.PageProvider))) {
      ((IMediaInterface)localActivity).updateUploadProcess(this.val$process);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.4
 * JD-Core Version:    0.7.0.1
 */