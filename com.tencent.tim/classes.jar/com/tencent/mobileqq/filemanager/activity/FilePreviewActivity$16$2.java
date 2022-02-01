package com.tencent.mobileqq.filemanager.activity;

import agbp;
import com.tencent.qphone.base.util.QLog;

public class FilePreviewActivity$16$2
  implements Runnable
{
  public FilePreviewActivity$16$2(agbp paramagbp, int paramInt1, boolean paramBoolean, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (this.cWG == 0) {
      this.a.this$0.i(this.cS, this.val$errCode, this.aV);
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish  process Over");
      return;
      if (this.cWG == 1) {
        this.a.this$0.j(this.cS, this.val$errCode, this.aV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.2
 * JD-Core Version:    0.7.0.1
 */