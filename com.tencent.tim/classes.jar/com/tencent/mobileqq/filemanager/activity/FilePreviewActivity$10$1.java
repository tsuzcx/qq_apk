package com.tencent.mobileqq.filemanager.activity;

import agbo;
import android.os.Handler;

public class FilePreviewActivity$10$1
  implements Runnable
{
  public FilePreviewActivity$10$1(agbo paramagbo) {}
  
  public void run()
  {
    if (this.a.this$0.ccR)
    {
      this.a.this$0.dfk();
      return;
    }
    this.a.this$0.dfl();
    this.a.this$0.dfk();
    new Handler().postDelayed(new FilePreviewActivity.10.1.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.10.1
 * JD-Core Version:    0.7.0.1
 */