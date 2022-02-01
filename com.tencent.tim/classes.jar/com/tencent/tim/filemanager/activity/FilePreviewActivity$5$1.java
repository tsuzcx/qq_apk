package com.tencent.tim.filemanager.activity;

import atoh;
import audw;
import audw.b;
import aueh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.widget.FileWebView;

public class FilePreviewActivity$5$1
  implements Runnable
{
  public FilePreviewActivity$5$1(atoh paramatoh) {}
  
  public void run()
  {
    if ((this.a.this$0.bGu == null) || (this.a.this$0.bGu.length() == 0))
    {
      this.a.this$0.ccO = false;
      FilePreviewActivity.a(this.a.this$0);
      return;
    }
    String str1;
    if (this.a.this$0.ccL)
    {
      str1 = "javascript:qpreview.onClientResponse('showFileList', {})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str1 + ")");
      audw.b localb = new audw.b();
      localb.bJE = "sf_preview_again";
      localb.bJF = aueh.getExtension(this.a.this$0.bGq);
      localb.nFileSize = this.a.this$0.uFileSize;
      audw.a(this.a.this$0.app.getCurrentAccountUin(), localb);
      try
      {
        this.a.this$0.a.loadUrl(str1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str2 = "javascript:qpreview.onClientResponse('addMorePage',{})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.5.1
 * JD-Core Version:    0.7.0.1
 */