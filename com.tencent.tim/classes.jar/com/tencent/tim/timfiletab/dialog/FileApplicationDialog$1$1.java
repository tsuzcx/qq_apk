package com.tencent.tim.timfiletab.dialog;

import android.widget.ProgressBar;
import aunl;
import aunm;

public class FileApplicationDialog$1$1
  implements Runnable
{
  public FileApplicationDialog$1$1(aunm paramaunm, Long paramLong1, Long paramLong2) {}
  
  public void run()
  {
    if (this.al.longValue() <= 0L) {}
    for (int i = 0;; i = (int)(this.am.longValue() * 100L / this.al.longValue()))
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (this.am.longValue() > 0L) {
          j = 2;
        }
      }
      aunl.a(this.a.a).setProgress(j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.timfiletab.dialog.FileApplicationDialog.1.1
 * JD-Core Version:    0.7.0.1
 */