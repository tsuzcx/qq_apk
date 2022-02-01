package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$13$2
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$13$2(QMCalendarManager.13 param13) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "getVerifyImage success verifyId:" + this.this$1.val$verifyId + " verifyKey:" + this.this$1.val$verifyKey);
    if ((paramObject2 instanceof QMVerify))
    {
      paramObject1 = (QMVerify)paramObject2;
      ((QMGetVerifyImageWatcher)Watchers.of(QMGetVerifyImageWatcher.class)).onSuccess(this.this$1.val$verifyId, this.this$1.val$verifyKey, paramObject1.getImageUrl(), paramObject1.getVerifySession(), paramObject1.getAuthImagesId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.13.2
 * JD-Core Version:    0.7.0.1
 */