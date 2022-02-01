package com.tencent.tim.filemanager.activity;

import atok;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.widget.FileWebView;

public class FilePreviewActivity$8$1
  implements Runnable
{
  public FilePreviewActivity$8$1(atok paramatok) {}
  
  public void run()
  {
    try
    {
      this.a.this$0.a.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.8.1
 * JD-Core Version:    0.7.0.1
 */