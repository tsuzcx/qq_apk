package com.tencent.mobileqq.filemanager.activity;

import agbw;
import ahau;
import ahau.a;
import ahbj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

public class FilePreviewActivity$6$1
  implements Runnable
{
  public FilePreviewActivity$6$1(agbw paramagbw) {}
  
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
      ahau.a locala = new ahau.a();
      locala.bJE = "sf_preview_again";
      locala.bJF = ahbj.getExtension(this.a.this$0.bGq);
      locala.nFileSize = this.a.this$0.uFileSize;
      ahau.a(this.a.this$0.app.getCurrentAccountUin(), locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1
 * JD-Core Version:    0.7.0.1
 */