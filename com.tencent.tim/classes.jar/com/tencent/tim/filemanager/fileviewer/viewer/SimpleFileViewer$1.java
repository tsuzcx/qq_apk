package com.tencent.tim.filemanager.fileviewer.viewer;

import android.widget.TextView;
import aucs;
import audx;

public class SimpleFileViewer$1
  implements Runnable
{
  public SimpleFileViewer$1(aucs paramaucs, String paramString) {}
  
  public void run()
  {
    aucs.a(this.this$0).setText(audx.a(this.val$fileName, false, aucs.a(this.this$0).getMeasuredWidth(), aucs.a(this.this$0).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.viewer.SimpleFileViewer.1
 * JD-Core Version:    0.7.0.1
 */