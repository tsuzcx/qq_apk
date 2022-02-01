package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import agrd;
import agrd.a;
import com.tencent.tbs.reader.TbsReaderView;

class SimpleFileViewer$5
  implements Runnable
{
  SimpleFileViewer$5(SimpleFileViewer paramSimpleFileViewer, String paramString, agrd.a parama) {}
  
  public void run()
  {
    TbsReaderView localTbsReaderView = agrd.a().a(this.this$0.mContext, this.val$filePath, this.c);
    if ((SimpleFileViewer.a(this.this$0) != null) && (SimpleFileViewer.a(this.this$0, SimpleFileViewer.a(this.this$0), localTbsReaderView, true))) {
      SimpleFileViewer.a(this.this$0, localTbsReaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.5
 * JD-Core Version:    0.7.0.1
 */