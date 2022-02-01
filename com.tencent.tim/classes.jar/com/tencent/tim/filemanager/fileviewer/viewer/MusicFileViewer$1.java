package com.tencent.tim.filemanager.fileviewer.viewer;

import android.widget.TextView;
import aucq;
import audx;

public class MusicFileViewer$1
  implements Runnable
{
  public MusicFileViewer$1(aucq paramaucq, String paramString) {}
  
  public void run()
  {
    aucq.a(this.this$0).setText(audx.a(this.val$fileName, false, aucq.a(this.this$0).getMeasuredWidth(), aucq.a(this.this$0).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.viewer.MusicFileViewer.1
 * JD-Core Version:    0.7.0.1
 */