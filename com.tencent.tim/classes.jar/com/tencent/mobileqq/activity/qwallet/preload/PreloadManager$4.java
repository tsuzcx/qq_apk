package com.tencent.mobileqq.activity.qwallet.preload;

import aquy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.TimerTask;

class PreloadManager$4
  extends TimerTask
{
  PreloadManager$4(PreloadManager paramPreloadManager, WeakReference paramWeakReference, List paramList, aquy paramaquy) {}
  
  public void run()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.eO.get();
    if (PreloadManager.a(localPreloadManager)) {
      PreloadManager.a(localPreloadManager, this.vg, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.4
 * JD-Core Version:    0.7.0.1
 */