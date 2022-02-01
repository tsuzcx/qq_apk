package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.os.Build.VERSION;
import android.widget.ListView;

class FileExplorer$3
  implements Runnable
{
  FileExplorer$3(FileExplorer paramFileExplorer) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      FileExplorer.access$1200(this.this$0).smoothScrollToPosition(0, 0);
      return;
    }
    FileExplorer.access$1200(this.this$0).setSelection(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.FileExplorer.3
 * JD-Core Version:    0.7.0.1
 */