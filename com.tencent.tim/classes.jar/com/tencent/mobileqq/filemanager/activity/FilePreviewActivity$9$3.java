package com.tencent.mobileqq.filemanager.activity;

import agbz;
import android.os.Handler;
import android.widget.TextView;

public class FilePreviewActivity$9$3
  implements Runnable
{
  public FilePreviewActivity$9$3(agbz paramagbz) {}
  
  public void run()
  {
    this.a.val$handler.removeCallbacksAndMessages(null);
    try
    {
      String str = (String)this.a.this$0.Sg.getText();
      if ((str == null) || (str.length() == 0)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
      this.a.this$0.Sg.clearAnimation();
      this.a.this$0.Sg.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.3
 * JD-Core Version:    0.7.0.1
 */