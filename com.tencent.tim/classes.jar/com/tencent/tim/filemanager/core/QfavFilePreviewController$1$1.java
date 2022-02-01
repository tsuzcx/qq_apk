package com.tencent.tim.filemanager.core;

import android.os.Bundle;
import atum;
import atun;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(atun paramatun, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    atum.a(this.a.this$0, this.aR.getInt("previewPort", 80));
    atum.a(this.a.this$0, this.aR.getLong("previewCode", 0L));
    atum.a(this.a.this$0, this.aR.getString("previewUid"));
    atum.b(this.a.this$0, this.aR.getString("previewHost"));
    atum.c(this.a.this$0, this.aR.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + atum.a(this.a.this$0) + ", port=" + String.valueOf(atum.a(this.a.this$0)) + ", key=" + atum.b(this.a.this$0) + ", retCode =" + String.valueOf(atum.a(this.a.this$0)));
    }
    FilePreviewActivity.a locala;
    if (1 == atum.b(this.a.this$0))
    {
      locala = this.a.this$0.a;
      if (0L != atum.a(this.a.this$0)) {
        break label320;
      }
    }
    for (;;)
    {
      locala.a(bool, atum.a(this.a.this$0), String.valueOf(atum.a(this.a.this$0)), atum.a(this.a.this$0), null, atum.b(this.a.this$0), null, atum.c(this.a.this$0));
      atum.b(this.a.this$0, 3);
      return;
      label320:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */