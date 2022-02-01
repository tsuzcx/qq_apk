package com.tencent.tim.filemanager.fileviewer;

import android.text.TextUtils.TruncateAt;
import android.widget.TextView;

class FileBrowserActivity$2
  implements Runnable
{
  FileBrowserActivity$2(FileBrowserActivity paramFileBrowserActivity, String paramString) {}
  
  public void run()
  {
    FileBrowserActivity.a(this.this$0).setEllipsize(TextUtils.TruncateAt.MIDDLE);
    FileBrowserActivity.a(this.this$0).setText(this.bIU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.FileBrowserActivity.2
 * JD-Core Version:    0.7.0.1
 */