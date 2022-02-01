package com.tencent.mobileqq.filemanager.activity;

import agbp;
import android.widget.TextView;

public class FilePreviewActivity$16$1
  implements Runnable
{
  public FilePreviewActivity$16$1(agbp paramagbp, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!this.a.this$0.akS()) {
      return;
    }
    String str = String.valueOf(this.cWF) + "/" + String.valueOf(this.val$pageCount);
    this.a.this$0.Sg.setText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.1
 * JD-Core Version:    0.7.0.1
 */