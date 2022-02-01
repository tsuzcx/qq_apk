package com.tencent.qqmail.model.media;

import com.tencent.qqmail.BaseActivityImpl.PageProvider;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.utilities.ui.QMTips;

class QMUploadImageManager$3
  implements Runnable
{
  QMUploadImageManager$3(QMUploadImageManager paramQMUploadImageManager, String paramString) {}
  
  public void run()
  {
    Object localObject = QMActivityManager.shareInstance().getVisibleActivity();
    if ((localObject != null) && ((localObject instanceof BaseActivityImpl.PageProvider)))
    {
      localObject = (BaseActivityImpl.PageProvider)QMActivityManager.shareInstance().getVisibleActivity();
      if (localObject != null) {
        ((BaseActivityImpl.PageProvider)localObject).getTips().showSuccess(this.val$hint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.3
 * JD-Core Version:    0.7.0.1
 */