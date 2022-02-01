package com.tencent.mobileqq.filemanager.core;

import aglu;
import aglv;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(aglv paramaglv, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    aglu.a(this.a.this$0, this.aR.getInt("previewPort", 80));
    aglu.a(this.a.this$0, this.aR.getLong("previewCode", 0L));
    aglu.a(this.a.this$0, this.aR.getString("previewUid"));
    aglu.b(this.a.this$0, this.aR.getString("previewHost"));
    aglu.c(this.a.this$0, this.aR.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + aglu.a(this.a.this$0) + ", port=" + String.valueOf(aglu.a(this.a.this$0)) + ", key=" + aglu.b(this.a.this$0) + ", retCode =" + String.valueOf(aglu.a(this.a.this$0)));
    }
    FilePreviewActivity.a locala;
    if (1 == aglu.b(this.a.this$0))
    {
      locala = this.a.this$0.a;
      if (0L != aglu.a(this.a.this$0)) {
        break label321;
      }
    }
    for (;;)
    {
      locala.a(bool, aglu.a(this.a.this$0), String.valueOf(aglu.a(this.a.this$0)), aglu.a(this.a.this$0), null, aglu.b(this.a.this$0), null, aglu.c(this.a.this$0), null);
      aglu.b(this.a.this$0, 3);
      return;
      label321:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */