package com.tencent.tim.filemanager.activity;

import android.os.Handler;
import atol;

public class FilePreviewActivity$9$1
  implements Runnable
{
  public FilePreviewActivity$9$1(atol paramatol) {}
  
  public void run()
  {
    if (this.a.this$0.ccR)
    {
      this.a.this$0.dfk();
      return;
    }
    this.a.this$0.dfl();
    this.a.this$0.dfk();
    new Handler().postDelayed(new FilePreviewActivity.9.1.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.9.1
 * JD-Core Version:    0.7.0.1
 */