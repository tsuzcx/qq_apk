package com.tencent.tim.filemanager.activity;

import atol;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.widget.FileWebView;

class FilePreviewActivity$9$1$1
  implements Runnable
{
  FilePreviewActivity$9$1$1(FilePreviewActivity.9.1 param1) {}
  
  public void run()
  {
    this.a.a.this$0.Yk = System.currentTimeMillis();
    try
    {
      this.a.a.this$0.a.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.9.1.1
 * JD-Core Version:    0.7.0.1
 */