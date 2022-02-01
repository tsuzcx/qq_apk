package com.tencent.qqmail.model.media;

import android.app.Activity;
import com.tencent.qqmail.BaseActivityImpl.PageProvider;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.utilities.ui.QMTips;

class QMUploadImageManager$5
  implements Runnable
{
  QMUploadImageManager$5(QMUploadImageManager paramQMUploadImageManager, String paramString) {}
  
  public void run()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if ((localActivity != null) && ((localActivity instanceof BaseActivityImpl.PageProvider))) {
      ((BaseActivityImpl.PageProvider)localActivity).getTips().showError(this.val$hint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.5
 * JD-Core Version:    0.7.0.1
 */