package com.tencent.mobileqq.intervideo.huayang;

import aido;
import android.os.Handler;

public class HuayangPluginLauncher$3
  implements Runnable
{
  private int progress;
  
  public HuayangPluginLauncher$3(aido paramaido) {}
  
  public void run()
  {
    aido.a(this.this$0, this.progress);
    this.progress += 20;
    if (this.progress < 80) {
      aido.a(this.this$0).postDelayed(this, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.3
 * JD-Core Version:    0.7.0.1
 */