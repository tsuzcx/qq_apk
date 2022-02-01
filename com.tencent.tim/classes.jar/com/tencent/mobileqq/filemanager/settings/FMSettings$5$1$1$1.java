package com.tencent.mobileqq.filemanager.settings;

import ahah;
import ahai;
import android.widget.ProgressBar;

public class FMSettings$5$1$1$1
  implements Runnable
{
  public FMSettings$5$1$1$1(ahai paramahai, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.a.a.af.setVisibility(0);
    float f = (float)this.val$pos / (float)this.val$total;
    this.a.a.af.setProgress((int)(f * 100.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.5.1.1.1
 * JD-Core Version:    0.7.0.1
 */