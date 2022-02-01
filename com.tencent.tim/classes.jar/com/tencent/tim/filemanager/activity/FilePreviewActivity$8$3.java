package com.tencent.tim.filemanager.activity;

import android.os.Handler;
import android.widget.TextView;
import atok;

public class FilePreviewActivity$8$3
  implements Runnable
{
  public FilePreviewActivity$8$3(atok paramatok) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.8.3
 * JD-Core Version:    0.7.0.1
 */