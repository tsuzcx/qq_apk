package com.tencent.tim.filemanager.core;

import atum;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

public class QfavFilePreviewController$2
  implements Runnable
{
  public void run()
  {
    if (3 != atum.b(this.this$0))
    {
      this.this$0.a.a(false, atum.a(this.this$0), String.valueOf(atum.a(this.this$0)), atum.a(this.this$0), null, atum.b(this.this$0), null, atum.c(this.this$0));
      atum.b(this.this$0, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.QfavFilePreviewController.2
 * JD-Core Version:    0.7.0.1
 */