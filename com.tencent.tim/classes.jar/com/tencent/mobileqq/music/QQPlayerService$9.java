package com.tencent.mobileqq.music;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class QQPlayerService$9
  implements Runnable
{
  QQPlayerService$9(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    if (QQPlayerService.access$500() == 5) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "===========> timeout retry to check playState:" + QQPlayerService.bA(QQPlayerService.access$500()) + ",needRetryPlay:" + bool);
      }
      int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "QmusicHlsMaxRetryTimes", 3);
      if ((bool) && (QQPlayerService.g() != null) && (!TextUtils.isEmpty(QQPlayerService.g().url)) && (QQPlayerService.gG() < i))
      {
        QQPlayerService.Gu();
        QQPlayerService.a(this.this$0, QQPlayerService.g().url);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.9
 * JD-Core Version:    0.7.0.1
 */