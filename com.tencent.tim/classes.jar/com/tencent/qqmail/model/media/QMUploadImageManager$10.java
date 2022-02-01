package com.tencent.qqmail.model.media;

import android.app.Activity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.media.IMediaInterface;

class QMUploadImageManager$10
  implements Runnable
{
  QMUploadImageManager$10(QMUploadImageManager paramQMUploadImageManager) {}
  
  public void run()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if ((localActivity instanceof IMediaInterface))
    {
      ((IMediaInterface)localActivity).resetAddButton(true);
      ((IMediaInterface)localActivity).finishMedia();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.10
 * JD-Core Version:    0.7.0.1
 */