package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.widget.RelativeLayout;

class SimpleFileViewer$3
  implements Runnable
{
  SimpleFileViewer$3(SimpleFileViewer paramSimpleFileViewer) {}
  
  public void run()
  {
    if (this.this$0.CS != SimpleFileViewer.c(this.this$0)) {
      this.this$0.CS = SimpleFileViewer.c(this.this$0);
    }
    if (SimpleFileViewer.a(this.this$0) != null)
    {
      SimpleFileViewer.a(this.this$0).removeAllViews();
      SimpleFileViewer.a(this.this$0, null);
    }
    SimpleFileViewer.c(this.this$0, null);
    SimpleFileViewer.a(this.this$0, null);
    SimpleFileViewer.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.3
 * JD-Core Version:    0.7.0.1
 */