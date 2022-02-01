package com.tencent.mobileqq.filemanager.core;

import aglu;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(aglu paramaglu) {}
  
  public void run()
  {
    FilePreviewActivity.a locala = this.this$0.a;
    if (0L == aglu.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.a(bool, aglu.a(this.this$0), String.valueOf(aglu.a(this.this$0)), aglu.a(this.this$0), null, aglu.b(this.this$0), null, aglu.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + aglu.a(this.this$0) + ", port=" + aglu.a(this.this$0) + ", key=" + aglu.b(this.this$0) + ", retCode =" + aglu.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */