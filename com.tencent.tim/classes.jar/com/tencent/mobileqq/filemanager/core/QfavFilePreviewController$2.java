package com.tencent.mobileqq.filemanager.core;

import aglu;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(aglu paramaglu) {}
  
  public void run()
  {
    if (3 != aglu.b(this.this$0))
    {
      this.this$0.a.a(false, aglu.a(this.this$0), String.valueOf(aglu.a(this.this$0)), aglu.a(this.this$0), null, aglu.b(this.this$0), null, aglu.c(this.this$0), null);
      aglu.b(this.this$0, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.2
 * JD-Core Version:    0.7.0.1
 */