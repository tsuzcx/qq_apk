package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import ahav;
import android.widget.TextView;

class SimpleFileViewer$1
  implements Runnable
{
  SimpleFileViewer$1(SimpleFileViewer paramSimpleFileViewer, String paramString) {}
  
  public void run()
  {
    SimpleFileViewer.a(this.this$0).setText(ahav.a(this.val$fileName, false, SimpleFileViewer.a(this.this$0).getMeasuredWidth(), SimpleFileViewer.a(this.this$0).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.1
 * JD-Core Version:    0.7.0.1
 */