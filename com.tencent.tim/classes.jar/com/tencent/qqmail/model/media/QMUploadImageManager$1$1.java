package com.tencent.qqmail.model.media;

import android.app.Activity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.media.IMediaInterface;

class QMUploadImageManager$1$1
  implements Runnable
{
  QMUploadImageManager$1$1(QMUploadImageManager.1 param1) {}
  
  public void run()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if ((localActivity instanceof IMediaInterface)) {
      ((IMediaInterface)localActivity).onSizeTooLarge();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.1.1
 * JD-Core Version:    0.7.0.1
 */