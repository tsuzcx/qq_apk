package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import agrj;
import agrj.a;
import com.tencent.kwstudio.office.preview.TdsReaderView;

class SimpleFileViewer$7
  implements Runnable
{
  SimpleFileViewer$7(SimpleFileViewer paramSimpleFileViewer, String paramString, agrj.a parama) {}
  
  public void run()
  {
    TdsReaderView localTdsReaderView = agrj.a().a(this.this$0.mContext, this.val$filePath, this.c);
    if ((SimpleFileViewer.a(this.this$0) != null) && (SimpleFileViewer.a(this.this$0, SimpleFileViewer.a(this.this$0), localTdsReaderView, false))) {
      SimpleFileViewer.a(this.this$0, localTdsReaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.7
 * JD-Core Version:    0.7.0.1
 */