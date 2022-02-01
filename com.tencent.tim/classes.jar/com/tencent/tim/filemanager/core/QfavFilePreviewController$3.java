package com.tencent.tim.filemanager.core;

import atum;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(atum paramatum) {}
  
  public void run()
  {
    FilePreviewActivity.a locala = this.this$0.a;
    if (0L == atum.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.a(bool, atum.a(this.this$0), String.valueOf(atum.a(this.this$0)), atum.a(this.this$0), null, atum.b(this.this$0), null, atum.c(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + atum.a(this.this$0) + ", port=" + atum.a(this.this$0) + ", key=" + atum.b(this.this$0) + ", retCode =" + atum.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */