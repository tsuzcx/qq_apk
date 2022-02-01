package com.tencent.mobileqq.qzonealbumreddot;

import allp;
import alls;
import com.tencent.qphone.base.util.QLog;

public class QzonePhotoGuideNotifyService$1
  implements Runnable
{
  public QzonePhotoGuideNotifyService$1(alls paramalls) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzonePhotoGuideNotifyServlet", 2, "sendRedRunnable");
    }
    if (this.this$0.a != null) {
      this.this$0.a.dGA();
    }
    this.this$0.stopService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService.1
 * JD-Core Version:    0.7.0.1
 */